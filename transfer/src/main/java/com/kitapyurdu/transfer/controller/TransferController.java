package com.kitapyurdu.transfer.controller;

import com.kitapyurdu.transfer.dto.TransferDto;
import com.kitapyurdu.transfer.response.TransferResponse;
import com.kitapyurdu.transfer.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transfer")
public class TransferController {
    @Autowired
    TransferService transferService;

    @PostMapping("/feedBack")
    public TransferResponse feedBack(@RequestBody TransferDto transferDto){
        return transferService.feedBack(transferDto);
    }




}
