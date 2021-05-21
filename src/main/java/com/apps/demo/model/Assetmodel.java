package com.apps.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

public class Assetmodel {
	@Id
	private int aid;
	private String name;
	private String date;
	private String conditionnote;
	private String category;
	private String status;
	
	public Assetmodel(int aid, String name, String date, String conditionnote, String category, String status) {
		super();
		this.aid = aid;
		this.name = name;
		this.date = date;
		this.conditionnote = conditionnote;
		this.category = category;
		this.status = status;
	}
	
	public Assetmodel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getConditionnote() {
		return conditionnote;
	}
	public void setConditionnote(String conditionnote) {
		this.conditionnote = conditionnote;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Assetmodel [aid=" + aid + ", name=" + name + ", date=" + date + ", conditionnote=" + conditionnote
				+ ", category=" + category + ", status=" + status + "]";
	}
	
	

}
