package com.springdata.associations;

import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springdata.associations.onetomany.Customer;
import com.springdata.associations.onetomany.PhoneNumber;
import com.springdata.associations.repository.CustomerRepository;

@SpringBootTest
class AssociationsApplicationTests {

	@Autowired
	CustomerRepository customerRepository;

	@Test
	void testCreateCustomer() {
		Customer customer = new Customer();
		customer.setName("Nitish");

		HashSet<PhoneNumber> phoneNumbers = new HashSet<PhoneNumber>();

		PhoneNumber number = new PhoneNumber();
		number.setNumber("9860808083");
		number.setType("Mobile");

		PhoneNumber number2 = new PhoneNumber();
		number2.setNumber("9021208990");
		number2.setType("Personal");
		number2.setCustomer(customer);
		number.setCustomer(customer);

		phoneNumbers.add(number);
		phoneNumbers.add(number2);

		customer.setPhoneNumbers(phoneNumbers);
		customerRepository.save(customer);
	}

}
