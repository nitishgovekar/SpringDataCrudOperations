package com.springdata.product.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdata.product.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
List<Product> findByName(String name);
	
}
