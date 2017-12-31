package com.yc.biz;

import java.util.List;

import com.yc.bean.Shippoint;

public interface ShippointBiz {

	/**
	 * 查询所有的配送点
	 * @return
	 */
	public List<Shippoint> findAllShippoint();
	
	/*
	 * 根据条件筛查配送点信息*/
	public List<Shippoint> getShippointInfo(Shippoint sp);
	
	/*
	 * 更新配送点信息*/
	public void updateShippointInfo(Shippoint sp);
	
	/*
	 * 删除配送点*/
	public void delmanyShippoint(List list);
	
	/*
	 * 添加配送点*/
	public void addShippoint(Shippoint sp);
}
