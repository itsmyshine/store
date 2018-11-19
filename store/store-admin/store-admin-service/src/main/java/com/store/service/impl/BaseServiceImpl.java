package com.store.service.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.store.service.BaseService;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@SuppressWarnings("all")
public class BaseServiceImpl<T> implements BaseService<T>{
	
	/**
	 * 注入数据访问通用mapper
	 */
	@Autowired
	private Mapper<T> mapper;
	
	/** 定义当前访问的实体类 */
	private Class<T> entityClass;
	
	/** 获取类上面泛型参数类型 */
	public BaseServiceImpl(){
		ParameterizedType parameterizedType = (ParameterizedType)this.getClass().getGenericSuperclass();
		
		/** 获取所有的实际类型参数 */
		this.entityClass = (Class<T>)parameterizedType.getActualTypeArguments()[0];
	}
	
	@Override
	public void saveSelective(T entity){
		mapper.insertSelective(entity);
	}

	@Override
	public void updateSelective(T entity){
		mapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public void delete(Serializable id){
		mapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteAll(String idField,Serializable[] ids){
		/** 创建示范对象 */
		Example example = new Example(entityClass);
		/** 创建条件对象 */
		Criteria criteria = example.createCriteria();
		/** 添加条件 */
		criteria.andIn(idField,Arrays.asList(ids));
		/** 根据条件删除 */
		mapper.deleteByExample(example);
	}

	@Override
	public List<T> findAll(){
		return mapper.selectAll();
	}

	@Override
	public List<T> findAllByWhere(T entity){
		return mapper.select(entity);
	}

	@Override
	public int countByWhere(T entity){
		return mapper.selectCount(entity);
	}

	@Override
	public List<T> findByPage(Integer pageNum,Integer pageSize){
		PageHelper.startPage(pageNum,pageSize);
		return mapper.selectAll();
	}

	@Override
	public T findOne(Serializable id){
		return mapper.selectByPrimaryKey(id);
	}

}
