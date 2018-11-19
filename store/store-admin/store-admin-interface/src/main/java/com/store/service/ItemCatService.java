package com.store.service;

import java.util.List;
import java.util.Map;

public interface ItemCatService{

	List<Map<String,Object>> queryItemCatByPid(Long parentId);
	
}
