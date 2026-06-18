package com.haru.job_manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.haru.job_manager.service.JobService;

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

}