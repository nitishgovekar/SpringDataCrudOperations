package com.springdata.product.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springdata.product.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{
	
List<Product> findByName(String name);
//Names and desc should be same as the ones defined in Product Entity otherwise we will get PropertyReference Exception
Product findByNameAndDesc(String name, String desc);
	
}
