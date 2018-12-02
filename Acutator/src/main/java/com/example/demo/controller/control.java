package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class control {
	 @RequestMapping("/greeting")
	    public String greeting() {
	        return "hello";
	    }
}
