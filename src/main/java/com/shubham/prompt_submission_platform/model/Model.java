package com.shubham.prompt_submission_platform.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long modelId;

    @NotEmpty
    @Column(nullable = false)
    private String name;

    @NotEmpty
    @Column(nullable = false)
    private String provider;

    @NotEmpty
    @Column(nullable = false)
    private String version;

    @NotEmpty
    @Column(nullable = false)
    private String description;

    private boolean isActive;
    private LocalDateTime createdAt;
}
