package com.profile.mapper;


import com.profile.dto.request.UserProfileReq;
import com.profile.dto.response.UserProfileResponse;
import com.profile.entity.UserProfile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfile toUserProfile(UserProfileReq userProfileReq);

    UserProfileResponse toUserProfileRes(UserProfile userProfile);
}
