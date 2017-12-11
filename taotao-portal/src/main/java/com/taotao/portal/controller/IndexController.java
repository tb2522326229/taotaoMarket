package com.taotao.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	@RequestMapping("/index")
	public String showIndex() {
		return "index";
	}
	
	@RequestMapping(value="/posttest",method=RequestMethod.POST)
	public String postTest(String name , String pass) {
		System.out.println(name);
		System.out.println(pass);
		return "OK";
	}

}
