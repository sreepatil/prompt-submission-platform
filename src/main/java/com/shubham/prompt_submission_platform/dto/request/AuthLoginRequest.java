package com.shubham.prompt_submission_platform.dto.request;

import jakarta.validation.constraints.NotBlank;

public record AuthLoginRequest(
        @NotBlank(message = "Username can not be null")
        String username,

        @NotBlank(message = "Password can not be null")
        String password
) {
}
