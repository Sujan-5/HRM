package com.hrms.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.hrms.Entity.EntEmployee;
import com.hrms.Service.SerEmployee;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class ConEmployee {

    private final SerEmployee Service;

    public ConEmployee(SerEmployee Service) {
        this.Service = Service;
    }


    @GetMapping("/home")
    public String home(Model m) {
        List<EntEmployee> employe = Service.getAllEmp();
        m.addAttribute("employe", employe);
        return "home";
    }

//    public static String uploadDirectory=System.getProperty("user.dir")+"/resources/hrmm";

    @GetMapping("/empADD")

    public String add(Model model) {

        return "add";
    }

    @PostMapping("/register")
    public String regEmp(EntEmployee entity, HttpSession session, @RequestParam("citizen") MultipartFile file) throws IOException {


        String originalFilename = file.getOriginalFilename();
        file.transferTo(new File("D:\\xamp\\HumanResourceManagement\\hrmm\\" + originalFilename));
        System.out.println(entity);

        Service.empADD(entity);
        session.setAttribute("msg", "Employee Added Sucessfully!!");

        return "redirect:/home";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model m) {
        EntEmployee e = Service.getEMpById(id);
        m.addAttribute("employe", e);
        return "edit";
    }

    @PostMapping("/update")
    public String editemp(@ModelAttribute EntEmployee e, HttpSession session) {
        Service.empADD(e);
        session.setAttribute("msg", "Employee updated!!!");
        return "redirect:/home";
    }

    @GetMapping("/delete/{id}")
    public String deletemp(@PathVariable int id, HttpSession session) {
        Service.delete(id);
        session.setAttribute("msg", "Employee deleted!!!");
        return "redirect:/home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String viewHomePage(ModelMap model, @RequestParam String userName, @RequestParam String password) {
        if (userName.equals("admin") && password.equals("admin")) {
            return "redirect:/home";
        } else if (userName.equals("employee") && password.equals("employee")) {
            return "redirect:/employeepage";
        } else {
            model.put("error", "Incorrect username or password");
            return "login";
        }
    }

//    @RequestMapping(value = "/", method=RequestMethod.POST)
//    public String viewTraf(ModelMap model, @RequestParam String userName, @RequestParam String password){
//        if(userName.equals("admin")&& password.equals("admin")){
//            return "redirect:/viewHomePage";
//        }
//        else if(userName.equals("traffic")&& password.equals("traffic")){
//            return "redirect:/viewTraffic";
//        }
//        else{
//            return "homepage";
//        }
//    }

    @GetMapping("/employeepage")
    public String employeepage(Model model) {
        List<EntEmployee> listemp = Service.listAll();
        model.addAttribute("employee", new EntEmployee());
        return "employeepage";
    }

    @PostMapping("/search")
    public String employeesearch(@ModelAttribute("employeeSearchFormData") EntEmployee formData, Model model) throws Exception {

//        EntEmployee entemp = Service.get(formData.getId());
        EntEmployee entemp = Service.get(formData.getId());
        model.addAttribute("employee", entemp);

        return "employeepage";
    }

}


//for option
//    @GetMapping("/leaverequest")
//    public String leaverequest(){
//
//    return "leaverequest";
//    }
//
//    @GetMapping("/myleaverequest")
//    public String myleaverequest(){
//        return "myleaverequest";
//    }
//}
