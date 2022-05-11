package com.springbootsportyshoes.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootsportyshoes.demo.dtos.PasswordDto;
import com.springbootsportyshoes.demo.dtos.UserDetailsDto;
import com.springbootsportyshoes.demo.exception.InvalidUserCredentialsException;
import com.springbootsportyshoes.demo.models.Product;
import com.springbootsportyshoes.demo.models.User;
import com.springbootsportyshoes.demo.services.ProductService;
import com.springbootsportyshoes.demo.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private ProductService productService;
	
	@PostMapping("/signUp")
    public String addUser(@RequestBody User user) throws InvalidUserCredentialsException {
		return userService.addUser(user);
	}

	@PostMapping("/signIn")
	public Boolean userSignIn(@RequestBody UserDetailsDto userDetailsDto) throws InvalidUserCredentialsException {
		return userService.userSignIn(userDetailsDto);
	}

	@PatchMapping("/{userId}/update/UserName")
	public String updateUserName(@PathVariable Integer userId, @RequestParam String userName) throws InvalidUserCredentialsException {
		return userService.updateUserName(userId, userName);
	}

	@PatchMapping("/{userId}/update/Password")
	public String updatePassword(@PathVariable Integer userId, @RequestBody PasswordDto passwordDto)
			throws InvalidUserCredentialsException {
		return userService.updatePassword(userId, passwordDto);
	}

	@GetMapping("/products")
	public List<Product> viewProducts() {
		return productService.viewAllProducts();
	}

	@GetMapping("/products/{productId}")
	public Product viewProductById(@PathVariable Integer productId) {
		return productService.viewProductById(productId);
	}
	
	
	

}
