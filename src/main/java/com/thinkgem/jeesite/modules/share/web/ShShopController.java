/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.share.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.share.entity.ShShop;
import com.thinkgem.jeesite.modules.share.service.ShShopService;

/**
 * 单表生成Controller
 * @author ThinkGem
 * @version 2019-09-02
 */
@Controller
@RequestMapping(value = "${adminPath}/share/shShop")
public class ShShopController extends BaseController {

	@Autowired
	private ShShopService shShopService;
	
	@ModelAttribute
	public ShShop get(@RequestParam(required=false) String id) {
		ShShop entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = shShopService.get(id);
		}
		if (entity == null){
			entity = new ShShop();
		}
		return entity;
	}
	
	/*@RequiresPermissions("share:shShop:view")*/
	@RequestMapping(value = {"list", ""})
	public String list(ShShop shShop, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ShShop> page = shShopService.findPage(new Page<ShShop>(request, response), shShop); 
		model.addAttribute("page", page);
		return "modules/share/shShopList";
	}

	/*@RequiresPermissions("share:shShop:view")*/
	@RequestMapping(value = "form")
	public String form(ShShop shShop, Model model) {
		model.addAttribute("shShop", shShop);
		return "modules/share/shShopForm";
	}

	/*@RequiresPermissions("share:shShop:edit")*/
	@RequestMapping(value = "save")
	public String save(ShShop shShop, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, shShop)){
			return form(shShop, model);
		}
		shShopService.save(shShop);
		addMessage(redirectAttributes, "保存单表成功");
		return "redirect:"+Global.getAdminPath()+"/share/shShop/?repage";
	}
	
	/*@RequiresPermissions("share:shShop:edit")*/
	@RequestMapping(value = "delete")
	public String delete(ShShop shShop, RedirectAttributes redirectAttributes) {
		shShopService.delete(shShop);
		addMessage(redirectAttributes, "删除单表成功");
		return "redirect:"+Global.getAdminPath()+"/share/shShop/?repage";
	}

}