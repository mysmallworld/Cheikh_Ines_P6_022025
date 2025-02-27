package com.orion.mdd.controller;

import com.orion.mdd.dto.request.UserDto;
import com.orion.mdd.dto.response.SuccessResponse;
import com.orion.mdd.dto.response.UserResponse;
import com.orion.mdd.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(
            summary = "Get a user by token",
            description = "Allows a user to get his informations."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User informations"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @GetMapping
    public ResponseEntity<UserResponse> getUserByToken(@RequestHeader("Authorization") String token) {
        UserResponse userResponseDto = userService.getUserByToken(token);
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    @Operation(
            summary = "Update a user",
            description = "Allows a user to update his profile."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @PutMapping
    public ResponseEntity<SuccessResponse> updateUser(@Valid @RequestBody UserDto userDto,
                                                      @RequestHeader("Authorization") String token
                                                      ){
        UUID userId = userService.getUserByToken(token).getId();
        String userUpdated = userService.updateUser(userId, userDto);
        SuccessResponse successResponse = SuccessResponse.builder().message(userUpdated).build();
        return new ResponseEntity<>(successResponse, HttpStatus.OK);
    }
}
