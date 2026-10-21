package com.shubham.prompt_submission_platform.dto.response;

import java.util.Set;

public record AuthLoginResponse(String token,
                                String username,
                                Set<String> roles) {
}
