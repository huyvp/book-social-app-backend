package com.identity.service;

import com.identity.dto.request.UserRequest;
import com.identity.dto.response.UserResponse;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IUserService {
    UserResponse createUser(UserRequest userRequest);

    UserResponse updateUser(String userId, UserRequest userRequest);

    void deleteUser(String id);

    List<UserResponse> getAllUsers(PageRequest pageRequest);

    UserResponse getUserById(String id);

    UserResponse getMyInfo();
}
