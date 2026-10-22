package com.shubham.prompt_submission_platform.service;

import com.shubham.prompt_submission_platform.dto.request.AuthLoginRequest;
import com.shubham.prompt_submission_platform.dto.response.AuthLoginResponse;
import com.shubham.prompt_submission_platform.model.Model;

import java.util.List;

public interface PublicService {

    AuthLoginResponse login(AuthLoginRequest request);

    List<Model> getAllActiveModules();
}
