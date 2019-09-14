/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.share.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 单表生成Entity
 * @author ThinkGem
 * @version 2019-09-02
 */
public class ShProduct extends DataEntity<ShProduct> {
	
	private static final long serialVersionUID = 1L;
	private String creater;		// 创建人
	private String producttype;		// 产品类型
	private String coverimageid;		// 封面图片
	private String coverimage;		// 封面图片路径
	private String point;		// 所需积分
	private String shopId;		// 店铺id
	private String shopName;		// shop_name
	private String introduce;		// 简介
	private String detail;		// 详情
	private String status;		// 状态1:草稿2:上架3:下架
	private Date startTime;		// 开始时间
	private Date endTime;		// 结束时间
	
	public ShProduct() {
		super();
	}

	public ShProduct(String id){
		super(id);
	}

	@Length(min=0, max=64, message="创建人长度必须介于 0 和 64 之间")
	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}
	
	@Length(min=0, max=11, message="产品类型长度必须介于 0 和 11 之间")
	public String getProducttype() {
		return producttype;
	}

	public void setProducttype(String producttype) {
		this.producttype = producttype;
	}
	
	@Length(min=0, max=32, message="封面图片长度必须介于 0 和 32 之间")
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
	
	@Length(min=0, max=255, message="所需积分长度必须介于 0 和 255 之间")
	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}
	
	@Length(min=0, max=64, message="店铺id长度必须介于 0 和 64 之间")
	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	
	@Length(min=0, max=64, message="shop_name长度必须介于 0 和 64 之间")
	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	
	@Length(min=0, max=255, message="简介长度必须介于 0 和 255 之间")
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
	
	@Length(min=0, max=11, message="状态1:草稿2:上架3:下架长度必须介于 0 和 11 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
}