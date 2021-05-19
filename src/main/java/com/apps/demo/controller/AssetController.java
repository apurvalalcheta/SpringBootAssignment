package com.apps.demo.controller;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apps.demo.model.Assetcategories;
import com.apps.demo.model.Assetmodel;
import com.apps.demo.model.Employee;
import com.apps.demo.repo.Assetrepo;
import com.apps.demo.repo.Categoryrepo;
import com.apps.demo.repo.Employeerepo;

import javassist.compiler.ast.Variable;

@RestController
public class AssetController {
	@Autowired
	Assetrepo repo;
	@Autowired
	Categoryrepo crepo;
	@Autowired
	Employeerepo erepo;
	
	
	
	
	//Add Category
	@PostMapping("/category")
	public Assetcategories addCategory(@RequestBody Assetcategories a) {
		crepo.save(a);
		return a;
	}
	//Update category
			@PutMapping("/category")
			public Assetcategories updateCategory(@RequestBody Assetcategories a) {
				crepo.save(a);
				return a;
			}
	//Get Category
			@GetMapping("/categories")
			public List<Assetcategories> getcategories() {
				return crepo.findAll();
			}
			
			
	
			
			
	//Add asset
			@PostMapping("/asset")
			public Assetmodel addAsset(@RequestBody Assetmodel am) {
				repo.save(am);
				return am;	
			}
	//Get assets
			@GetMapping("/assets")
			public List<Assetmodel> getAsset(){
				return repo.findAll();
			}
	//Search based on name
			@GetMapping("/asset/{name}")
			public List<Assetmodel> getassetbyname(@PathVariable String name) {
				return repo.findByName(name);
			}
	//Update Asset
			@PutMapping("/asset")
			public Assetmodel updateAsset(@RequestBody Assetmodel am) {
				repo.save(am);
				return am;	
			}
	
	
			
			
			
	//Add Employee
			@PostMapping("/employee")
			public Employee addEmployee(@RequestBody Employee e) {
				erepo.save(e);
				return e;	
			}
			
	//Get Employee
			@GetMapping("/employees")
			public List<Employee> getEmployee(){
				return erepo.findAll();
			}
			
	//Update Employee
			@PutMapping("/employee")
			public Employee updateEmployee(@RequestBody Employee e) {
				erepo.save(e);
				return e;	
			}
	
			
			
			
			
	//Assign Asset
			@PutMapping("/asset/{name}/status/{status}/employee/{eid}")
			public String assignAsset(@PathVariable String name,@PathVariable String status,@PathVariable int eid) {
				
				
				List<Assetmodel> s=repo.findByName(name);
				List<Assetmodel> l=repo.findByStatus(status);
				s.retainAll(l);
				
				if (s.isEmpty()==false) {
					Assetmodel a=s.get(0);
					int k=a.getAid();
					a.setStatus("Assigned");
					repo.save(a);
					Employee e=erepo.getOne(eid);
					e.setAssignedobject(name);
					e.setAssignedassetid(k);
					erepo.save(e);
					return "Asset Assigned Successfully";
				}
				else {
					return "Asset Not Available";
				
				}
				
			}
	//Recover asset
			@PutMapping("/asset/{eid}")
			public String recoverAsset(@PathVariable int eid) {
				Employee e=erepo.getOne(eid);
				String m=e.getAssignedobject();
				String s="NULL";
				if(m.equals(s)) {
					return "Employee has no asset assigned";	
				}
				else {
					e.setAssignedobject("NULL");
					int i=e.getAssignedassetid();
					e.setAssignedassetid(0);
					erepo.save(e);
					Assetmodel a=repo.getOne(i);
					a.setStatus("Recovered");
					repo.save(a);
					return "Recovered Successfully";
				}
			}
	// Delete asset
			@DeleteMapping("/asset/{aid}")
			public String deleteAsset(@PathVariable int aid) {
				Assetmodel a=repo.getOne(aid);
				String h=a.getStatus();
				if(h=="Assigned") {
					return "Sorry,Asset is in Assigned state";
				}
				else {
					repo.delete(a);
					return "Asset deleted successfully";
				}
			}
			
			
			

}
