package com.springbootsportyshoes.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootsportyshoes.demo.dtos.PasswordDto;
import com.springbootsportyshoes.demo.exception.InvalidAdminCredentialsException;
import com.springbootsportyshoes.demo.models.User;
import com.springbootsportyshoes.demo.services.AdminService;
import com.springbootsportyshoes.demo.services.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserService userService;
	
	@PatchMapping("/{adminId}/update/AdminName")
	public String updateUserName(@PathVariable Integer adminId, @RequestParam String adminName)
			throws  InvalidAdminCredentialsException{
		return adminService.updateAdminName(adminId, adminName);
	}

	@PatchMapping("/{adminId}/update/Password")
	public String updatePassword(@PathVariable Integer adminId, @RequestBody PasswordDto passwordDto)
			throws  InvalidAdminCredentialsException {
		return adminService.updatePassword(adminId, passwordDto);
	}
	
	@GetMapping("/viewAllUsers")
	public List<User> viewUsers() {
		return userService.viewAllusers();
	}
	
	

}
