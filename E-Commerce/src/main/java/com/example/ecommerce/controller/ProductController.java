package com.example.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.repository.ProductRepo;

@Controller
public class ProductController {
	
	@Autowired
	ProductRepo repo;
	
	@RequestMapping("/saveProduct")
	@ResponseBody
	public Optional<Product> addProduct(@RequestParam String id,String name,String desc,int quantity,int price,String type)
	{
		Product  prdt = new Product();
		prdt.setProductId(id);
		prdt.setProductName(name);
		prdt.setDescription(desc);
		prdt.setQuantity(quantity);
		prdt.setPrice(price);
		prdt.setType(type);
		repo.save(prdt);
		
		return repo.findById(id);
	}
	
	@RequestMapping("/getByType")
	public ResponseEntity<List<Product>> getPoductByType(@RequestParam String type)
	{
		return new ResponseEntity<List<Product>>(repo.findBytypeLike("%"+type+"%"),HttpStatus.OK);
	}
	
	@RequestMapping("/deleteProduct")
	@ResponseBody
	public Optional<Product> deleteProduct(@RequestParam String id)
	{
		repo.deleteById(id);
		return repo.findById(id);
	}
	
	@RequestMapping("/getAllProduct")
	@ResponseBody
	public List<Product> displayProduct()
	{
		return repo.findAll();
	}
	
	@RequestMapping("/getProduct")
	@ResponseBody
	public Optional<Product> displayProductById(@RequestParam String id)
	{
		return repo.findById(id);
	}
		
	
	

}
