package com.apps.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	private int eid;
	private String fullname;
	private String designation;
	private String assignedobject;
	private int assignedassetid;
	
	public Employee(int eid, String fullname, String designation, String assignedobject, int assignedassetid) {
		super();
		this.eid = eid;
		this.fullname = fullname;
		this.designation = designation;
		this.assignedobject = assignedobject;
		this.assignedassetid = assignedassetid;
	}
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getAssignedassetid() {
		return assignedassetid;
	}
	public void setAssignedassetid(int assignedassetid) {
		this.assignedassetid = assignedassetid;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getAssignedobject() {
		return assignedobject;
	}
	public void setAssignedobject(String assignedobject) {
		this.assignedobject = assignedobject;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", fullname=" + fullname + ", designation=" + designation + ", assignedobject="
				+ assignedobject + ", assignedassetid=" + assignedassetid + "]";
	}
	
	

}
