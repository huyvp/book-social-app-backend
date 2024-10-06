package com.identity.mapper;

import com.identity.dto.request.PermissionRequest;
import com.identity.dto.response.PermissionResponse;
import com.identity.entity.Permission;
import org.mapstruct.Mapper;

@Mapper
public interface PermissionMapper {
    Permission toPermissionFromPermissionReq(PermissionRequest permissionRequest);

    PermissionResponse toPermissionResFromPermission(Permission permission);
}
