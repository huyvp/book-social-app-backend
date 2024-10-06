package com.identity.mapper;

import com.identity.dto.request.RoleRequest;
import com.identity.dto.response.RoleResponse;
import com.identity.entity.Role;
import org.mapstruct.Mapper;

@Mapper
public interface RoleMapper {
    Role toRoleFormRoleReq(RoleRequest roleRequest);

    RoleResponse toRoleResFromRole(Role role);
}
