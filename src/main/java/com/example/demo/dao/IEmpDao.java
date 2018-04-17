package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Employee;

public interface IEmpDao {
	public List<Employee> getAllEmp();
	public void saveEmp(Employee emp);

}
