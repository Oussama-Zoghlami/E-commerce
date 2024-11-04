package com.tekup.ecommerce.controller;

import com.tekup.ecommerce.entities.Role;
import com.tekup.ecommerce.entities.User;
import com.tekup.ecommerce.services.Services;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/admin")
@RequiredArgsConstructor
public class AdminController {

    private final Services services;


    @PreAuthorize("permitAll()")
    @GetMapping("/usersByRole/{role}")
    public List<User> getUsersByRole(@PathVariable Role role) {
        return services.getUsersByRole(role);
    }


    @PreAuthorize("permitAll()")
    @GetMapping("/displayUser/{userId}")
    public ResponseEntity<User> displayUser(@PathVariable Integer userId) {
        User user = services.findUserById(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
