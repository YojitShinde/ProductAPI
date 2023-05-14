package com.example.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.entity.Product;
import com.example.product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	//Save Methods
	public Product saveProduct(Product product) {
		return repository.save(product);
	}
	
	public List<Product> saveProducts(List<Product> products){
		return repository.saveAll(products);
	}
	
	//Find Methods
	public Product getProductById(int pid) {
		return repository.findById(pid).orElse(null);
	}
	
	public List<Product> getProducts(){
		return repository.findAll();
	}
	
	//Delete Method
	public void deleteProduct(int pid) {
		repository.deleteById(pid);
	}
	
	//Update Method
	public void updateProduct(Product product) {
		Product existingProduct = repository.findById(product.getPid()).orElse(null);
		if(existingProduct!=null) {
			existingProduct.setPname(product.getPname());
			existingProduct.setPrice(product.getPrice());
			repository.save(existingProduct);
		}
	}
}
