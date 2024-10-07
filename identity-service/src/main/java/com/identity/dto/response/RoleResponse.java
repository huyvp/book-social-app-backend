package com.identity.dto.response;

import java.util.Set;


public record RoleResponse(String name, String description, Set<PermissionResponse> permissions) {
}
