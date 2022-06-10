package com.kitapyurdu.help.mapper;

import com.kitapyurdu.help.dto.AnswersDto;
import com.kitapyurdu.help.entity.Answers;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnswersMapper extends IEntityMapper<AnswersDto, Answers>{
}
