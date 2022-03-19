package com.springdata.product;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Objects;

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
		product.setDesc("Apple");
		product.setPrice(7000d);
		product.setName("IOS");
		product.setId(1);
		productRepository.save(product);

		product.setDesc("OnePlus");
		product.setPrice(70000d);
		product.setName("Android");
		product.setId(2);
		productRepository.save(product);
	}

	@Test
	public void testRead() {
		Product p = productRepository.findById(1).get();
		assertNotNull(p);
	}

	@Test
	public void testSearchByName() {
		List<Product> productList = productRepository.findByName("IOS");
		if(productList != null && !productList.isEmpty()) {
			System.out.println(productList.get(0).getName());
		}else {
			System.out.println("The searched product is not available");
		}
	}
	
	@Test
	public void testSearchByNameAndDesc() {
		Product product = productRepository.findByNameAndDesc("IOS", "Apple");
		if(product != null && Objects.nonNull(product)) {
			System.out.println(product.getPrice());
		}else {
			System.out.println("The searched product is not available");
		}
	}

	@After
	public void testDelete() {
		System.out.println(productRepository.count());
		if (productRepository.existsById(1)) {
			productRepository.deleteById(1);
		}
	}

}
