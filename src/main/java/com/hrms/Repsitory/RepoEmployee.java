package com.hrms.Repsitory;

import com.hrms.Entity.EntEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoEmployee extends JpaRepository<EntEmployee, Integer>  {
}