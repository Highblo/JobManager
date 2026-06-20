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

        return jobRepository.findAllByOrderByIdAsc();

    }

    public List<Job> searchJobs(String keyword) {

        return jobRepository.findByJobNameContainingOrderByIdAsc(keyword);

    }

    public void saveJob(
            String jobName,
            String status) {

        Job job = new Job(null, jobName, status);

        jobRepository.save(job);

    }

    public void deleteJob(Long id) {

        jobRepository.deleteById(id);

    }

    public Job getJob(Long id) {

        return jobRepository
                .findById(id)
                .orElse(null);

    }

    public void updateJob(

            Long id,

            String jobName,

            String status) {

        Job job =

                new Job(

                        id,

                        jobName,

                        status);

        jobRepository.save(job);

    }
}