package com.example.StudentManagementSystem.Repositry;

import com.example.StudentManagementSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositry extends JpaRepository<User,Long> {

    boolean existsByUsername(String username);


    Optional<User> findByUsername(String username);
}
