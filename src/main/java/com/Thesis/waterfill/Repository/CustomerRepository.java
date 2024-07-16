package com.Thesis.waterfill.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Thesis.waterfill.Model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    

}
