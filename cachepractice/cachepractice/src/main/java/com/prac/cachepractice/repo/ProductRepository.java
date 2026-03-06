package com.prac.cachepractice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prac.cachepractice.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
