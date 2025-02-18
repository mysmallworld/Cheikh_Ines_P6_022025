package com.orion.mdd.controller;

import com.orion.mdd.dto.request.LoginDto;
import com.orion.mdd.dto.request.RegisterDto;
import com.orion.mdd.dto.response.AuthResponse;
import com.orion.mdd.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Operation(
            summary = "Register a new user",
            description = "Allows a user to register."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Token JWT"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> registerUser(@Valid @RequestBody RegisterDto userDto){
        String token = authService.registerUser(userDto);
        AuthResponse registerResponse = AuthResponse.builder().token(token).build();
        return new ResponseEntity<>(registerResponse, HttpStatus.OK);
    }

    @Operation(
            summary = "Login a user",
            description = "Allows a user to login."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Token JWT"),
            @ApiResponse(responseCode = "401", description = "Bad informations")
    })
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> loginUser(@Valid @RequestBody LoginDto loginDto) {
        String token = authService.loginUser(loginDto);
        AuthResponse loginResponse = AuthResponse.builder().token(token).build();
        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
    }
}
