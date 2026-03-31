package com.prj.job.app.service;

import com.prj.job.app.JobPost;
import com.prj.job.app.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class JobService {

    @Autowired
    private final JobRepo repo;

    public JobService(JobRepo repo) {
        this.repo = repo;
    }

    public JobPost add(JobPost jobPost) {
        return repo.save(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return repo.findAll();
    }

    public JobPost getJob(int postId){
        return repo.findById(postId).orElse(new JobPost());
    }

    public  void updateJob(JobPost jobPost){
        repo.save(jobPost);
    }

    public void deleteJob(int postId) {
        repo.deleteById(postId);
    }

    public void load(){
        List<JobPost> jobs = new ArrayList<>(
        Arrays.asList(
                new JobPost(1, "Java Developer", "Backend Development", 2),
                new JobPost(2, "React Developer", "Frontend Development", 1),
                new JobPost(3, "Full Stack Developer", "Spring + React", 3)
    ));
        repo.saveAll(jobs);
    }

    public List<JobPost> search(String keyword) {
       return repo.findByPostProfileContainingOrPostDescContaining(keyword,keyword);
    }
}
// Creating ArrayList with initial data
//private final
// Creating ArrayList with initial data
//private final List<JobPost> jobs = new ArrayList<>(
//        Arrays.asList(
//                new JobPost(1, "Java Developer", "Backend Development", 2),
//                new JobPost(2, "React Developer", "Frontend Development", 1),
//                new JobPost(3, "Full Stack Developer", "Spring + React", 3)
//        )
//);
//
//
//public JobPost getJob(int postId) {
//    for (JobPost job : jobs) {
//        if (job.getPostId() == postId) {
//            return job;
//        }
//    }
//    return null;
//}
//
//
//// Return all jobs
//public List<JobPost> getAllJobs() {
//    return jobs;
//}
//
//// Add new job
//public JobPost add(JobPost job) {
//    jobs.add(job);
//    return job;
//}
//
//public void updateJob(JobPost jobPost) {
//    for (JobPost existingJob : jobs) {
//        if (existingJob.getPostId() == jobPost.getPostId()) {
//            existingJob.setPostProfile(jobPost.getPostProfile());
//            existingJob.setPostDesc(jobPost.getPostDesc());
//            existingJob.setReqExperience(jobPost.getReqExperience());
//            existingJob.setPostTechStack(jobPost.getPostTechStack());
//            return;
//        }
//    }
//}
//
//public void deleteJob(int postId) {
//    jobs.removeIf(job -> job.getPostId() == postId);
//}
//}
//
////);
