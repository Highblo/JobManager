package com.haru.job_manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.haru.job_manager.service.JobService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @Autowired
    private JobService jobService;

    @GetMapping("/jobs")
    public String jobs(Model model) {

        model.addAttribute(
                "jobs",
                jobService.getJobs());

        return "jobs";

    }

    @PostMapping("/jobs")
    public String addJob(

            @RequestParam String jobName,

            @RequestParam String status) {

        jobService.saveJob(

                jobName,

                status);

        return "redirect:/jobs";

    }

}