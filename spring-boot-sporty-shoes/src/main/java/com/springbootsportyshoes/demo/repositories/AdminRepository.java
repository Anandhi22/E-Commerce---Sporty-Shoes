package com.springbootsportyshoes.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootsportyshoes.demo.models.Admin;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
	Admin findByAdminId(Integer adminId);

}
