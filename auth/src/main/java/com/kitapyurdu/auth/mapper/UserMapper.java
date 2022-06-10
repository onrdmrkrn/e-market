package com.kitapyurdu.auth.mapper;

import com.kitapyurdu.auth.dto.UserDto;
import com.kitapyurdu.auth.entity.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper extends IEntityMapper<UserDto, User> {
}
