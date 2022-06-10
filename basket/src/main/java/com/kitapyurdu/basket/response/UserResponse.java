package com.kitapyurdu.basket.response;


import com.kitapyurdu.basket.dto.UserDto;

import java.io.Serializable;

public class UserResponse extends BaseResponse implements Serializable {
    public UserDto dto;
}
