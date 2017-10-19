package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//用于跳转到首页
@Controller
public class PageContorller {

	@RequestMapping("/")
	public String showIndex(){
		return "index";
	}
	
	/*因为请求和路径和页面名称一样，所以这里直接一步到位，把路径提取出来后return给mvc.xml*/
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
}
