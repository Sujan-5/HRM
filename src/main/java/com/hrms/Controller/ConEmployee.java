package com.hrms.Controller;

import com.hrms.Entity.EntEmployee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConEmployee {

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/add")
    public String add(){
        return "add";
    }

    @PostMapping("/register")
    public String RegEmp(@ModelAttribute EntEmployee e){
        System.out.println(e);
        return "add";
    }
}
