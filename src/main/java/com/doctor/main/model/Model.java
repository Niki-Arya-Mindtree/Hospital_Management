package com.doctor.main.model;

import javax.persistence.Entity;
import javax.persistence.*;


@Entity
@Table(name = "DoctorDataBase")
public class Model implements Comparable<Model>{
	
	@Id
	private int Id;
	@Column(name="Name")
	private String Name;
	@Column(name="Salary")
	private int Salary;
	@Column(name="Specialist")
	private String Specialist;
	
	
	public Model() {
		super();
	}
	public Model(int id, String name, int salary, String specialist) {
		super();
		Id = id;
		Name = name;
		Salary = salary;
		Specialist = specialist;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}
	public String getSpecialist() {
		return Specialist;
	}
	public void setSpecialist(String specialist) {
		Specialist = specialist;
	}
	@Override
	public int compareTo(Model o) {
		
		if(Salary == o.Salary)
			return 0;
		else if(Salary < o.Salary)
			return 1;
		else 
			return -1;
	}
	
	
	
	

}
