package com.random.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@RestController
public class DatabaseCheck {

	@Autowired
	EntityManager em;

	@GetMapping("/testData")
	@Transactional
	public String transactionalCheck() {
		Query qOne;
		Query qTwo;
		Query qThree;
		Query qFour;
		try {
			qOne = em.createNativeQuery(" update manual_table set sr_no = 66 where test = 'Test 1' ");
			qTwo = em.createNativeQuery(" update manual_table set sr_no = 66 where test = 'Test 2' ");
			qThree = em.createNativeQuery(" update manual_table set sr_no = 66 where test = 'Test 3' ");
			qFour = em.createNativeQuery(" update manual_table set sr_no = 88 where test = Test 9 ");
			System.out.println("Status of query - " + qOne.executeUpdate());
			System.out.println("Status of query - " + qTwo.executeUpdate());
			System.out.println("Status of query - " + qThree.executeUpdate());
			System.out.println("Status of query - " + qFour.executeUpdate());
		} catch (Exception e) {
			// If any exception occurs, Spring will automatically rollback the transaction
			throw e;
		}
		return "OK";
	}

}