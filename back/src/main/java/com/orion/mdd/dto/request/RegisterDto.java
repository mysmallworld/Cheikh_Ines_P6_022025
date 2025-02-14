package com.orion.mdd.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
    @NotBlank
    @Size(min = 2, max = 30, message = "Username must contain between 2 and 30 characters")
    private String username;

    @NotBlank
    @Email(message = "Email must be valid")
    private String email;

    @NotBlank
    @Pattern(
            regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&].{8,}",
            message = "Password must contain at least 8 characters, with one uppercase letter, one lowercase letter, one number and one special character."
    )
    private String password;
}
