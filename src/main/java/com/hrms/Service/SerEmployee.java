package com.hrms.Service;

import com.hrms.Entity.EntEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import com.hrms.Repsitory.RepoEmployee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SerEmployee {

    private final RepoEmployee emp;

    public SerEmployee(RepoEmployee emp) {
        this.emp = emp;
    }

    public void empADD(EntEmployee e){
        emp.save(e);
    }

    public List<EntEmployee> getAllEmp(){
        return emp.findAll();
    }

    public EntEmployee getEMpById(int id){
        Optional<EntEmployee> e = emp.findById(id);
        if (e.isPresent()) {
            return e.get();
        }
        return null;
    }

    public void delete(int id){
        emp.deleteById(id);
    }
}
