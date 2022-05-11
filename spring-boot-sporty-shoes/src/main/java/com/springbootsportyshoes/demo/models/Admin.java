package com.springbootsportyshoes.demo.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ADMINS")
@Data public class Admin {

	@Id
	private Integer adminId;

	private String adminName;

	private String adminPassword;

}
