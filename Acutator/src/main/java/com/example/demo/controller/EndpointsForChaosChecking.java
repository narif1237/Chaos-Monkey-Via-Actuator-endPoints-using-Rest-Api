package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EndpointsForChaosChecking {
	 @RequestMapping("/greeting")
	    public String greeting() {
	        return "hello";
	    }
}
