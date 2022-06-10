package com.kitapyurdu.auth.response;

import com.kitapyurdu.auth.dto.ProfileDto;

import java.io.Serializable;

public class ProfileResponse extends BaseResponse implements Serializable {
    public ProfileDto dto;
}
