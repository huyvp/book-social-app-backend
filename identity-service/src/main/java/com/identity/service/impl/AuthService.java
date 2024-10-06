package com.identity.service.impl;

import com.identity.dto.request.UserLogin;
import com.identity.service.IAuthService;

public class AuthService implements IAuthService {
    @Override
    public String login(UserLogin userLogin) {
        return "";
    }

    @Override
    public void logout(String token) {

    }

    @Override
    public String refreshToken(String token) {
        return "";
    }

    @Override
    public boolean introspect(String token) {
        return false;
    }
}
