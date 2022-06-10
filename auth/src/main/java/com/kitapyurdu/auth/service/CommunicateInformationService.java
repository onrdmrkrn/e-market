package com.kitapyurdu.auth.service;

import com.kitapyurdu.auth.dto.CommunicateInformationDto;
import com.kitapyurdu.auth.entity.CommunicateInformation;
import com.kitapyurdu.auth.mapper.CommunicateInformationMapper;
import com.kitapyurdu.auth.repository.CommunicateInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunicateInformationService {
    @Autowired
    CommunicateInformationRepository repository;
    @Autowired
    CommunicateInformationMapper communicateInformationMapper;

    public CommunicateInformationDto add(CommunicateInformationDto dto) {
        CommunicateInformation communicateInformation = communicateInformationMapper.toEntity(dto);
        communicateInformation = repository.save(communicateInformation);
        return communicateInformationMapper.toResource(communicateInformation);
    }


    public String delete(String communicateInformationId) {
        repository.deleteById(Integer.parseInt(communicateInformationId));
        return "Silindi";
    }

}
