package com.haru.job_manager.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;

import jakarta.persistence.Table;
import jakarta.persistence.Column;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;

@Entity
@Table(name = "JOB")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "job_seq")
    @SequenceGenerator(name = "job_seq", sequenceName = "JOB_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "JOB_NAME")
    private String jobName;

    private String status;

    public Job() {

    }

    public Job(Long id, String jobName, String status) {
        this.id = id;
        this.jobName = jobName;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getJobName() {
        return jobName;
    }

    public String getStatus() {
        return status;
    }

}
