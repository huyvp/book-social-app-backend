package com.identity.service;

import com.identity.dto.request.PermissionRequest;
import com.identity.dto.response.PermissionResponse;

import java.util.List;

public interface IPermissionService {
    PermissionResponse createPermission(PermissionRequest permissionRequest);

    void deletePermission(String permission);

    List<PermissionResponse> getAllPermission();
}
