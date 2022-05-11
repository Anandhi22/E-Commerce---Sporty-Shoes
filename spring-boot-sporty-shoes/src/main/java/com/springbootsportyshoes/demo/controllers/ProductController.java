package com.springbootsportyshoes.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springbootsportyshoes.demo.exception.ProductDetailsNotFoundException;
import com.springbootsportyshoes.demo.models.Order;
import com.springbootsportyshoes.demo.models.Product;
import com.springbootsportyshoes.demo.services.OrderService;
import com.springbootsportyshoes.demo.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderService orderService;

	@GetMapping("/all")
	@ResponseStatus(HttpStatus.OK)
	public List<Product> getAllProducts() {
		return productService.viewAllProducts();
	}

	@GetMapping("/search")
	@ResponseStatus(HttpStatus.OK)
	public List<Product> searchByProductName(@RequestParam String productName) throws ProductDetailsNotFoundException {
		return productService.getByProductName(productName);
	}

	@GetMapping("/search/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Product searchByProductId(@PathVariable Integer id) throws ProductDetailsNotFoundException {
		return productService.getByProductId(id);
	}

	@PostMapping("/addProduct")
	@ResponseStatus(HttpStatus.CREATED)
	public String addProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}

	@PatchMapping("/{productId}/updateProductName")
	@ResponseStatus(HttpStatus.CREATED)
	public String updateProductName(@PathVariable Integer productId, @RequestParam String productName)
			throws ProductDetailsNotFoundException {
		return productService.updatProductName(productId, productName);
	}

	@PatchMapping("/{productId}/updateMsrp")
	@ResponseStatus(HttpStatus.CREATED)
	public String updateProductPrice(@PathVariable Integer productId, @RequestParam Double msrp)
			throws ProductDetailsNotFoundException {
		return productService.updatProductMsrp(productId, msrp);
	}

	@PatchMapping("/{productId}/updateQuantity")
	@ResponseStatus(HttpStatus.CREATED)
	public String updateProductQuantity(@PathVariable Integer productId, @RequestParam Integer quantity)
			throws ProductDetailsNotFoundException {
		return productService.updateProductQuantity(productId, quantity);
	}
	
	@PatchMapping("/{productId}/updateVendor")
    @ResponseStatus(HttpStatus.CREATED)
    public String updateProductVendor(@PathVariable Integer productId, @RequestParam String vendor) throws ProductDetailsNotFoundException {
        return productService.updateProductVendor(productId, vendor);
    }

    @DeleteMapping("/{id}/delete")
    @ResponseStatus(HttpStatus.OK)
    public String deleteProduct(@PathVariable Integer id) {
        return productService.deleteProductById(id);
    }

    @GetMapping("/{productId}/showOrders")
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getOrdersByProductId(@PathVariable Integer productId) {
        return orderService.getOrderbyProductId(productId);
    }
}


