package com.pastevault.usermanager.dto.response;

import com.pastevault.usermanager.model.Role;
import lombok.Builder;

@Builder
public record UserRepresentation(int id,
                                 String firstName,
                                 String lastName,
                                 String email,
                                 String username,
                                 Role role) {
}
