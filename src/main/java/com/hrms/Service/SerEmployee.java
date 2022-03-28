package com.hrms.Service;

import com.hrms.Entity.EntEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import com.hrms.Repsitory.RepoEmployee;
import org.springframework.stereotype.Service;

@Service
public class SerEmployee {

    @Autowired
    private RepoEmployee emp;

    public void empADD(EntEmployee e){

        emp.save(e);
    }

}
