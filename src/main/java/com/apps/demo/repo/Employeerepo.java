package com.apps.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apps.demo.model.Employee;

public interface Employeerepo extends JpaRepository<Employee, Integer> {
	

}
