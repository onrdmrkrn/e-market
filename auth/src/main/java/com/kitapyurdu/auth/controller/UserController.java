package com.kitapyurdu.auth.controller;

import com.kitapyurdu.auth.dto.UserDto;
import com.kitapyurdu.auth.entity.User;
import com.kitapyurdu.auth.exception.UserLoginException;
import com.kitapyurdu.auth.exception.UserRegisterException;
import com.kitapyurdu.auth.response.Meta;
import com.kitapyurdu.auth.response.UserResponse;
import com.kitapyurdu.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService service;

    @PostMapping("/register")
    public UserResponse register(@RequestBody UserDto dto) throws UserRegisterException {
        return service.register(dto);

    }

    @PostMapping("/login")
    public UserResponse login(@RequestBody UserDto dto) throws UserLoginException {
        return service.login(dto);
    }

    @GetMapping("/find/{userId}")
    public UserDto find(@PathVariable(value = "userId") int userId){
        return  service.find(userId);

    }

}
