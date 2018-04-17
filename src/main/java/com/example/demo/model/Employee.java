package com.example.demo.model;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String departments;
	private String designation;
	private String contact;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date joiningDate;
	@JsonIgnore
	@JsonManagedReference
	@OneToOne(mappedBy="emp")
	@Cascade(value=org.hibernate.annotations.CascadeType.ALL)
	private Address address;
	@JsonIgnore
	@JsonManagedReference
	@ManyToOne
	@Cascade(value=org.hibernate.annotations.CascadeType.ALL)
	@JoinColumn(name="department_id")
	private Department department;
	@JsonIgnore
	@JsonManagedReference
	@ManyToMany
	@Cascade(value=org.hibernate.annotations.CascadeType.ALL)
	@JoinTable(name="EMPLOYEE_MEETING", 
				joinColumns={@JoinColumn(name="id")}, 
				inverseJoinColumns={@JoinColumn(name="meeting_id")})
	private Set<Meeting> meetings = new HashSet<Meeting>();
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<Meeting> getMeetings() {
		return meetings;
	}
	public void setMeetings(Set<Meeting> meetings) {
		this.meetings = meetings;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartments() {
		return departments;
	}
	public void setDepartments(String departments) {
		this.departments = departments;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	
	

}
