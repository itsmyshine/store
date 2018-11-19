package com.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.store.pojo.TbItemCat;
import tk.mybatis.mapper.common.Mapper;

public interface TbItemCatMapper extends Mapper<TbItemCat> {

	List<TbItemCat> queryItemCatByPid(@Param("pid")Long parentId);
}