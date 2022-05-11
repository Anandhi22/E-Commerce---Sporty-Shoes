package com.springbootsportyshoes.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springbootsportyshoes.demo.exception.OrderDetailsMisMatchedException;
import com.springbootsportyshoes.demo.models.Order;
import com.springbootsportyshoes.demo.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public List<Order> getOrdersByKeyAndOrder(String key, String order) throws OrderDetailsMisMatchedException {

		if (key.equals("orderId") && order.equals("Asc"))
			return orderRepository.findAll(Sort.by("orderId").ascending());
		
		else if (key.equals("orderId") && order.equals("Desc"))
			return orderRepository.findAll(Sort.by("orderId").descending());
		
		else if (key.equals("orderDate") && order.equals("Asc"))
			return orderRepository.findAll(Sort.by("orderDate").ascending());
		
		else if (key.equals("orderDate") && order.equals("Desc"))
			return orderRepository.findAll(Sort.by("orderDate").descending());
		else
			throw new OrderDetailsMisMatchedException("Invalid Details found");

	}

	public List<Order> getOrderbyProductId(Integer productId) {

		return orderRepository.findByProductId(productId);
	}

}
