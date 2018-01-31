package com.yc.dao;

import java.util.List;

import com.yc.bean.Order1;

public interface Order1Dao {
	
	/*
	 * 添加订单信息
	 * */
	public int addOrder1(Order1 order1);
	
	public List<Order1> findAll();
}
