package com.identity.controller;

import com.identity.dto.request.UserLogin;
import com.identity.handler.ResponseHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")

public class AuthController {
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserLogin userLogin) {
        return ResponseHandler.execute();
    }

    @PostMapping("/introspect")
    public ResponseEntity<Object> introspect(@RequestParam("token") String token) {
        return ResponseHandler.execute();
    }

    @PostMapping("/refresh")
    public ResponseEntity<Object> refresh(@RequestParam("token") String token) {
        return ResponseHandler.execute();
    }

    @PostMapping("/logout")
    public ResponseEntity<Object> logout(@RequestParam("token") String token) {
        return ResponseHandler.execute();
    }
}
