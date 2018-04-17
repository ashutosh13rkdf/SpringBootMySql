package com.example.demo.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IEmpDao;
import com.example.demo.model.Address;
import com.example.demo.model.Employee;

@Service
public class EmpServiceImpl implements IEmpService{
	@Autowired
	private IEmpDao empDao;

	@Override
	public List<Employee> getAllEmp() {
		return empDao.getAllEmp();
	}

	@Override
	public void saveEmp(Employee emp) {
		Address add = emp.getAddress();
		add.setEmp(emp);
		emp.setAddress(add);
		empDao.saveEmp(emp);
		
	}

}
