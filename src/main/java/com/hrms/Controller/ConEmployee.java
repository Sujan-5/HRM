package com.hrms.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hrms.Entity.EntEmployee;
import com.hrms.Service.SerEmployee;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ConEmployee {

    private final SerEmployee Service;
    public ConEmployee(SerEmployee Service) {
        this.Service = Service;
    }

    @GetMapping("/")
    public String home(Model m){
        List<EntEmployee> employe = Service.getAllEmp();
        m.addAttribute("employe",employe);
        return "home";
    }

    @GetMapping("/add")
    public String add(){
        return "add";
    }

    @PostMapping("/register")
    public String regEmp(@ModelAttribute EntEmployee e, HttpSession session){
        System.out.println(e);

        Service.empADD(e);
        session.setAttribute("msg","Employee Added Sucessfully!!");

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model m){
        EntEmployee e = Service.getEMpById(id);
        m.addAttribute("employe",e);

        return "edit";
    }

    @PostMapping("/update")
    public String editemp(@ModelAttribute EntEmployee e, HttpSession session){
        Service.empADD(e);
        session.setAttribute("msg","Employee updated!!!");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deletemp(@PathVariable int id, HttpSession session){
        Service.delete(id);
        session.setAttribute("msg","Employee deleted!!!");
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(){

        return "login";
    }
}
