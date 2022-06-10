package com.kitapyurdu.payment.service;
import com.kitapyurdu.payment.dto.BasketDto;
import com.kitapyurdu.payment.dto.DoPayDto;
import com.kitapyurdu.payment.dto.PaymentDto;
import com.kitapyurdu.payment.dto.TransferDto;
import com.kitapyurdu.payment.mapper.PaymentMapper;
import com.kitapyurdu.payment.response.*;

import com.kitapyurdu.payment.repository.PaymentRepository;
import com.kitapyurdu.payment.response.BasketResponse;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentService {
    @Autowired
    PaymentMapper paymentMapper;
    @Autowired
    PaymentRepository paymentRepository;

    public BasketResponse sendRequestBasketService(int basketId){
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.getForObject("http://localhost:9120/basket/getBasket/"+basketId,BasketResponse.class);
    }

    public BasketResponse sendRequestUpdateBasket(BasketDto basketDto){
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.getForObject("http://localhost:9120/basket/updateBasket"+basketDto,BasketResponse.class);
    }

    public TransferResponse sendRequestTransferService(int basketId){
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.getForObject("http://localhost:9116/transfer/feedBack"+ basketId ,TransferResponse.class);
    }

    public PaymentResponse doPay(DoPayDto doPay) {
        Meta meta = new Meta();
        meta.errorCode = 200;
        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.meta = meta;
        BasketResponse result = sendRequestBasketService(doPay.basketId);
        if (doPay.success) {
            result.basket.status=1;
            //TODO basket ms updateBasketi buraya çağır.
            BasketResponse basketResponse = sendRequestUpdateBasket(result.basket);
            if (basketResponse.meta.errorCode != 200) {
                paymentResponse.meta.errorCode = 4000;
                paymentResponse.meta.errorDesc = "Sepet güncellenemediği için ödemeye devam edilemedi.";
            } else {
                TransferResponse transferResponse1 = sendRequestTransferService(result.basket.basketId);


                if (transferResponse1.meta.errorCode == 200) {
                    paymentResponse.meta.errorCode = 200;
                    paymentResponse.meta.errorDesc = "Başarılı.";
                } else {
                    paymentResponse.meta.errorCode = 4001;
                    paymentResponse.meta.errorDesc = "Kargo verilemedi.";
                    result.basket.status = 0;
                    BasketResponse basketResponse1 = sendRequestUpdateBasket(result.basket);
                }
            }

        } else {
            paymentResponse.meta.errorCode = 5001;
            paymentResponse.meta.errorDesc = "Ödeme alınamadığı için işleme devam edilemedi.";
            //TODO başarsız senaryoyu calıstır. basketi güncelleme
        }
        return paymentResponse;
    }






}
