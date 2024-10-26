package com.pastevault.usermanager.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.ToString;

@ToString(exclude = "password")
public record NewUser(@NotBlank String firstName,
                      @NotBlank String lastName,
                      @NotBlank @Email String email,
                      @NotBlank String username,
                      @NotBlank String password,
                      @NotBlank String role) {
}
