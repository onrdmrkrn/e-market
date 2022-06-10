package com.kitapyurdu.auth.service;

import com.kitapyurdu.auth.dto.BasketDto;
import com.kitapyurdu.auth.dto.UserDto;
import com.kitapyurdu.auth.entity.User;
import com.kitapyurdu.auth.exception.UserLoginException;
import com.kitapyurdu.auth.exception.UserRegisterException;
import com.kitapyurdu.auth.mapper.UserMapper;
import com.kitapyurdu.auth.repository.UserRepository;
import com.kitapyurdu.auth.response.BasketResponse;
import com.kitapyurdu.auth.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    @Autowired
    UserRepository repository;
    @Autowired
    UserMapper userMapper;

    public BasketResponse takeAllActiveBasket(int basketId){
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.getForObject("http://localhost:9120/basket/getBasket/{{basketId}}"+basketId, BasketResponse.class);
    }

    public UserResponse register(UserDto dto) throws UserRegisterException {
        User user = userMapper.toEntity(dto);
        user = repository.save(user);
        if (user == null) {
            throw new UserRegisterException();
        }
        return generateUserResult(userMapper.toResource(user));

    }

    public UserResponse login(UserDto dto) throws UserLoginException {
        User user = repository.findUserByMailAndPassword(dto.mail, dto.password);
        if (user == null) {
            throw new UserLoginException();
        }
        return generateUserResult(userMapper.toResource(user));

    }

    private UserResponse generateUserResult(UserDto toResource) {
        UserResponse response = new UserResponse();
        response.dto = toResource;
        return response;
    }

    public UserDto find(int userId) {
        User user=findCategory(userId);
        UserDto userDto = userMapper.toResource(user);
        return userDto;
    }

    public User findCategory(int userId) {
        User user=repository.findUserByUserId(userId);
        return user;
    }
}
