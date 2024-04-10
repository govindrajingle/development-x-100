package com.random.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

	@GetMapping("/")
	public String defaultPageRedirect() {
		return "redirect:/homepage/registrationPage";
	}

}
