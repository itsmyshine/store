package com.store.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.pojo.PageBean;
import com.store.pojo.TbItem;
import com.store.service.ItemService;

@RestController
public class ItemController{
	@Resource
	private ItemService itemService;

	@RequestMapping("/item")
	public PageBean queryItem(@RequestParam("page") Integer page,@RequestParam("rows") Integer rows){
		return itemService.findByPage(page,rows);
	}

	/**
	 * 新增商品
	 */
	@PostMapping("/item/save")
	public void saveItem(TbItem item,@RequestParam("desc") String desc){
		itemService.saveItem(item,desc);
	}

	@RequestMapping("/item/update")
	public void updateItem(TbItem item,@RequestParam("desc") String desc){
		itemService.updateItem(item,desc);
	}
	
	@RequestMapping("/item/delete")
	public void delItem(@RequestParam("ids") String ids){
		itemService.delItem(ids);
	}
	
	/**
	 * 下架
	 */
	@RequestMapping("/item/instock")
	public void instock(@RequestParam("ids") String ids){
		itemService.instockItem(ids);
	}
	
	@RequestMapping("/item/reshelf")
	public void reshelf(@RequestParam("ids") String ids){
		itemService.reshelfItem(ids);
	}
}
