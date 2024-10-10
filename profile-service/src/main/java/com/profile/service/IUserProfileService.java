package com.profile.service;

import com.profile.dto.request.UserProfileRequest;
import com.profile.dto.response.UserProfileResponse;

public interface IUserProfileService {
    UserProfileResponse createProfile(UserProfileRequest request);
    UserProfileResponse getProfile(String id);
}
