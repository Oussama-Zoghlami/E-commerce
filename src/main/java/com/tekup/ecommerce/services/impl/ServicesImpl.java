package com.tekup.ecommerce.services.impl;

import com.tekup.ecommerce.entities.Role;
import com.tekup.ecommerce.entities.User;
import com.tekup.ecommerce.repository.UserRepo;
import com.tekup.ecommerce.services.Services;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesImpl implements Services {
    @Autowired
    UserRepo userRepo;

    @Override
    public List<User> getUsersByRole(Role role) {
        return userRepo.findByRole(role);
    }

    @Override
    public User findUserById(Integer userId) {
        return userRepo.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + userId));
    }


}
