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
import com.thinkgem.jeesite.modules.share.entity.ShProduct;
import com.thinkgem.jeesite.modules.share.service.ShProductService;

/**
 * 单表生成Controller
 * @author ThinkGem
 * @version 2019-09-02
 */
@Controller
@RequestMapping(value = "${adminPath}/share/shProduct")
public class ShProductController extends BaseController {

	@Autowired
	private ShProductService shProductService;
	
	@ModelAttribute
	public ShProduct get(@RequestParam(required=false) String id) {
		ShProduct entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = shProductService.get(id);
		}
		if (entity == null){
			entity = new ShProduct();
		}
		return entity;
	}
	
	/*@RequiresPermissions("share:shProduct:view")*/
	@RequestMapping(value = {"list", ""})
	public String list(ShProduct shProduct, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ShProduct> page = shProductService.findPage(new Page<ShProduct>(request, response), shProduct); 
		model.addAttribute("page", page);
		return "modules/share/shProductList";
	}

	/*@RequiresPermissions("share:shProduct:view")*/
	@RequestMapping(value = "form")
	public String form(ShProduct shProduct, Model model) {
		model.addAttribute("shProduct", shProduct);
		return "modules/share/shProductForm";
	}

	/*@RequiresPermissions("share:shProduct:edit")*/
	@RequestMapping(value = "save")
	public String save(ShProduct shProduct, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, shProduct)){
			return form(shProduct, model);
		}
		shProductService.save(shProduct);
		addMessage(redirectAttributes, "保存单表成功");
		return "redirect:"+Global.getAdminPath()+"/share/shProduct/?repage";
	}
	
	/*@RequiresPermissions("share:shProduct:edit")*/
	@RequestMapping(value = "delete")
	public String delete(ShProduct shProduct, RedirectAttributes redirectAttributes) {
		shProductService.delete(shProduct);
		addMessage(redirectAttributes, "删除单表成功");
		return "redirect:"+Global.getAdminPath()+"/share/shProduct/?repage";
	}

}