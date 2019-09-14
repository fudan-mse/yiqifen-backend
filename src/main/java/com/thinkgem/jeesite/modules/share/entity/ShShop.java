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
public class ShShop extends DataEntity<ShShop> {
	
	private static final long serialVersionUID = 1L;
	private String creater;		// 创建人
	private String updater;		// 更新人
	private String name;		// 店铺名称
	private String coverimageid;		// 封面图片,图片id
	private String coverimage;		// 封面图片路径
	private String address;		// 详细地址
	private String phone;		// 电话号码
	private String introduce;		// 简介
	private String detail;		// 详情
	private String license;		// 营业执照图片路径
	private String logo;		// 店铺logo
	private String openid;		// 微信关注的openId
	
	public ShShop() {
		super();
	}

	public ShShop(String id){
		super(id);
	}

	@Length(min=0, max=64, message="创建人长度必须介于 0 和 64 之间")
	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}
	
	@Length(min=0, max=64, message="更新人长度必须介于 0 和 64 之间")
	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}
	
	@Length(min=0, max=64, message="店铺名称长度必须介于 0 和 64 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=32, message="封面图片,图片id长度必须介于 0 和 32 之间")
	public String getCoverimageid() {
		return coverimageid;
	}

	public void setCoverimageid(String coverimageid) {
		this.coverimageid = coverimageid;
	}
	
	@Length(min=0, max=255, message="封面图片路径长度必须介于 0 和 255 之间")
	public String getCoverimage() {
		return coverimage;
	}

	public void setCoverimage(String coverimage) {
		this.coverimage = coverimage;
	}
	
	@Length(min=0, max=255, message="详细地址长度必须介于 0 和 255 之间")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Length(min=0, max=64, message="电话号码长度必须介于 0 和 64 之间")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	@Length(min=0, max=255, message="营业执照图片路径长度必须介于 0 和 255 之间")
	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}
	
	@Length(min=0, max=255, message="店铺logo长度必须介于 0 和 255 之间")
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	@Length(min=0, max=255, message="微信关注的openId长度必须介于 0 和 255 之间")
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
}