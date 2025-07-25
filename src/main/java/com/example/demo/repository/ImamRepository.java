package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Imam;

public interface ImamRepository extends JpaRepository<Imam, Long> {
    // Custom query methods can be defined here if needed
    
}
