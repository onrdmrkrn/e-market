package com.kitapyurdu.transfer.service;

import com.kitapyurdu.transfer.dto.BasketDto;
import com.kitapyurdu.transfer.dto.TransferDto;
import com.kitapyurdu.transfer.entity.Transfer;
import com.kitapyurdu.transfer.mapper.TransferMapper;
import com.kitapyurdu.transfer.repository.TransferRepository;
import com.kitapyurdu.transfer.response.BasketResponse;
import com.kitapyurdu.transfer.response.Meta;
import com.kitapyurdu.transfer.response.TransferResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TransferService {

    @Autowired
    TransferRepository transferRepository;

    @Autowired
    TransferMapper transferMapper;

    public TransferDto feedbackaboutcargo(TransferDto transferDto) {
        Transfer transfer=transferMapper.toEntity(transferDto);
        transfer=transferRepository.save(transfer);
        return transferMapper.toResource(transfer);
    }
    public BasketResponse sendRequestBasketId(int basketId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:9120/basket/getBasket/" + basketId, BasketResponse.class);
    }



    public TransferResponse feedBack(TransferDto dto) {
        Meta meta = new Meta();
        meta.errorCode = 200;
        TransferResponse transferResponse = new TransferResponse();
        transferResponse.meta = meta;
        BasketResponse basketResponse = sendRequestBasketId(dto.basketId);
        if (basketResponse.basket.status == 1) {
            transferResponse.meta.errorCode = 200;
            transferResponse.meta.errorDesc = "Kargonuz yola çıkmıştır.";
        } else {
            transferResponse.meta.errorCode = 4004;
            transferResponse.meta.errorDesc = "Ürünler kargolanamadı.";
        }
        return transferResponse;
    }

}

