package com.prac.cachepractice.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.prac.cachepractice.entity.Product;
import com.prac.cachepractice.repo.ProductRepository;

@Service
public class ProductService {
	private ProductRepository repository;
	
	public ProductService( ProductRepository repository) {
		this.repository=repository;
	}
	
	@CachePut(cacheNames="product" ,key="#result.id")
	public Product addProduct(Product p) {
		return repository.save(p);
	}
	
	@Cacheable(cacheNames="product" ,key="#id")
	public Product getById(int id) {
		return repository
		.findById(id)
		.orElseThrow(()->new RuntimeException("Id not present"));
	}
	
	@CacheEvict(cacheNames = "product", key = "#id")
    public void deleteById(int id) {
		if(!repository.existsById(id)) {
			throw new RuntimeException("Product not found");
		}
        repository.deleteById(id);
    }
	
	

}
