package com.esther.code.modules.serializable;

import java.io.Serializable;

public class Course implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static String courseName;    
    private int credit;    
    
    @SuppressWarnings("static-access")
	public Course(String courseName, int credit){    
        this.courseName  = courseName;    
        this.credit = credit;    
    }          
    public String toString(){              
        return "Course Object courseName:"+courseName    
               +" credit:"+credit;    
    }  
}
