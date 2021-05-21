package com.apps.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Assetcategories {
	@Id
	private int cid;
	private String cname;
	private String description;
	
	public Assetcategories() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Assetcategories(int cid, String cname, String description) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.description = description;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Assetcategories [cid=" + cid + ", cname=" + cname + ", description=" + description + "]";
	}

}
