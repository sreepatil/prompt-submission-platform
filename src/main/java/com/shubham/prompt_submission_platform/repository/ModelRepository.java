package com.shubham.prompt_submission_platform.repository;

import com.shubham.prompt_submission_platform.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model,Long> {
}
