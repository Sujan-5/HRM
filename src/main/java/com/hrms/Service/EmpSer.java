package com.hrms.Service;

import com.hrms.Entity.EmpEnt;
import com.hrms.Repsitory.EmpRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpSer {

    private final EmpRepo rp;

    public EmpSer(EmpRepo rp) {
        this.rp = rp;
    }


    public List<EmpEnt> getAllEmp() {
        return rp.findAll();
    }
}
