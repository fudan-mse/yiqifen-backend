/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.share.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 单表生成Entity
 * @author ThinkGem
 * @version 2019-09-02
 */
public class ShGarbage extends DataEntity<ShGarbage> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 垃圾名称
	private String type;		// 垃圾分类
	private String counts;		// 查询次数
	
	public ShGarbage() {
		super();
	}

	public ShGarbage(String id){
		super(id);
	}

	@Length(min=0, max=200, message="垃圾名称长度必须介于 0 和 200 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=200, message="垃圾分类长度必须介于 0 和 200 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Length(min=0, max=255, message="查询次数长度必须介于 0 和 255 之间")
	public String getCounts() {
		return counts;
	}

	public void setCounts(String counts) {
		this.counts = counts;
	}
	
}