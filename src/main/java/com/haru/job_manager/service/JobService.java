package com.haru.job_manager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.haru.job_manager.entity.Job;

import org.springframework.beans.factory.annotation.Autowired;

import com.haru.job_manager.repository.JobRepository;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<Job> getJobs() {

        return jobRepository.findAll();

    }

    public void saveJob(
            String jobName,
            String status) {

        Job job = new Job(null, jobName, status);

        jobRepository.save(job);

    }

}