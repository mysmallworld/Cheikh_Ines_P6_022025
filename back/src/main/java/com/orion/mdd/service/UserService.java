package com.orion.mdd.service;

import com.orion.mdd.dto.response.UserResponse;
import com.orion.mdd.mapper.UserMapper;
import com.orion.mdd.model.User;
import com.orion.mdd.repository.UserRepository;
import com.orion.mdd.security.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private JWTService jwtService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    public UserResponse getUser(String authorizationHeader) {
        try {
            if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Authorization header must start with Bearer");
            }
            String token = authorizationHeader.substring(7);

            Map<String, Object> userToken = jwtService.decodeToken(token);
            String userEmail = (String) userToken.get("sub");
            User user = userRepository.findByEmail(userEmail);

            if (user == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
            }

            UserResponse userResponseDto = userMapper.toDto(user);

            return userResponseDto;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }

    public UserResponse getUserById(UUID id) {
        try {
            Optional<User> optionalUser = userRepository.findById(id);

            if (optionalUser.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
            }

            User user = optionalUser.get();

            UserResponse userResponseDto = userMapper.toDto(user);

            return userResponseDto;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }
}
