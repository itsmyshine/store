package com.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.store.pojo.TbItem;
import com.store.pojo.TbItemDesc;

public interface ItemMapper{

	List<TbItem> findAllItems();

	void saveItem(TbItem item);

	void saveItemDesc(TbItemDesc itemDesc);

	Long getItemId(TbItem item);

	void updateItem(TbItem item);

	void updateItemDesc(TbItemDesc itemDesc);

	void delItem(@Param("ids")String ids);

	void delItemDesc(@Param("ids")String ids);

	void instock(@Param("ids")String ids);

	void reshelf(@Param("ids")String ids);
	
}