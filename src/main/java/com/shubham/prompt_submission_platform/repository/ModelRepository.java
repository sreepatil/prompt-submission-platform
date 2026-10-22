package com.shubham.prompt_submission_platform.repository;

import com.shubham.prompt_submission_platform.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model,Long> {

    List<Model> findByIsActive(boolean active);
}
