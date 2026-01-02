package com.example.StudentManagementSystem.Config;


import com.example.StudentManagementSystem.Repositry.UserRepositry;
import com.example.StudentManagementSystem.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitilizer {

    @Bean
    CommandLineRunner loadSampleData(UserRepositry userRepositry, PasswordEncoder passwordEncoder){
        return args -> {
            if(!userRepositry.existsByUsername("Admin")){
                User user = new User();
                user.setUsername("Admin");
                user.setPassword(passwordEncoder.encode("admin@123"));
                user.setActive(true);
                userRepositry.save(user);
            }
        };
    }

}
