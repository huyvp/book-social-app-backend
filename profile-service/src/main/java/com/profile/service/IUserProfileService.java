package com.profile.service;

import com.profile.dto.request.UserProfileReq;
import com.profile.dto.response.UserProfileResponse;

public interface IUserProfileService {
    UserProfileResponse createProfile(UserProfileReq request);
    UserProfileResponse getProfile(String id);
}
