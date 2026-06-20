package com.haru.job_manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.haru.job_manager.service.JobService;
import com.haru.job_manager.entity.Job;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HelloController {

        @Autowired
        private JobService jobService;

        @GetMapping("/jobs")
        public String jobs(Model model) {
                        model.addAttribute("jobs",jobService.getJobs());
                        return "jobs";
        }

        @PostMapping("/jobs")
        public String addJob(
                        @RequestParam String jobName,
                        @RequestParam String status) {

                        jobService.saveJob(jobName,status);
                        return "redirect:/jobs";
        }

        @PostMapping("/jobs/delete/{id}")
        public String deleteJob(
                        @PathVariable Long id) {
                        jobService.deleteJob(id);
                        return "redirect:/jobs";
        }

        @GetMapping("/jobs/edit/{id}")
        public String editJob(
                        @PathVariable Long id, Model model) {
                        Job job = jobService.getJob(id);

                        model.addAttribute("job", job);
                        return "edit";

        }

        @PostMapping("/jobs/update")
        public String updateJob(
                        @RequestParam Long id,
                        @RequestParam String jobName,
                        @RequestParam String status) {
                        jobService.updateJob(id, jobName, status);
                        return "redirect:/jobs";

        }

        @GetMapping("/jobs/search")
        public String search(@RequestParam String keyword, Model model) {
                model.addAttribute("jobs", jobService.searchJobs(keyword));
                return "jobs";

        }
}