package com.hrms.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.hrms.Entity.EntEmployee;
import com.hrms.Service.SerEmployee;

import javax.servlet.http.HttpSession;

@Controller
public class ConEmployee {

    @Autowired
    private SerEmployee Service;

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/add")
    public String add(){

        return "add";
    }

    @PostMapping("/register")
    public String RegEmp(@ModelAttribute EntEmployee e, HttpSession session){
        System.out.println(e);

        Service.empADD(e);
        session.setAttribute("msg","Employee Added Sucessfully!!");

        return "redirect:/";
    }
}
