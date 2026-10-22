package com.shubham.prompt_submission_platform.controller;

import com.shubham.prompt_submission_platform.dto.request.AuthLoginRequest;
import com.shubham.prompt_submission_platform.dto.response.AuthLoginResponse;
import com.shubham.prompt_submission_platform.model.Model;
import com.shubham.prompt_submission_platform.service.PublicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PublicController {

    private final PublicService publicService;

    @PostMapping("/api/users/login")
    public ResponseEntity<AuthLoginResponse> login(@RequestBody AuthLoginRequest request){
        AuthLoginResponse response = publicService.login(request);

        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/api/models")
    public ResponseEntity<List<Model>> getAllModules(){
        List<Model> modules = publicService.getAllActiveModules();

        return ResponseEntity.status(200).body(modules);
    }
}
