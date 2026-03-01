package com.capgemini.assignment2_26_02_26.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.assignment2_26_02_26.dto.Category;

public interface CategoryJpaRepository extends JpaRepository<Category, Integer>{
	
}