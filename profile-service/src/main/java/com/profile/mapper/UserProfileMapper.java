package com.profile.mapper;


import com.profile.dto.request.UserProfileRequest;
import com.profile.dto.response.UserProfileResponse;
import com.profile.entity.UserProfile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfile toUserProfile(UserProfileRequest userProfileRequest);

    UserProfileResponse toUserProfileRes(UserProfile userProfile);
}
