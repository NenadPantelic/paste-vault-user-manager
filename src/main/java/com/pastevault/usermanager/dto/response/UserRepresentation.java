package com.pastevault.usermanager.dto.response;

import com.pastevault.usermanager.model.Role;
import lombok.Builder;

@Builder
public record UserRepresentation(String id,
                                 String firstName,
                                 String lastName,
                                 String email,
                                 String username,
                                 String password,
                                 Role role) {
}
