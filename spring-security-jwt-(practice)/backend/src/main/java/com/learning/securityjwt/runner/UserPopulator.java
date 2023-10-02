package com.learning.securityjwt.runner;

import com.learning.securityjwt.data.User;
import com.learning.securityjwt.data.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class UserPopulator {
    @Bean
    ApplicationRunner populateUser(UserRepository userRepository, PasswordEncoder passwordEncoder){
        return args -> {
           String password = passwordEncoder.encode("123");
        User user =new User(0,"phil",password, Set.of("USER"));
        userRepository.save(user);
            };
    }
}
