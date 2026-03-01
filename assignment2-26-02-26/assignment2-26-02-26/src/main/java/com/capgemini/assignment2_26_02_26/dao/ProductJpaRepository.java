package com.capgemini.assignment2_26_02_26.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.assignment2_26_02_26.dto.Product;


public interface ProductJpaRepository extends JpaRepository<Product, Integer>{
	List<Product> findByProductName(String productName);
	List<Product> findByCategory_CategoryId(int categoryId);
}