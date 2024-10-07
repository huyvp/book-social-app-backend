package com.identity.service;

import com.identity.dto.request.RoleRequest;
import com.identity.dto.response.RoleResponse;

import java.util.List;

public interface IRoleService {
    RoleResponse createRole(RoleRequest roleRequest);

    void deleteRole(String role);

    RoleResponse getRole(String role);

    List<RoleResponse> getAllRoles();
}
