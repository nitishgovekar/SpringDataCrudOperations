package com.springdata.product;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springdata.product.entities.Product;
import com.springdata.product.repos.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductdataApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	
	@Test
	public void testCreate() {
		Product product = new Product();
		product.setDesc("Apple Mobile");
		product.setPrice(7000d);
		product.setName("Iphone 14");
		product.setId(1);
		productRepository.save(product);
	}
	
	
	@Test
	public void testRead() {
	Product p = productRepository.findById(1).get();
	assertNotNull(p);
	assertEquals("Apple Mobile", p.getDesc());
	}
	
	@Test
	public void testUpdate() {
		Product product = productRepository.findById(1).get();
		product.setDesc("Apple");
		productRepository.save(product);
		
	}
	
	@Test
	public void testDelete() {
		if(productRepository.existsById(1)) {
			productRepository.deleteById(1);
		}
	}

}
