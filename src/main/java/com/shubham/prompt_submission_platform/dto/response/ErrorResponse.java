package com.shubham.prompt_submission_platform.dto.response;

import java.time.LocalDateTime;

public record ErrorResponse(String path,
                            int status,
                            String error,
                            String message,
                            LocalDateTime timestamp) {
}
