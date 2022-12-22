package com.example.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.entity.Product;

public interface ProductRepo extends JpaRepository<Product, String> {

	List<Product> findBytypeLike(String type);
}
