package com.random.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.random.entity.NameAndAge;

@Repository
public interface NameAndAgeRepository extends JpaRepository<NameAndAge, Long>{
	List<NameAndAge> findByOrderByTimeDesc(Pageable pageable);
	
	@Query(value = "SELECT na.name FROM public.name_age na WHERE na.id IN (SELECT nd.id FROM public.number_display nd WHERE nd.number = :numberParameter)", nativeQuery = true)
    List<String> findNamesByNumber(@Param("numberParameter") int numberParameter);
}
