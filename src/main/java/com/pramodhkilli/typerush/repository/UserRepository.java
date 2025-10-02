package com.pramodhkilli.typerush.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.pramodhkilli.typerush.model.UserEntity;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}

