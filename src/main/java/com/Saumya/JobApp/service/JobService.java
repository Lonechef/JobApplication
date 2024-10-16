package com.Saumya.JobApp.service;

import com.Saumya.JobApp.model.JobPost;
import com.Saumya.JobApp.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobService {
    @Autowired
    private JobRepo jobRepo;

    public void addJob(JobPost jobPost){
      jobRepo.addJobs(jobPost);
    }
    public List<JobPost> getAllJobs(){
        return  jobRepo.getAlljobs();
          }
}
