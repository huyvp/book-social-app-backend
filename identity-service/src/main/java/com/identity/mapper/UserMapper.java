package com.identity.mapper;

import com.identity.dto.request.UserRequest;
import com.identity.dto.response.UserResponse;
import com.identity.entity.Role;
import com.identity.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.lang.annotation.Target;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUserFromUserReq(UserRequest userRequest);

    @Mapping(source = "roles", target = "roles", qualifiedByName = "mapRoleToString")
    UserResponse toUserResFromUser(User user);

    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserRequest userRequest);

    @Named("mapRoleToString")
    default Set<String> mapRoleToString(Set<Role> roles) {
        if (roles == null) return null;
        return roles.stream().map(Role::getName)
                .collect(Collectors.toSet());
    }
}
