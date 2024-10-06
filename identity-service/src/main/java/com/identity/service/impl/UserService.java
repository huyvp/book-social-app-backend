package com.identity.service.impl;

import com.identity.dto.request.UserRequest;
import com.identity.dto.response.UserResponse;
import com.identity.entity.Role;
import com.identity.entity.User;
import com.identity.exception.ErrorCode;
import com.identity.exception.ServiceException;
import com.identity.mapper.UserMapper;
import com.identity.repo.RoleRepo;
import com.identity.repo.UserRepo;
import com.identity.service.IUserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

import static com.identity.constant.Constants.PreDefineRole.ROLE_USER;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService implements IUserService {
    UserRepo userRepo;
    UserMapper userMapper;
    RoleRepo roleRepo;
    PasswordEncoder passwordEncoder;

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        userRepo.findByUsername(userRequest.getUserName())
                .orElseThrow(() -> new ServiceException(ErrorCode.USER_3001));

        User user = userMapper.toUserFromUserReq(userRequest);
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        HashSet<Role> roles = new HashSet<>();
        roleRepo.findById(ROLE_USER).ifPresent(roles::add);
        user.setRoles(roles);

        User savedUser = userRepo.save(user);
        return userMapper.toUserResFromUser(savedUser);
    }

    @Override
    public UserResponse updateUser(String id, UserRequest userRequest) {
        return null;
    }

    @Override
    public void deleteUser(String id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new ServiceException(ErrorCode.USER_3002));
        user.setActive(false);
        userRepo.save(user);
    }

    @Override
    public List<UserResponse> getAllUsers(PageRequest pageRequest) {
        return userRepo.findAllByIsActiveTrue(pageRequest).stream()
                .map(userMapper::toUserResFromUser).toList();
    }

    @Override
    public UserResponse getUserById(String id) {
        return userMapper.toUserResFromUser(
                userRepo.findById(id)
                        .orElseThrow(() -> new ServiceException(ErrorCode.USER_3002))
        );
    }

    @Override
    public UserResponse getMyInfo() {
        return null;
    }
}
