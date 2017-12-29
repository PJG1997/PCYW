package com.yc.dao;

import java.util.List;

import com.yc.bean.Shippoint;

public interface ShippointDao {

	
	/**
	 * 查询所有的配送点
	 * @return
	 */
	public List<Shippoint> findAllShippoint();
}
