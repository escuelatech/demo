package com.demo.helloworld.spring.jpa.repositories;

import com.demo.helloworld.spring.jpa.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
