package org.tc.backend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tc.backend.models.Role;
import org.tc.backend.services.IRoleService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/roles")
public class RoleController {
    private final IRoleService iRoleService;

    @GetMapping("")
    public ResponseEntity<?> getAllRoles() {
        List<Role> roles = iRoleService.getAllRoles();
        return ResponseEntity.ok(roles);
    }

}
