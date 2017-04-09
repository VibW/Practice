package com.prolifics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	/*
	 * @RequestMapping("/hello") public ModelAndView firstModel() { ModelAndView
	 * model = new ModelAndView("welcome"); return model; }
	 */

	@GetMapping("/hello")
	public String hello() {
		System.out.println("from controller");
		return "welcome";
	}
}
