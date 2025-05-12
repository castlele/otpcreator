package com.castlele.otpcreator.repository;

import com.castlele.otpcreator.model.user.User;
import com.castlele.otpcreator.model.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    List<User> findByRole(UserRole role);
}
