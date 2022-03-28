package com.hrms.Repsitory;

import com.hrms.Entity.EntEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoEmployee extends JpaRepository<EntEmployee, Integer>  {
}