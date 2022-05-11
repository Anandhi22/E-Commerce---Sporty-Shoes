package com.springbootsportyshoes.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootsportyshoes.demo.dtos.PasswordDto;
import com.springbootsportyshoes.demo.dtos.UserDetailsDto;
import com.springbootsportyshoes.demo.exception.InvalidUserCredentialsException;
import com.springbootsportyshoes.demo.models.User;
import com.springbootsportyshoes.demo.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	private User getUser(Integer userId) throws InvalidUserCredentialsException {

		return Optional.ofNullable(userRepository.findByUserId(userId))
				.orElseThrow(() -> new InvalidUserCredentialsException("User not found for the userId: " + userId));

	}

	public String addUser(User user) throws InvalidUserCredentialsException {

		if (userRepository.existsById(user.getUserId()))
			throw new InvalidUserCredentialsException("User already exists");

		else
			userRepository.save(user);
		return "User created Successfully";
	}

	public Boolean userSignIn(UserDetailsDto userDetailsDto) throws InvalidUserCredentialsException {

		User user = getUser(userDetailsDto.getUserId());
		if (!user.getUserPassword().equals(userDetailsDto.getPassword()))
			throw new InvalidUserCredentialsException("Incorrect Password");
		return Boolean.TRUE;
	}

	public String updateUserName(Integer userId, String userName) throws InvalidUserCredentialsException {
		User user = getUser(userId);
		user.setUserName(userName);
		userRepository.save(user);
		return "Username updated successfully";

	}

	public String updatePassword(Integer userId, PasswordDto passwordDto) throws InvalidUserCredentialsException {

		if (!passwordDto.getNewPassword().equals(passwordDto.getConfirmPassword()))
			throw new InvalidUserCredentialsException("Password and Confirm password should match!");

		User user = getUser(userId);

		if (!user.getUserPassword().equals(passwordDto.getOldPassword()))
			throw new InvalidUserCredentialsException("Incorrect  Old Password");

		user.setUserPassword(passwordDto.getNewPassword());
		userRepository.save(user);
		return "Password updated successfully";
	}

	public List<User> viewAllusers() {
		return userRepository.findAll();
		
	}

}
