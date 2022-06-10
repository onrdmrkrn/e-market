package com.kitapyurdu.interaction.mapper;

import com.kitapyurdu.interaction.dto.CommentsDto;
import com.kitapyurdu.interaction.entity.Comments;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CommentsMapper extends IEntityMapper<CommentsDto, Comments>{
}
