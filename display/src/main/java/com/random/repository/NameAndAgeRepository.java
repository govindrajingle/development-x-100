package com.random.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.random.entity.NameAndAge;

@Repository
public interface NameAndAgeRepository extends JpaRepository<NameAndAge, Long>{

}
