package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//用于跳转到首页
@Controller
public class PageContorller {

	@RequestMapping("/")
	public String showIndex(){
		return "index";
	}
}
