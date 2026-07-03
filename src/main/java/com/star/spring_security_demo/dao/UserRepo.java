package com.star.spring_security_demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.star.spring_security_demo.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository <User, Integer> {

    User findByUsername(String username);


}
