package com.cgesgin.locationmanagmentapi.core.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserLoginDto {
    
    @Email(message = "Invalid email")
    private String email;
    
    @NotBlank(message = "Invalid password: Empty name")
    @NotNull(message = "Invalid password: Surname is NULL")
    @Size(min = 3, max = 30, message = "Invalid password: Must be of 3 - 30 characters")
    private String password;
}
