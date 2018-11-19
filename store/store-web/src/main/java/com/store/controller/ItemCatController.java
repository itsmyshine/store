package com.store.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.store.service.ItemCatService;

@Controller
public class ItemCatController{
	@Resource
	private ItemCatService itemCatservice;
	
	@RequestMapping("/itemcat")
	@ResponseBody
	public List<Map<String,Object>> queryItemCatByPid(@RequestParam(value="id",defaultValue="0")Long parentId){
		return itemCatservice.queryItemCatByPid(parentId);
	}
}
