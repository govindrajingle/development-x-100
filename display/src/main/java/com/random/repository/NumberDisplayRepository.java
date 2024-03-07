package com.random.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.random.entity.NumberDisplay;

@Repository
public interface NumberDisplayRepository extends JpaRepository<NumberDisplay, Long>{

}