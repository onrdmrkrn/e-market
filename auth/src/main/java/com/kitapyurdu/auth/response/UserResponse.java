package com.kitapyurdu.auth.response;

import com.kitapyurdu.auth.dto.UserDto;

import java.io.Serializable;

public class UserResponse extends BaseResponse implements Serializable {
    public UserDto dto;
}
