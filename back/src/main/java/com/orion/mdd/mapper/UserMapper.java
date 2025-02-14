package com.orion.mdd.mapper;

import com.orion.mdd.dto.request.LoginDto;
import com.orion.mdd.dto.request.RegisterDto;
import com.orion.mdd.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toEntity(RegisterDto registerDto){
        if(registerDto == null){
            return null;
        }
        User user = new User();
        user.setEmail(registerDto.getEmail());
        user.setPassword(registerDto.getPassword());
        user.setUsername(registerDto.getUsername());

        return user;
    }

    public User toEntity(LoginDto loginDto){
        if(loginDto == null){
            return null;
        }
        User user = new User();
        if(loginDto.getEmailOrUsername().contains("@")){
            user.setEmail(loginDto.getEmailOrUsername());
        }else {
            user.setUsername(loginDto.getEmailOrUsername());
        }
        user.setPassword(loginDto.getPassword());

        return user;
    }
}
