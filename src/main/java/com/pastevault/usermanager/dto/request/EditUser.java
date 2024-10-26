package com.pastevault.usermanager.dto.request;

import jakarta.validation.constraints.NotBlank;

public record EditUser(@NotBlank String firstName,
                       @NotBlank String lastName) {
}
