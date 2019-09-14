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
import com.thinkgem.jeesite.modules.share.entity.ShOrder;
import com.thinkgem.jeesite.modules.share.service.ShOrderService;

/**
 * 单表生成Controller
 * @author ThinkGem
 * @version 2019-09-02
 */
@Controller
@RequestMapping(value = "${adminPath}/share/shOrder")
public class ShOrderController extends BaseController {

	@Autowired
	private ShOrderService shOrderService;
	
	@ModelAttribute
	public ShOrder get(@RequestParam(required=false) String id) {
		ShOrder entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = shOrderService.get(id);
		}
		if (entity == null){
			entity = new ShOrder();
		}
		return entity;
	}
	
	/*@RequiresPermissions("share:shOrder:view")*/
	@RequestMapping(value = {"list", ""})
	public String list(ShOrder shOrder, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ShOrder> page = shOrderService.findPage(new Page<ShOrder>(request, response), shOrder); 
		model.addAttribute("page", page);
		return "modules/share/shOrderList";
	}

	/*@RequiresPermissions("share:shOrder:view")*/
	@RequestMapping(value = "form")
	public String form(ShOrder shOrder, Model model) {
		model.addAttribute("shOrder", shOrder);
		return "modules/share/shOrderForm";
	}

	/*@RequiresPermissions("share:shOrder:edit")*/
	@RequestMapping(value = "save")
	public String save(ShOrder shOrder, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, shOrder)){
			return form(shOrder, model);
		}
		shOrderService.save(shOrder);
		addMessage(redirectAttributes, "保存单表成功");
		return "redirect:"+Global.getAdminPath()+"/share/shOrder/?repage";
	}
	
	/*@RequiresPermissions("share:shOrder:edit")*/
	@RequestMapping(value = "delete")
	public String delete(ShOrder shOrder, RedirectAttributes redirectAttributes) {
		shOrderService.delete(shOrder);
		addMessage(redirectAttributes, "删除单表成功");
		return "redirect:"+Global.getAdminPath()+"/share/shOrder/?repage";
	}

}