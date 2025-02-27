package com.orion.mdd.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @Size(min = 2, max = 30, message = "Username must contain between 2 and 30 characters")
    private String username;

    @Email(message = "Email must be valid")
    private String email;
}
