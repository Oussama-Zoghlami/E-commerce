package com.tekup.ecommerce.services;

import com.tekup.ecommerce.entities.Role;
import com.tekup.ecommerce.entities.User;

import java.util.List;

public interface Services {

    List<User> getUsersByRole(Role role);
    User findUserById(Integer userId);
}
