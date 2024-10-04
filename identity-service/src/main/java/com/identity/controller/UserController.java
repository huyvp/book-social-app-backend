package com.identity.controller;

import com.identity.dto.UserRequest;
import com.identity.handler.ResponseHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody UserRequest userRequest) {
        return ResponseHandler.execute();
    }
}
