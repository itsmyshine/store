package com.store.service;

import com.store.pojo.PageBean;
import com.store.pojo.TbItem;

public interface ItemService{
	PageBean findByPage(Integer page,Integer rows);

	void saveItem(TbItem item,String desc);

	void updateItem(TbItem item,String desc);

	void delItem(String desc);

	void instockItem(String ids);

	void reshelfItem(String ids);
}
