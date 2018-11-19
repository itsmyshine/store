package com.store.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tb_item_cat")
public class TbItemCat implements Serializable{
	private static final long serialVersionUID = 1L;

	/** 类目编号 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "parent_id")
	private Long parentId;

	private String name;

	private Integer status;
	
	@Column(name = "sort_order")
	private Integer sortOrder;
	
	@Column(name = "is_parent")
	private Boolean isParent;

	private Date created;

	private Date updated;

	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}

	public Long getParentId(){
		return parentId;
	}

	public void setParentId(Long parentId){
		this.parentId = parentId;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public Integer getStatus(){
		return status;
	}

	public void setStatus(Integer status){
		this.status = status;
	}

	public Integer getSortOrder(){
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder){
		this.sortOrder = sortOrder;
	}

	public Boolean getIsParent(){
		return isParent;
	}

	public void setIsParent(Boolean isParent){
		this.isParent = isParent;
	}

	public Date getCreated(){
		return created;
	}

	public void setCreated(Date created){
		this.created = created;
	}

	public Date getUpdated(){
		return updated;
	}

	public void setUpdated(Date updated){
		this.updated = updated;
	}
}