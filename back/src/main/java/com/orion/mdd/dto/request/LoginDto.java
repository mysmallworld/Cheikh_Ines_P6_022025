package com.orion.mdd.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
    @NotBlank
    @Size(min = 2, max = 30, message = "Email or username must contain between 2 and 30 characters")
    private String emailOrUsername;

    @NotBlank
    private String password;
}
