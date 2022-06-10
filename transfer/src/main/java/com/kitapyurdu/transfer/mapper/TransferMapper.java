package com.kitapyurdu.transfer.mapper;

import com.kitapyurdu.transfer.dto.TransferDto;
import com.kitapyurdu.transfer.entity.Transfer;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface TransferMapper extends IEntityMapper<TransferDto, Transfer>{
}
