package com.example.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.entity.Product;
import com.example.product.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping("/product")
	public void addProduct(@RequestBody Product product) {
		service.saveProduct(product);
		
	}
	@GetMapping("/products")
	public List<Product>  getProducts(){
		return service.getProducts();
	}
	
	@GetMapping("/products/{pid}")
	public Product getProductById(@PathVariable int pid) {
		return service.getProductById(pid);
	}
	
	@DeleteMapping("/products/{pid}")
	public void deleteProduct(@PathVariable int pid) {
		service.deleteProduct(pid);
	}
	
	@PutMapping("/product")
	public void updateProduct(@RequestBody Product product) {
		service.updateProduct(product);
	}
}