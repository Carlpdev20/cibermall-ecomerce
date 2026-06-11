package com.cibermall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibermall.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
