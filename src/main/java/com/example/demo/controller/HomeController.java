package com.example.demo.controller;

import com.example.demo.service.GetConnection;
import com.example.demo.service.MyService;
import java.io.IOException;
import java.net.HttpURLConnection;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	private final MyService myService;

	public HomeController(MyService myService) {
		this.myService = myService;
	}

	@GetMapping("/")
	public String getHome(final Model model) throws IOException { 	

		HttpURLConnection con1 = null, con2 = null;

		//get resp 1
		con1 = GetConnection.Connection("/city/London/userss");

		//get resp 2
		con2 = GetConnection.Connection("/userss");

		//call my service here and display output in page
		model.addAttribute("results", myService.getPeople(con1, con2));
		return "hello";

	}

}
