package com.springbootsportyshoes.demo.dtos;

import lombok.Data;

@Data
public class PasswordDto {

	private String oldPassword;
	private String newPassword;
	private String confirmPassword;

}
