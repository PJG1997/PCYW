package com.yc.biz;

import java.util.List;

import com.yc.bean.Shippoint;

public interface ShippointBiz {

	/**
	 * 查询所有的配送点
	 * @return
	 */
	public List<Shippoint> findAllShippoint();
	
}
