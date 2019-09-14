/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.share.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.share.entity.ShOrder;

/**
 * 单表生成DAO接口
 * @author ThinkGem
 * @version 2019-09-02
 */
@MyBatisDao
public interface ShOrderDao extends CrudDao<ShOrder> {
	
}