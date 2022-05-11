package com.springbootsportyshoes.demo.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "USERS")
@Data public class User {

	@Id
	private Integer userId;
	private String userName;
	private String userEMail;
	private String userPassword;

}
