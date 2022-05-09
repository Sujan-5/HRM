package com.hrms.Controller;

import com.hrms.Entity.EmpEnt;
import com.hrms.Entity.EntEmployee;
import com.hrms.Repsitory.EmpRepo;
import com.hrms.Service.EmpSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EmpCon {

    private final EmpSer serv;

    @Autowired
    private EmpRepo rrp;

    public EmpCon(EmpSer serv) {
        this.serv = serv;
    }

//    @GetMapping("/employeepage")
//    public String employeepage(Model model){
//        List<EntEmployee> listemp = serv.getAllEmp();
//        model.addAttribute("employee", new EmpEnt());
//        return"employeepage";
//    }
//
//    @PostMapping("/search")
//    public String employeesearch(@ModelAttribute("employeeSearchFormData") EmpEnt formData, Model model ){
//
////        EntEmployee entemp = Service.get(formData.getId());
//        EmpEnt entemp = serv.getEMpById(formData.getId());
//        model.addAttribute("employee", entemp);
//
//        return"redirect:/employeepage";
//    }

    @GetMapping("/leaverequest")
    public String leaverequest(){
        return "leaverequest";
    }

    @PostMapping ("/leave")
    public String leave(@ModelAttribute EmpEnt eent, HttpSession session){
        System.out.println(eent);
        serv.leaverequest(eent);
        session.setAttribute("msg","Leave Request saved!!");
        return "leaverequest";
    }


    @GetMapping({"/myleaverequest", "/"})
    public String myleaverequest(Model model){
        List<EmpEnt> employess = serv.listAll();
        model.addAttribute("employess",employess);
        return "myleaverequest";
    }

    @GetMapping("/leaverequestadmin")
    public String leaveadmin(Model m){
        List<EmpEnt> empll = serv.getAllEmp();
        m.addAttribute("empll",empll);
        return "leaverequestadmin";
    }

    @PostMapping("/approve")
    public String approve(@ModelAttribute EmpEnt e, HttpSession session){
        serv.apadd(e);
        session.setAttribute("msg", "Leave Request updated!!!");
        return "/approve";
    }

    @GetMapping("/aprove/{eid}")
    public String approveemp(@PathVariable("eid") int eid, Model m) {
        EmpEnt empllee = serv.getEById(eid);
        m.addAttribute("empll", empllee);
        return "approve";
    }
}



