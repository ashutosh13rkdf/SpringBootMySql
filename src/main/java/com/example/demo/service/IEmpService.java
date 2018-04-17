package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface IEmpService {
	public List<Employee> getAllEmp();
	public void saveEmp(Employee emp);
}
