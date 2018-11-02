package com.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.store.service.ItemService;

@Controller
public class ItemController{
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item")
	@ResponseBody
	public String quetyItem(){
		return itemService.queryItem();
	}
}
