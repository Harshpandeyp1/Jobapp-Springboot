package com.prj.job.app;

import com.prj.job.app.service.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class JobController {

    private final JobService service;

    public JobController(JobService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String apiHome() {
        return "Job API is running";
    }

    @GetMapping("/jobs")
    public List<JobPost> getAllJobs() {
        return service.getAllJobs();
    }
    @GetMapping("JobPost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId){
        return service.getJob(postId);
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword")String keyword){
        return service.search(keyword);
    }

    @PostMapping("JobPost")
    public JobPost addJob(@RequestBody JobPost jobPost){
        service.add(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @PutMapping("JobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("JobPost/{PostId}")
    public String deleteJob(@PathVariable int PostId){
        service.deleteJob(PostId);
        return " Deleted";
    }

    @GetMapping("load")
    public String loadData(){
        service.load();
        return " Loaded";
    }
}
