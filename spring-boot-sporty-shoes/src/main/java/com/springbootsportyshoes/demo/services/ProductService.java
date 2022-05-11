package com.springbootsportyshoes.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootsportyshoes.demo.exception.ProductDetailsNotFoundException;
import com.springbootsportyshoes.demo.models.Product;
import com.springbootsportyshoes.demo.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> viewAllProducts() {
		return productRepository.findAll();
	}

	public Product viewProductById(Integer productId) {
		return productRepository.findById(productId).get();
	}

	public List<Product> getByProductName(String productName) throws ProductDetailsNotFoundException {
		return Optional.ofNullable(productRepository.findByProductNameContaining(productName))
				.orElseThrow(() -> new ProductDetailsNotFoundException(productName + " not found"));
	}

	public String updatProductMsrp(Integer productId, Double msrp) throws ProductDetailsNotFoundException {
		Product product = getByProductId(productId);
		product.setMsrp(msrp);
		productRepository.save(product);
		return " Msrp Updated Successfully";
	}

	public String updatProductName(Integer productId, String productName) throws ProductDetailsNotFoundException {
		Product product = getByProductId(productId);
		product.setProductName(productName);
		productRepository.save(product);
		return "Product Name Updated Successfully";
	}

	public String updateProductQuantity(Integer productId, Integer quantity) throws ProductDetailsNotFoundException {
		Product product = getByProductId(productId);
		product.setQuantityInStock(quantity);
		productRepository.save(product);
		return "Quantity Updated Successfully";
	}

	public String createProduct(Product product) {
		productRepository.save(product);
		return "Product Created Successfully";
	}

	public Product getByProductId(Integer id) throws ProductDetailsNotFoundException {

		if (productRepository.findById(id) == null)
			throw new ProductDetailsNotFoundException(id + " not found");
		else
			return productRepository.findById(id).get();

	}

	public String updateProductVendor(Integer productId, String vendor) throws ProductDetailsNotFoundException {

		Product product = getByProductId(productId);
		product.setProductVendor(vendor);
		productRepository.save(product);
		return "Product Vendor Updated Successfully";
	}

	public String deleteProductById(Integer id) {
		productRepository.deleteById(id);
		return "Product Deleted Successfully";
	}
}
