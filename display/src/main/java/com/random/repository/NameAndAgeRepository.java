package com.random.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.random.entity.NameAndAge;

@Repository
public interface NameAndAgeRepository extends JpaRepository<NameAndAge, Long>{
	List<NameAndAge> findByOrderByTimeDesc(Pageable pageable);
}
