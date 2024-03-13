package com.random.controller;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
		Map<String, Object> data = (Map<String, Object>) payload.get("data");
		String receivedHash = (String) payload.get("hash");
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		String dataStr = data.toString();
		byte[] encodedhash = digest.digest(dataStr.getBytes(StandardCharsets.UTF_8));
		String computeHash = bytesToHex(encodedhash);
		if(!computeHash.equals(receivedHash)) {
			return new ResponseEntity<>("Data is tampered", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
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

}
