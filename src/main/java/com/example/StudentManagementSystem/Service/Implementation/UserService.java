package com.example.StudentManagementSystem.Service.Implementation;


import com.example.StudentManagementSystem.Repositry.UserRepositry;
import com.example.StudentManagementSystem.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {

    private UserRepositry repositry;
    public UserService(UserRepositry repositry){
        this.repositry=repositry;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = repositry.findByUsername(username)
                            .orElseThrow(() -> new UsernameNotFoundException("Invalid Username"));

        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(user.getPassword())
                .disabled(!user.isActive())
                .build();

    }
}
