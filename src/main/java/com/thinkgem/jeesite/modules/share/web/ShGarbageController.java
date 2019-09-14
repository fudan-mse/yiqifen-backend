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
import com.thinkgem.jeesite.modules.share.entity.ShGarbage;
import com.thinkgem.jeesite.modules.share.service.ShGarbageService;

/**
 * 单表生成Controller
 * @author ThinkGem
 * @version 2019-09-02
 */
@Controller
@RequestMapping(value = "${adminPath}/share/shGarbage")
public class ShGarbageController extends BaseController {

	@Autowired
	private ShGarbageService shGarbageService;
	
	@ModelAttribute
	public ShGarbage get(@RequestParam(required=false) String id) {
		ShGarbage entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = shGarbageService.get(id);
		}
		if (entity == null){
			entity = new ShGarbage();
		}
		return entity;
	}
	
	/*@RequiresPermissions("share:shGarbage:view")*/
	@RequestMapping(value = {"list", ""})
	public String list(ShGarbage shGarbage, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ShGarbage> page = shGarbageService.findPage(new Page<ShGarbage>(request, response), shGarbage); 
		model.addAttribute("page", page);
		return "modules/share/shGarbageList";
	}

	/*@RequiresPermissions("share:shGarbage:view")*/
	@RequestMapping(value = "form")
	public String form(ShGarbage shGarbage, Model model) {
		model.addAttribute("shGarbage", shGarbage);
		return "modules/share/shGarbageForm";
	}

	/*@RequiresPermissions("share:shGarbage:edit")*/
	@RequestMapping(value = "save")
	public String save(ShGarbage shGarbage, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, shGarbage)){
			return form(shGarbage, model);
		}
		shGarbageService.save(shGarbage);
		addMessage(redirectAttributes, "保存单表成功");
		return "redirect:"+Global.getAdminPath()+"/share/shGarbage/?repage";
	}
	
	/*@RequiresPermissions("share:shGarbage:edit")*/
	@RequestMapping(value = "delete")
	public String delete(ShGarbage shGarbage, RedirectAttributes redirectAttributes) {
		shGarbageService.delete(shGarbage);
		addMessage(redirectAttributes, "删除单表成功");
		return "redirect:"+Global.getAdminPath()+"/share/shGarbage/?repage";
	}

}