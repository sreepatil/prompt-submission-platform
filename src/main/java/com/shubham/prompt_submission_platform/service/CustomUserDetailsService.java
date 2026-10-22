package com.shubham.prompt_submission_platform.service;

import com.shubham.prompt_submission_platform.exceptions.UserAlreadyExistsException;
import com.shubham.prompt_submission_platform.model.User;
import com.shubham.prompt_submission_platform.repository.UserRepository;
import com.shubham.prompt_submission_platform.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username).orElseThrow(() -> new UserAlreadyExistsException("User not found"));

        return new UserPrincipal(user);
    }
}
