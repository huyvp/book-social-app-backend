package com.identity.mapper;

import com.identity.dto.request.UserRequest;
import com.identity.dto.response.UserResponse;
import com.identity.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUserFromUserReq(UserRequest userRequest);

    UserResponse toUserResFromUser(User user);
}
