package com.example.StudentRESTAPI.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_info")
public class Student {

	

	@Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_Id")
	private int student_Id;

	@Column(name = "student_Name")
	private String student_Name;

	@Column(name = "student_City")
	private String student_City;


	public Student(int student_Id, String student_Name, String student_City) {
		super();
		this.student_Id = student_Id;
		this.student_Name = student_Name;
		this.student_City = student_City;
	}


	public int getStudent_Id() {
		return student_Id;
	}


	public void setStudent_Id(int student_Id) {
		this.student_Id = student_Id;
	}


	public String getStudent_Name() {
		return student_Name;
	}


	public void setStudent_Name(String student_Name) {
		this.student_Name = student_Name;
	}


	public String getStudent_City() {
		return student_City;
	}


	public void setStudent_City(String student_City) {
		this.student_City = student_City;
	}


	public Student() {

	}


	@Override
	public String toString() {
		return "Student [student_Id=" + student_Id + ", student_Name=" + student_Name + ", student_City=" + student_City
				+ "]";
	}

	
}
