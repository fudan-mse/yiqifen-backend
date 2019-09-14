/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.share.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.share.entity.ShOrder;
import com.thinkgem.jeesite.modules.share.dao.ShOrderDao;

/**
 * 单表生成Service
 * @author ThinkGem
 * @version 2019-09-02
 */
@Service
@Transactional(readOnly = true)
public class ShOrderService extends CrudService<ShOrderDao, ShOrder> {

	public ShOrder get(String id) {
		return super.get(id);
	}
	
	public List<ShOrder> findList(ShOrder shOrder) {
		return super.findList(shOrder);
	}
	
	public Page<ShOrder> findPage(Page<ShOrder> page, ShOrder shOrder) {
		return super.findPage(page, shOrder);
	}
	
	@Transactional(readOnly = false)
	public void save(ShOrder shOrder) {
		super.save(shOrder);
	}
	
	@Transactional(readOnly = false)
	public void delete(ShOrder shOrder) {
		super.delete(shOrder);
	}
	
}