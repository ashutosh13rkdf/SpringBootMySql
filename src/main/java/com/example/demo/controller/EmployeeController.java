package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.IEmpService;

@RestController
public class EmployeeController {
	@Autowired
	private IEmpService empService;
//get all details
	@RequestMapping(value="/employees", method=RequestMethod.GET)
	public @ResponseBody List<Employee> getAllEmp(){
		  List<Employee> emp =empService.getAllEmp();
		  return emp;
		
	}
	@RequestMapping(value="/employees", method=RequestMethod.POST)
	public void saveEmp(@RequestBody Employee emp) {
		empService.saveEmp(emp);
		
	}
}
