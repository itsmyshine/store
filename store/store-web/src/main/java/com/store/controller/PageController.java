package com.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController{
	
	/**
	 * 展示菜单页面
	 * @param page
	 * @return
	 */
	@RequestMapping("/page/{view}")
	public String toPage(@PathVariable("view")String view){
		return view;
	}
}
