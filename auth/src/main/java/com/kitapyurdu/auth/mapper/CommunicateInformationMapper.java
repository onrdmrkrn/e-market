package com.kitapyurdu.auth.mapper;

import com.kitapyurdu.auth.dto.CommunicateInformationDto;
import com.kitapyurdu.auth.entity.CommunicateInformation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommunicateInformationMapper extends IEntityMapper<CommunicateInformationDto, CommunicateInformation> {
}
