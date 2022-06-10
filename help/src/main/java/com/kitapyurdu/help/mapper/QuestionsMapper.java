package com.kitapyurdu.help.mapper;

import com.kitapyurdu.help.dto.QuestionsDto;
import com.kitapyurdu.help.entity.Questions;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface QuestionsMapper extends IEntityMapper <QuestionsDto, Questions>{

}
