package com.store.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.store.mapper.ItemMapper;
import com.store.pojo.PageBean;
import com.store.pojo.TbItem;
import com.store.pojo.TbItemDesc;
import com.store.service.ItemService;

@Service
@Transactional(readOnly = false,rollbackFor = RuntimeException.class)
public class ItemServiceImpl implements ItemService{
	@Resource
	private ItemMapper itemMapper;

	@Override
	public PageBean findByPage(Integer page,Integer rows){
		PageHelper.startPage(page,rows);
		List<TbItem> items = itemMapper.findAllItems();

		// 取分页信息
		PageInfo<TbItem> pageInfo = new PageInfo<>(items);

		// 创建pageBean对象
		PageBean pageBean = new PageBean();
		pageBean.setTotal(pageInfo.getTotal());
		pageBean.setRows(items);
		return pageBean;
	}

	@Override
	public void saveItem(TbItem item,String desc){
		try{
			
			// 设置创建时间
			item.setCreated(new Date());
			
			// 设置修改时间
			item.setUpdated(item.getCreated());
			item.setStatus((byte)1);
			itemMapper.saveItem(item);
			
			// 获取保存的商品的id
			TbItemDesc itemDesc = new TbItemDesc();
			itemDesc.setItemId(item.getId());
			itemDesc.setItemDesc(desc);
			itemDesc.setCreated(new Date());
			itemDesc.setUpdated(itemDesc.getCreated());
			
			// 保存描述
			itemMapper.saveItemDesc(itemDesc);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void updateItem(TbItem item,String desc){
		try{
			// 设置修改时间
			item.setUpdated(new Date());
			itemMapper.updateItem(item);
			
			// 获取保存的商品的id
			TbItemDesc itemDesc = new TbItemDesc();
			itemDesc.setItemId(item.getId());
			itemDesc.setItemDesc(desc);
			itemDesc.setUpdated(itemDesc.getCreated());
			itemMapper.updateItemDesc(itemDesc);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void delItem(String ids){
		itemMapper.delItem(ids);
		itemMapper.delItemDesc(ids);
	}

	@Override
	public void instockItem(String ids){
		itemMapper.instock(ids);
	}

	@Override
	public void reshelfItem(String ids){
		itemMapper.reshelf(ids);
	}
}
