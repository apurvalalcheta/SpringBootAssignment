package com.apps.demo.controller;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

import org.assertj.core.api.AbstractCharSequenceAssert;
import org.hibernate.annotations.Where;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.*;


import com.apps.demo.model.Assetcategories;
import com.apps.demo.model.Assetmodel;
import com.apps.demo.model.Employee;
import com.apps.demo.repo.Assetrepo;
import com.apps.demo.repo.Categoryrepo;
import com.apps.demo.repo.Employeerepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.qos.logback.core.status.Status;

@WebMvcTest(AssetController.class)
class AssetControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired 
	ObjectMapper objectMapper;
	
	@MockBean
	private Assetrepo assetRepo;
	
	@MockBean
	private Categoryrepo categoryRepo;
	
	@MockBean
	private Employeerepo employeeRepo;
	
	@MockBean
	private Assetcategories assetCat;
	
	@MockBean
	private Assetmodel assetModel;
	
	@MockBean
	private Employee employee;
	
	

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddCategory() throws JsonProcessingException,Exception {
		Assetcategories newCategory= new Assetcategories(1, "Electronics", "Handle with care");
		Assetcategories savedCategory= new Assetcategories(1, "Electronics", "Handle with care");
		
		
		
		Mockito.when(categoryRepo.save(newCategory)).thenReturn(savedCategory);
		String expected=objectMapper.writeValueAsString(savedCategory);
		
		String url= "/category";
		 MvcResult mvcResult= mockMvc.perform(
			post(url)
			.contentType("application/json")
			.content(objectMapper.writeValueAsString(newCategory))
			).andExpect(status().isOk()).andReturn();
		
		 
		
		String actual= mvcResult.getResponse().getContentAsString();
		System.out.println(actual);
		assertThat(actual).isEqualToIgnoringWhitespace(expected);	
		}
		
	

	

	@Test
	void testUpdateCategory() throws JsonProcessingException, Exception {
		Assetcategories existCategory= new Assetcategories(1, "book", "Handle with care");
		Assetcategories savedCategory= new Assetcategories(1, "book", "Handle with care");
		
		
		
		Mockito.when(categoryRepo.save(existCategory)).thenReturn(savedCategory);
		String expected=objectMapper.writeValueAsString(savedCategory);
		
		String url= "/category";
		 MvcResult mvcResult= mockMvc.perform(
			put(url)
			.contentType("application/json")
			.content(objectMapper.writeValueAsString(existCategory))
			).andExpect(status().isOk()).andReturn();
		
		 
		
		String actual= mvcResult.getResponse().getContentAsString();
		System.out.println(actual);
		assertThat(actual).isEqualToIgnoringWhitespace(expected);
		
	}

	@Test
	void testGetcategories() throws Exception {
		List<Assetcategories> listcategories=new ArrayList<>();
		listcategories.add(new Assetcategories(1, "Electronics","Handle with care"));
		listcategories.add(new Assetcategories(2, "Stationary","Handle with care"));
		listcategories.add(new Assetcategories(3, "Furniture","Handle with care"));
		
		Mockito.when(categoryRepo.findAll()).thenReturn(listcategories);
		
		String url ="/categories";
		MvcResult mvcResult= mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
		
		String actualJsonResponse =mvcResult.getResponse().getContentAsString();
		System.out.println(actualJsonResponse);
		
		String expectedJsonResponseString = objectMapper.writeValueAsString(listcategories);
		
		assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponseString);
		
	}

	@Test
	void testAddAsset() throws JsonProcessingException,Exception{
		Assetmodel newAsset= new Assetmodel(1, "Laptop", "27-12-2020","Keep away from water","Electronics","Available");
		Assetmodel savedAsset= new Assetmodel(1, "Laptop", "27-12-2020","Keep away from water","Electronics","Available");
		
		
		
		Mockito.when(assetRepo.save(newAsset)).thenReturn(savedAsset);
		String expected=objectMapper.writeValueAsString(savedAsset);
		
		String url= "/asset";
		 MvcResult mvcResult= mockMvc.perform(
			post(url)
			.contentType("application/json")
			.content(objectMapper.writeValueAsString(newAsset))
			).andExpect(status().isOk()).andReturn();
		
		 
		
		String actual= mvcResult.getResponse().getContentAsString();
		System.out.println(actual);
		assertThat(actual).isEqualToIgnoringWhitespace(expected);
	}

	@Test
	void testGetAsset() throws Exception {
		List<Assetmodel> listassets= new ArrayList<>();
		listassets.add(new Assetmodel(1, "Laptop", "2020-12-27", "Keep away from water" , "Electronics", "Available"));
		listassets.add(new Assetmodel(2, "Laptop", "2021-11-27", "Keep away from water" , "Electronics", "Assigned"));
		listassets.add(new Assetmodel(3, "Mobile", "2019-10-28", "Keep away from water" , "Electronics", "Available"));
		listassets.add(new Assetmodel(4, "Mobile", "2021-09-28", "Keep away from water" , "Electronics", "Recovered"));
		listassets.add(new Assetmodel(5, "Calculator", "2016-04-09", "Keep away from water" , "Stationary", "Assigned"));
		listassets.add(new Assetmodel(6, "Calculator", "2020-01-10", "Keep away from water" , "Stationary", "Assigned"));
		
		Mockito.when(assetRepo.findAll()).thenReturn(listassets);
		
		String url="/assets";
		
		MvcResult mvcResult= mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
		String actualJsonResponse=mvcResult.getResponse().getContentAsString();
		System.out.println(actualJsonResponse);
		
		String expectedJsonResponse= objectMapper.writeValueAsString(listassets);
		
		assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);
	}

	@Test
	void testGetassetbyname() throws Exception {
		String s="Laptop";
		List<Assetmodel> listassetsbyname= new ArrayList<>();
		listassetsbyname.add(new Assetmodel(1, "Laptop", "2020-12-27", "Keep away from water" , "Electronics", "Available"));
		listassetsbyname.add(new Assetmodel(2, "Laptop", "2021-11-27", "Keep away from water" , "Electronics", "Assigned"));
		
		
		Mockito.when(assetRepo.findByName(s)).thenReturn(listassetsbyname);
		
		String url="/asset/"+s;
		
		MvcResult mvcResult= mockMvc.perform(get(url)).andDo(print()).andExpect(status().isOk()).andReturn();
		String actualJsonResponse=mvcResult.getResponse().getContentAsString();
		System.out.println(actualJsonResponse);
		
		String expectedJsonResponse= objectMapper.writeValueAsString(listassetsbyname);
		
		assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);
		
	}

	@Test
	void testUpdateAsset() throws JsonProcessingException,Exception {
		Assetmodel setAsset= new Assetmodel(1, "Calculator", "27-12-2021","Keep away from water","Stationary","Assigned");
		Assetmodel savedAsset= new Assetmodel(1, "Calculator", "27-12-2021","Keep away from water","Stationary","Assigned");
		
		
		
		Mockito.when(assetRepo.save(setAsset)).thenReturn(savedAsset);
		String expected=objectMapper.writeValueAsString(savedAsset);
		
		String url= "/asset";
		 MvcResult mvcResult= mockMvc.perform(
			put(url)
			.contentType("application/json")
			.content(objectMapper.writeValueAsString(setAsset))
			).andExpect(status().isOk()).andReturn();
		
		 
		
		String actual= mvcResult.getResponse().getContentAsString();
		System.out.println(actual);
		assertThat(actual).isEqualToIgnoringWhitespace(expected);
	}

	@Test
	void testAddEmployee() throws JsonProcessingException,Exception{
		Employee newEmployee= new Employee(1, "abc", "Software Developer","NULL", 0);
		Employee savedEmployee= new Employee(1, "abc", "Software Developer","NULL", 0);
		
		
		
		Mockito.when(employeeRepo.save(newEmployee)).thenReturn(savedEmployee);
		String expected=objectMapper.writeValueAsString(savedEmployee);
		
		String url= "/employee";
		 MvcResult mvcResult= mockMvc.perform(
			post(url)
			.contentType("application/json")
			.content(objectMapper.writeValueAsString(newEmployee))
			).andExpect(status().isOk()).andReturn();
		
		 
		
		String actual= mvcResult.getResponse().getContentAsString();
		System.out.println(actual);
		assertThat(actual).isEqualToIgnoringWhitespace(expected);
	}

	@Test
	void testGetEmployee() throws Exception {
		List<Employee> listemployee=new ArrayList<>();
		listemployee.add(new Employee(1, "abc", "Software Engineer", "NULL", 0));
		listemployee.add(new Employee(2, "def", "Backend Developer", "NULL", 0));
		listemployee.add(new Employee(3, "ghi", "Web Developer", "NULL", 0));
		listemployee.add(new Employee(4, "jkl", "Frontend Developer", "NULL", 0));
		listemployee.add(new Employee(5, "mno", "HR", "NULL", 0));
		
		Mockito.when(employeeRepo.findAll()).thenReturn(listemployee);
		
		String url="/employees";
		
		MvcResult mvcResult= mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
		String actualJsonResponse=mvcResult.getResponse().getContentAsString();
		System.out.println(actualJsonResponse);
		
		String expectedJsonResponse= objectMapper.writeValueAsString(listemployee);
		
		assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);
	}

	@Test
	void testUpdateEmployee() throws JsonProcessingException,Exception {
		Employee setEmployee= new Employee(1, "abc", "Software Developer","NULL", 0);
		Employee savedEmployee= new Employee(1, "abc", "Software Developer","NULL", 0);
		
		
		
		Mockito.when(employeeRepo.save(setEmployee)).thenReturn(savedEmployee);
		String expected=objectMapper.writeValueAsString(savedEmployee);
		
		String url= "/employee";
		 MvcResult mvcResult= mockMvc.perform(
			put(url)
			.contentType("application/json")
			.content(objectMapper.writeValueAsString(setEmployee))
			).andExpect(status().isOk()).andReturn();
		
		 
		
		String actual= mvcResult.getResponse().getContentAsString();
		System.out.println(actual);
		assertThat(actual).isEqualToIgnoringWhitespace(expected);
	}

	@Test
	void testAssignAsset() throws Exception {
		String reqname="Calculator";
		String reqstatus="Available";
		int eid=2;
		
		String failuremessage="Asset Not Available";
		
		String url="/asset/"+reqname+"/status/"+reqstatus+"/employee/"+eid;
		
		MvcResult mvcResult= mockMvc.perform(put(url)).andExpect(status().isOk()).andReturn();
		String actual=mvcResult.getResponse().getContentAsString();
		assertThat(actual).isEqualToIgnoringWhitespace(failuremessage);
		
	}
	
	@Test
	void testRecoverAsset() throws Exception{
		int eid= 2;
		String s="Employee has no asset assigned";
		
		Employee e=new Employee(2 ,"DEF","Backend Developer","NULL",0);
		Mockito.when(employeeRepo.getOne(eid)).thenReturn(e);		
		String url="/asset/"+eid;
		MvcResult mvcResult= mockMvc.perform(put(url)).andExpect(status().isOk()).andReturn();
		String actual=mvcResult.getResponse().getContentAsString();
		System.out.println(actual);
		assertThat(actual).isEqualToIgnoringWhitespace(s);
		
	}
	
	@Test
	void testdeleteAsset() throws Exception{
		int aid=5;
		Assetmodel a= new Assetmodel(5, "Calculator", "27-12-2020","Keep away from water","Stationary","Available");
		
		Mockito.when(assetRepo.getOne(aid)).thenReturn(a);
		
		String s="Asset deleted successfully";
		
		
		Mockito.doNothing().when(assetRepo).deleteById(aid);
		
		String url="/asset/"+aid;
		MvcResult mvcResult= mockMvc.perform(delete(url)).andExpect(status().isOk()).andReturn();
		
		
		String actual=mvcResult.getResponse().getContentAsString();
		Mockito.verify(assetRepo, times(1)).deleteById(aid);
		System.out.println(actual);
		
		assertThat(actual).isEqualToIgnoringWhitespace(s);
		
			
		
	}




}
