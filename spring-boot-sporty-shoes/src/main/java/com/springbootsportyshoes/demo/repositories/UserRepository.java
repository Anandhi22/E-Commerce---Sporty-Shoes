package com.springbootsportyshoes.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootsportyshoes.demo.models.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>  {
	

    Boolean existsByUserId(String userId);

    User findByUserId(Integer userId);

    User findByUserName(String userName);

}
