package com.springbootsportyshoes.demo.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "PRODUCTS")
@Data public class Product {

	@Id
	private Integer productID;
	private String  productName;
	private Double  msrp;
	private Integer quantityInStock;
	private String  productVendor;
	
	
	
}
