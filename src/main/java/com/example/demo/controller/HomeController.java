package com.example.demo.controller;

import com.example.demo.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String getHome(final Model model) {

        //call my service here and display output in page
        model.addAttribute("results", myService.somePeople());
        return "hello";
    }

}
