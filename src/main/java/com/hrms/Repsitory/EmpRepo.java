package com.hrms.Repsitory;

import com.hrms.Entity.EmpEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepo extends JpaRepository<EmpEnt, Integer>  {
}

