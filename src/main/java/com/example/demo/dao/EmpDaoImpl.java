package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.repo.IEmpRepo;

@Repository
@Transactional
public class EmpDaoImpl implements IEmpDao {
	@PersistenceContext
	private EntityManager entityManager;
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

	@Override
	public Department getDepartment(String departmentName) {
		Query query = entityManager.createQuery("SELECT t FROM Department t WHERE t.departmentName = ?1");
		query.setParameter(1, departmentName);
		Department deptt = null;
		try {
			deptt = (Department) query.getSingleResult();
		} catch (Exception ex) {
			System.out.println("Exception Details : " + ex.getMessage());
		}
		return deptt;
	}

}
