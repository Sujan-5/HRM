package com.hrms.Controller;

import com.hrms.Entity.EmpEnt;
import com.hrms.Entity.EntEmployee;
import com.hrms.Service.EmpSer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmpCon {

    private EmpSer serv;

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

    @GetMapping("/myleaverequest")
    public String myleaverequest(@ModelAttribute EmpEnt en, Model m){
//        List<EmpEnt> employ = serv.getAllEmp();
//        m.addAttribute("employ",employ);
//        System.out.println(en);
        return "myleaverequest";
    }
}



