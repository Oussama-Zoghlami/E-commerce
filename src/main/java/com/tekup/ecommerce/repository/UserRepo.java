package com.tekup.ecommerce.repository;

import com.tekup.ecommerce.entities.Role;
import com.tekup.ecommerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface UserRepo extends JpaRepository<User, Integer> {

    List<User> findByRole(@Param("role") Role role);

    Optional<User> findByEmail(String email);

}
