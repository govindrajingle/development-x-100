package com.random.controller;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

	@PostMapping("/registration")
	public NameAndAge addNameAndAge(@RequestBody NameAndAge nameAndAge) {
		return nameAndAgeRepository.save(nameAndAge);
	}


	@GetMapping("/welcome")
	@ResponseBody
	public String welcome() {
		return "<html>\n" + "<header><title>Welcome Title</title></header>\n" + "<body>\n" + "Hello world from HTML\n"
				+ "</body>\n" + "</html>";
	}

}
