package com.esther.code.modules.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Properties;


public class TestModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 123456L;
	
	private int age;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birth;
	private String name = "李丽";
	private boolean good;
	private long times;
	@NumberFormat(pattern = "#,###.##")
	private double salary;
	
	Properties properties; 
	
	public TestModel(){}
     
	public TestModel(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	public TestModel(int age, Date birth, String name, boolean good, long times, double salary) {
		super();
		this.age = age;
		this.birth = birth;
		this.name = name;
		this.good = good;
		this.times = times;
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	// @JsonFormat(pattern="yyyy-MM-dd")
	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isGood() {
		return good;
	}

	public void setGood(boolean good) {
		this.good = good;
	}

	public long getTimes() {
		return times;
	}

	public void setTimes(long times) {
		this.times = times;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", age=").append(age);
		sb.append(", birth=").append(birth);
		sb.append(", name=").append(name);
		sb.append(", good=").append(good);
		sb.append(", times=").append(times);
		sb.append(", salary=").append(salary);
		sb.append("]");
		return sb.toString();
	}
}
