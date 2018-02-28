package com.yc.dao;

import java.util.List;

import com.yc.bean.Order1;

public interface Order1Dao {
	
	/*
	 * 添加订单信息
	 * */
	public Integer addOrder1(Order1 order1);
	
	public List<Order1> findAll();
	
	public Order1 findRid(Order1 order1);
	
	/*
	 * 带分页的查询订单
	 * 
	 * */
	public List<Order1> findAllOrderToPage(Order1 order1); 
	
	
	/**
	 * 批量删除订单
	 * @param list
	 * @return
	 */
	public int delOrder(List<Integer> list);
}
