package com.haru.job_manager.entity;

public class Job {

    private Long id;

    private String jobName;

    private String status;

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
