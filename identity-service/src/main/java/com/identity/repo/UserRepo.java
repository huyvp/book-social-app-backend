package com.identity.repo;

import com.identity.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);

    Page<User> findAllByIsActiveTrue(Pageable pageable);
}
