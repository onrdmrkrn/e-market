package com.kitapyurdu.basket.mapper;

import com.kitapyurdu.basket.dto.UserDto;
import com.kitapyurdu.basket.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends IEntityMapper<UserDto, User> {
}
