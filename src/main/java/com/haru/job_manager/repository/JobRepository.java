package com.haru.job_manager.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.haru.job_manager.entity.Job;

public interface JobRepository
                extends JpaRepository<Job, Long> {
        List<Job> findAllByOrderByIdAsc();
        List<Job> findByJobNameContainingOrderByIdAsc(String keyword);
}