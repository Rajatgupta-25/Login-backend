package com.user.operation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.user.operation.entities.Login;

public interface LoginDao extends JpaRepository<Login, Integer> {

}
