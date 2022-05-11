package com.springbootsportyshoes.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootsportyshoes.demo.dtos.PasswordDto;
import com.springbootsportyshoes.demo.exception.InvalidAdminCredentialsException;
import com.springbootsportyshoes.demo.models.Admin;
import com.springbootsportyshoes.demo.repositories.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	public String updatePassword(Integer adminId, PasswordDto passwordDto) throws InvalidAdminCredentialsException {
		if (!passwordDto.getNewPassword().equals(passwordDto.getConfirmPassword()))
			throw new InvalidAdminCredentialsException("Password and Confirm password should match!");

		Admin admin = getAdmin(adminId);

		if (!admin.getAdminPassword().equals(passwordDto.getOldPassword()))
			throw new InvalidAdminCredentialsException("Incorrect  Old Password");

		admin.setAdminPassword(passwordDto.getNewPassword());
		;
		adminRepository.save(admin);
		return "Password updated successfully";
	}

	public String updateAdminName(Integer adminId, String adminName) throws InvalidAdminCredentialsException {
		Admin admin = getAdmin(adminId);
		admin.setAdminName(adminName);
		adminRepository.save(admin);
		return "Username updated successfully";
	}

	private Admin getAdmin(Integer adminId) throws InvalidAdminCredentialsException {
		return Optional.ofNullable(adminRepository.findByAdminId(adminId))
				.orElseThrow(() -> new InvalidAdminCredentialsException("User not found for the userId: " + adminId));
	}

}
