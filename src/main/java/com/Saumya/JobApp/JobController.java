package com.Saumya.JobApp;

import com.Saumya.JobApp.model.JobPost;
import com.Saumya.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class JobController {
    @Autowired
    private JobService jobService;
    //So now we want to create request mapping for home for two enpoints hence we wriete in the array
    @GetMapping({"/","home"})
    public String home(){
        //So when someone hits on our homepage end point the jsp that should return is home.jsp
        return "home";
    }
    @GetMapping("addjob")
    public String addJob(){
        return "addjob";
    }
    @PostMapping("handleForm")
    public String handleForm(JobPost jobPost){
        //So now we also need to send the jobpost daata to our service layer which will further send it to repo to store that particular job
        jobService.addJob(jobPost);
        return "success";
    }
    //Now basically when we click on ALlJobs then all the jobs should be displayed
    @GetMapping("/viewalljobs")
    //So first we need to display on UI so we will be using Model for it
    public String ViewJobs(Model m){
        //Now we need to fetch the list of jobs coming from jobservice
        List<JobPost> jobs = jobService.getAllJobs();
        //And now for particular name on ui i.e jobPosts we need to add keep the same name and add jobs i.e our array list
        m.addAttribute("jobPosts",jobs);
        //Now just doing this things won't work as we also need to display the jobs on that particular page
        return "viewalljobs";
    }
}
