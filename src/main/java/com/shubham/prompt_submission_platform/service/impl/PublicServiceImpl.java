package com.shubham.prompt_submission_platform.service.impl;

import com.shubham.prompt_submission_platform.dto.request.AuthLoginRequest;
import com.shubham.prompt_submission_platform.dto.response.AuthLoginResponse;
import com.shubham.prompt_submission_platform.jwt.JwtService;
import com.shubham.prompt_submission_platform.model.Model;
import com.shubham.prompt_submission_platform.repository.ModelRepository;
import com.shubham.prompt_submission_platform.repository.UserRepository;
import com.shubham.prompt_submission_platform.security.UserPrincipal;
import com.shubham.prompt_submission_platform.service.PublicService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PublicServiceImpl implements PublicService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final ModelRepository modelRepository;
    private final JwtService jwtService;

    @Override
    public AuthLoginResponse login(AuthLoginRequest request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password()));

        UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();

        String token = jwtService.generateToken(principal.getUsername(), principal.getRoles());

        return new AuthLoginResponse(token, principal.getUsername(), principal.getRoles());
    }

    @Override
    public List<Model> getAllActiveModules() {

        return modelRepository.findByIsActive(true);
    }
}
