package com.random.controller;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.random.entity.NameAndAge;
import com.random.entity.NumberDisplay;
import com.random.repository.NameAndAgeRepository;
import com.random.repository.NumberDisplayRepository;

@RestController
@RequestMapping("/homepage")
public class NumberDisplayController {

	@Autowired
	NumberDisplayRepository numberDisplayRepository;

	@Autowired
	NameAndAgeRepository nameAndAgeRepository;

	@RequestMapping("/registrationPage")
	public ModelAndView showForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("RegistrationPage");
		return mav;
	}
	
	@RequestMapping("/showUsers")
	public List<NameAndAge> showUserDetails(){
		List<NameAndAge> latestTen = nameAndAgeRepository.findByOrderByTimeDesc(PageRequest.of(0, 5));
		return latestTen;
	}
	
	@GetMapping("/getNumber")
	public double showNumber() {
		return (int) (Math.random() * 900000) + 100000;
	}

	@GetMapping("/random")
	public NumberDisplay random() {
		Random random = new Random();
		NumberDisplay numberDisplay = new NumberDisplay();
		numberDisplay.setNumber(random.nextInt(10) + 1);
		numberDisplay.setDisplayTime(LocalDateTime.now());
		return numberDisplayRepository.save(numberDisplay);
	}
	
	@PostMapping("/registrationSuccessHash")
	public ResponseEntity<?> saveData(@RequestBody Map<String, Object> payload) {
	    @SuppressWarnings("unchecked")
		Map<String, Object> data = (Map<String, Object>) payload.get("data");
	    String receivedHash = (String) payload.get("hash");
	    MessageDigest digest;
	    try {
	        digest = MessageDigest.getInstance("SHA-256");
	    } catch (NoSuchAlgorithmException e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	    
	    ObjectMapper mapper = new ObjectMapper();
	    String dataStr;
	    try {
	        dataStr = mapper.writeValueAsString(data);
	    } catch (JsonProcessingException e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	    
	    byte[] encodedhash = digest.digest(dataStr.getBytes(StandardCharsets.UTF_8));
	    String computeHash = bytesToHex(encodedhash);
	    if(!computeHash.equals(receivedHash)) {
	        return new ResponseEntity<>("Data is tampered", HttpStatus.BAD_REQUEST);
	    }
	    
	    // Extract name and age from data
	    String name = (String) data.get("name");
	    String age = (String) data.get("age");
	    
	    // Create new NameAndAge object and save it to the repository
	    NameAndAge nameAndAge = new NameAndAge();
	    nameAndAge.setName(name);
	    nameAndAge.setAge(age);
	    nameAndAge.setTime(LocalDateTime.now());
	    nameAndAgeRepository.save(nameAndAge);  
	    
	    // Create a response map
	    Map<String, Object> response = new HashMap<>();
	    response.put("message", "Data saved successfully");
	    response.put("name", name);
	    response.put("age", age);
	    
	    return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	private static String bytesToHex(byte[] hash) {
		StringBuilder hexString = new StringBuilder(2*hash.length);
		for(int i=0; i<hash.length; i++) {
			String hex = Integer.toHexString(0xff & hash[i]);
			if(hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}
		return hexString.toString();
	}

	@PostMapping("/registrationSuccess")
	public NameAndAge addNameAndAge(@ModelAttribute NameAndAge nameAndAge) {
		return nameAndAgeRepository.save(nameAndAge);
	}


//	@GetMapping("/welcome")
//	@ResponseBody
//	public String welcome() {
//		return "<html>\n" + "<header><title>Welcome Title</title></header>\n" + "<body>\n" + "Hello world from HTML\n"
//				+ "</body>\n" + "</html>";
//	}

	//giving the jstl error
	@RequestMapping("/showData")
	public ModelAndView showData() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("UserDetailsPage");
		return mav;
	}
}
