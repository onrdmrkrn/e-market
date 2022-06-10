package com.kitapyurdu.payment.controller;
import com.kitapyurdu.payment.dto.DoPayDto;
import com.kitapyurdu.payment.dto.PaymentDto;
import com.kitapyurdu.payment.response.PaymentResponse;
import com.kitapyurdu.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/pay")
public class PaymentContoller {
    @Autowired
    PaymentService paymentService;

    @PostMapping("/doPay")
    public PaymentResponse doPay(@RequestBody DoPayDto doPay){
        return paymentService.doPay(doPay);
    }

}
