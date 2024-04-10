package com.random.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.random.entity.GemReportDetails;

public interface GemReportDetailsRepository extends JpaRepository<GemReportDetails, Integer>{
	
	@Query("SELECT b FROM GemReportDetails b WHERE b.isValid = 1")
    List<GemReportDetails> findValidDetails();

}
