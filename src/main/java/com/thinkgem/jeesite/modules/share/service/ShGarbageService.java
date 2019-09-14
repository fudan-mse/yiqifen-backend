/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.share.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.share.entity.ShGarbage;
import com.thinkgem.jeesite.modules.share.dao.ShGarbageDao;

/**
 * 单表生成Service
 * @author ThinkGem
 * @version 2019-09-02
 */
@Service
@Transactional(readOnly = true)
public class ShGarbageService extends CrudService<ShGarbageDao, ShGarbage> {

	public ShGarbage get(String id) {
		return super.get(id);
	}
	
	public List<ShGarbage> findList(ShGarbage shGarbage) {
		return super.findList(shGarbage);
	}
	
	public Page<ShGarbage> findPage(Page<ShGarbage> page, ShGarbage shGarbage) {
		return super.findPage(page, shGarbage);
	}
	
	@Transactional(readOnly = false)
	public void save(ShGarbage shGarbage) {
		super.save(shGarbage);
	}
	
	@Transactional(readOnly = false)
	public void delete(ShGarbage shGarbage) {
		super.delete(shGarbage);
	}
	
}