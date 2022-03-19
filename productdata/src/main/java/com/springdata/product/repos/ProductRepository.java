package com.springdata.product.repos;

import org.springframework.data.repository.CrudRepository;

import com.springdata.product.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

}
