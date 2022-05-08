package com.hrms.Service;

import com.hrms.Entity.EntEmployee;
import com.hrms.Repsitory.RepoEmployee;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    public EntEmployee storefile(MultipartFile file) throws IOException {

        String citizen = StringUtils.cleanPath(file.getOriginalFilename());

            EntEmployee mp = new EntEmployee(citizen, file.getContentType(), file.getBytes());

            return emp.save(mp);

    }

    public List<EntEmployee> listAll() {
        return emp.findAll();
    }

    public EntEmployee get(Integer id){
        return emp.findById(id).get();
    }



}


