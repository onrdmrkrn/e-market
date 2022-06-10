package com.kitapyurdu.auth.dto;

import com.kitapyurdu.auth.entity.Profile;

import java.io.Serializable;

public class UserDto implements Serializable {
    public int userId;
    public String userName;
    public String userLastName;
    public String password;
    public String mail;
    public int profileId;
    public Profile profile;
    public int basketId;


}
