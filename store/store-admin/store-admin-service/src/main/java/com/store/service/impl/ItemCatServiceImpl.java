package com.store.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.store.mapper.TbItemCatMapper;
import com.store.pojo.TbItemCat;
import com.store.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService{
	
	@Resource TbItemCatMapper itemCatMapper;

	@Override
	public List<Map<String,Object>> queryItemCatByPid(Long parentId){
		
		List<TbItemCat> queryItemCatByPid = itemCatMapper.queryItemCatByPid(parentId);
		List<Map<String,Object>> maps = new ArrayList<>();
		for(TbItemCat cat:queryItemCatByPid){
			Map<String,Object> map = new HashMap<>();
			map.put("id",cat.getId());
			map.put("text",cat.getName());
			map.put("state",cat.getIsParent()?"closed":"open");
			maps.add(map);
		}
		return maps;
	}
	
}
