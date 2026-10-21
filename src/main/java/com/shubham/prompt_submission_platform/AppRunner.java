package com.shubham.prompt_submission_platform;

import com.shubham.prompt_submission_platform.model.User;
import com.shubham.prompt_submission_platform.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class AppRunner implements CommandLineRunner {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (!userRepo.existsByUsername("sree")) {
            User user1 = new User();
            user1.setUsername("sree");
            user1.setPassword(passwordEncoder.encode("123"));
            user1.setRoles(Set.of("USER"));
            userRepo.save(user1);
        }

        if (!userRepo.existsByUsername("anushka")) {
            User user2 = new User();
            user2.setUsername("anushka");
            user2.setPassword(passwordEncoder.encode("123"));
            user2.setRoles(Set.of("ADMIN"));
            userRepo.save(user2);
        }
    }
}