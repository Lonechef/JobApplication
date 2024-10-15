package com.Saumya.JobApp;

import com.Saumya.JobApp.model.JobPost;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JobController {
    //So now we want to create request mapping for home for two enpoints hence we wriete in the array
    @GetMapping({"/","home "})
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
        return "success";
    }
}
