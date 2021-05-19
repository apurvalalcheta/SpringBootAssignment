package com.apps.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apps.demo.model.Assetmodel;

public interface Assetrepo extends JpaRepository<Assetmodel, Integer> {
	List<Assetmodel> findByName(String name);
	List<Assetmodel> findByStatus(String status);
	
}


