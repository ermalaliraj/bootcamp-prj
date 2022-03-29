package com.bootcamp.ms.profile.repository;

import com.bootcamp.ms.profile.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {
    Optional<User> findByName(String userName);

    Optional<User> findByEmail(String email);
}
