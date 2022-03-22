package com.springdata.associations.repository;

import org.springframework.data.repository.CrudRepository;

import com.springdata.associations.onetomany.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
