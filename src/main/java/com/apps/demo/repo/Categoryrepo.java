package com.apps.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apps.demo.model.Assetcategories;

public interface Categoryrepo extends JpaRepository<Assetcategories, Integer> {

}
