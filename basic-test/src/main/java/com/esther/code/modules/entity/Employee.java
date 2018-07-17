package com.esther.code.modules.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {
	private String name;
	private double salary;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date hireDay;

	public Employee() {
	}
	
	public Employee(String name,double salary){
		this.name=name;
		this.salary=salary;
		this.hireDay=new Date();
	}

	public Employee(String n, double s, int year, int month, int day) {
		name = n;
		salary = s;
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
		hireDay = calendar.getTime();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setHireDay(Date hireDay) {
		this.hireDay = hireDay;
	}

	public double getSalary() {
		return salary;
	}

	public Date getHireDay() {
		return hireDay;
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}

	public String toString() {
		return getClass().getName() + "[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";
	}
}
