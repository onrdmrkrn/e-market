package com.kitapyurdu.auth.controller;

import com.kitapyurdu.auth.dto.CommunicateInformationDto;
import com.kitapyurdu.auth.entity.CommunicateInformation;
import com.kitapyurdu.auth.response.CommunicateInformationResponse;
import com.kitapyurdu.auth.response.Meta;
import com.kitapyurdu.auth.service.CommunicateInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/communicateInformation")
public class CommunicateInformationController {
    @Autowired
    CommunicateInformationService service;


    @PostMapping("/add")
    public CommunicateInformationResponse add(@RequestBody CommunicateInformationDto dto) {
        CommunicateInformationResponse response = new CommunicateInformationResponse();
        Meta meta = new Meta();
        try {
            CommunicateInformationDto dto1 = service.add(dto);
            response.dto = dto1;
            meta.errorCode = 200;
            meta.errorDesc = "Başarılı";
        } catch (Exception e) {
            meta.errorCode = 4002;
            meta.errorDesc = "Başarısız";
        }
        response.meta = meta;
        return response;
    }

    @GetMapping("/delete/{communicateInformationId}")
    public String delete(@PathVariable(value = "communicateInformationId") String communicateInformationId) {
        return service.delete(communicateInformationId);
    }

}
