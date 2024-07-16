package com.Thesis.waterfill.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Thesis.waterfill.Model.Product;

public interface ProductRepository extends JpaRepository <Product, Long>{

}
