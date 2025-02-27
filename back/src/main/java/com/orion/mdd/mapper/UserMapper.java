package com.orion.mdd.mapper;

import com.orion.mdd.dto.request.RegisterDto;
import com.orion.mdd.dto.response.UserResponse;
import com.orion.mdd.model.User;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserMapper {
    public UserResponse toDto(User user) {
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail()
        );
    }

    public User toEntity(RegisterDto registerDto){
        if(registerDto == null){
            return null;
        }
        return User.builder()
                .id(UUID.randomUUID())
                .email(registerDto.getEmail())
                .password(registerDto.getPassword())
                .username(registerDto.getUsername())
                .build();
    }
}
