package com.example.StudentManagementSystem.Repositry;

import com.example.StudentManagementSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositry extends JpaRepository<User,Long> {

    boolean existsByUsername(String username);
}
