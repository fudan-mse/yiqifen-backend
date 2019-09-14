/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.share.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.share.entity.ShProduct;
import com.thinkgem.jeesite.modules.share.dao.ShProductDao;

/**
 * 单表生成Service
 * @author ThinkGem
 * @version 2019-09-02
 */
@Service
@Transactional(readOnly = true)
public class ShProductService extends CrudService<ShProductDao, ShProduct> {

	public ShProduct get(String id) {
		return super.get(id);
	}
	
	public List<ShProduct> findList(ShProduct shProduct) {
		return super.findList(shProduct);
	}
	
	public Page<ShProduct> findPage(Page<ShProduct> page, ShProduct shProduct) {
		return super.findPage(page, shProduct);
	}
	
	@Transactional(readOnly = false)
	public void save(ShProduct shProduct) {
		super.save(shProduct);
	}
	
	@Transactional(readOnly = false)
	public void delete(ShProduct shProduct) {
		super.delete(shProduct);
	}
	
}