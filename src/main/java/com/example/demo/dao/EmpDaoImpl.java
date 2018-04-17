package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;
import com.example.demo.repo.IEmpRepo;

@Repository
public class EmpDaoImpl implements IEmpDao {
	@Autowired
	private IEmpRepo empRepo;

	@Override
	public List<Employee> getAllEmp() {
		return empRepo.findAll();
	}

	@Override
	public void saveEmp(Employee emp) {
		empRepo.save(emp);
		
	}

}
