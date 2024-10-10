package com.profile.controller;

import com.profile.dto.request.UserProfileRequest;
import com.profile.dto.response.UserProfileResponse;
import com.profile.service.IUserProfileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserProfileController {
    IUserProfileService userProfileService;

    @PostMapping("/")
    UserProfileResponse createUserProfile(@RequestBody UserProfileRequest userProfileRequest) {
        return userProfileService.createProfile(userProfileRequest);
    }

    @GetMapping("/{id}")
    UserProfileResponse getUserProfile(@PathVariable("id") String id) {
        return userProfileService.getProfile(id);
    }

}
