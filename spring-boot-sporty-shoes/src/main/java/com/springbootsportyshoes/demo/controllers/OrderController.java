package com.springbootsportyshoes.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootsportyshoes.demo.exception.OrderDetailsMisMatchedException;
import com.springbootsportyshoes.demo.models.Order;
import com.springbootsportyshoes.demo.services.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/all")
     public List<Order> getAllOrders(@RequestParam String key, @RequestParam String order) throws OrderDetailsMisMatchedException {

		return orderService.getOrdersByKeyAndOrder(key, order);

	}

}
