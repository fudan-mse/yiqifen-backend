/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.share.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.share.entity.ShShop;
import com.thinkgem.jeesite.modules.share.dao.ShShopDao;

/**
 * 单表生成Service
 * @author ThinkGem
 * @version 2019-09-02
 */
@Service
@Transactional(readOnly = true)
public class ShShopService extends CrudService<ShShopDao, ShShop> {

	public ShShop get(String id) {
		return super.get(id);
	}
	
	public List<ShShop> findList(ShShop shShop) {
		return super.findList(shShop);
	}
	
	public Page<ShShop> findPage(Page<ShShop> page, ShShop shShop) {
		return super.findPage(page, shShop);
	}
	
	@Transactional(readOnly = false)
	public void save(ShShop shShop) {
		super.save(shShop);
	}
	
	@Transactional(readOnly = false)
	public void delete(ShShop shShop) {
		super.delete(shShop);
	}
	
}