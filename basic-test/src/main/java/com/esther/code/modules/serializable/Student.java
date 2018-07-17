package com.esther.code.modules.serializable;

import java.io.Serializable;

public class Student extends School implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;   
	//public static String name;
    private transient int age;    
    private Course course;          
    public void setCourse(Course course){    
        this.course = course;    
    }        
    public Course getCourse(){    
        return course;    
    }          
    public Student(String name, int age){    
        this.name = name;    
        this.age = age;    
    }     
    public String  toString(){    
        return "Student Object name:"+this.name+" age:"+this.age;    
    }  
}
