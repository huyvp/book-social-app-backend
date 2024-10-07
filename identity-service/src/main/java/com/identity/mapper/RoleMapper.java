package com.identity.mapper;

import com.identity.dto.request.RoleRequest;
import com.identity.dto.response.RoleResponse;
import com.identity.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRoleFormRoleReq(RoleRequest roleRequest);

    RoleResponse toRoleResFromRole(Role role);
}
