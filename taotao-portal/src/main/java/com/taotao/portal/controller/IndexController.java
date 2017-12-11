package com.taotao.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.taotao.common.utils.JsonUtils;
import com.taotao.portal.service.ContentService;

@Controller
public class IndexController {
	
	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/index")
	public String showIndex(Model model) {
		String list = contentService.getAd1List();
		model.addAttribute("ad1",list);
		return "index";
	}
	
	@RequestMapping(value="/posttest",method=RequestMethod.POST)
	public String postTest(String name , String pass) {
		System.out.println(name);
		System.out.println(pass);
		return "OK";
	}

}
