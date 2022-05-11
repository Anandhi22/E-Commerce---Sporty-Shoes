package com.springbootsportyshoes.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootsportyshoes.demo.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
		
	 List<Order> findByProductId(Integer productId);
	 
//	 List<Order> findAllByOrderId();
//	 
//	 List<Order> findAllByOrderIdDesc();
//	 
//	 List<Order> findAllByOrderDate();
//	 
//	 List<Order> findAllByOrderIDateDes();
	 
	// List<Order> findByOrderByOrderIdDesc();
//	 
//	 List<Order> findByOrderByOrderIdAsc();
//	 
//	 List<Order> findByOrderByOrderDateAsc();
//	 
//	 List<Order> findByOrderByOrderDateDesc();
	 
	 
	 
}
