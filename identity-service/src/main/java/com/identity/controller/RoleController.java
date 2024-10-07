package com.identity.controller;

import com.identity.dto.request.RoleRequest;
import com.identity.handler.ResponseHandler;
import com.identity.service.IRoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleController {
    IRoleService roleService;

    @PostMapping
    public ResponseEntity<Object> createRole(@RequestBody RoleRequest roleRequest) {
        return ResponseHandler.execute(
                roleService.createRole(roleRequest)
        );
    }

    @DeleteMapping("/{role}")
    public ResponseEntity<Object> deleteRole(@PathVariable String role) {
        roleService.deleteRole(role);
        return ResponseHandler.execute();
    }

    @GetMapping("/{role}")
    public ResponseEntity<Object> getRole(@PathVariable String role) {
        return ResponseHandler.execute(
                roleService.getRole(role)
        );
    }

    @GetMapping
    public ResponseEntity<Object> getAllRole() {
        return ResponseHandler.execute(
                roleService.getAllRoles()
        );
    }
}
