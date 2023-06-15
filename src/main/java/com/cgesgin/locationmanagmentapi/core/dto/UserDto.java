package com.cgesgin.locationmanagmentapi.core.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    
    @NotBlank(message = "Invalid Name: Empty name")
    @NotNull(message = "Invalid Name: Name is NULL")
    @Size(min = 3, max = 30, message = "Invalid Name: Must be of 3 - 30 characters")
    private String firstname;

    @NotBlank(message = "Invalid Surname: Empty name")
    @NotNull(message = "Invalid Surname: Surname is NULL")
    @Size(min = 3, max = 30, message = "Invalid Surname: Must be of 3 - 30 characters")
    private String lastname;

    @Email(message = "Invalid email")
    private String email;

    @NotBlank(message = "Invalid Phone number: Empty number")
    @NotNull(message = "Invalid Phone number: Number is NULL")
    @Pattern(regexp = "^\\d{10}$", message = "Invalid phone number")
    private String phone;
    
    @NotBlank(message = "Invalid password: Empty name")
    @NotNull(message = "Invalid password: Surname is NULL")
    @Size(min = 3, max = 30, message = "Invalid password: Must be of 3 - 30 characters")
    private String password;
}
