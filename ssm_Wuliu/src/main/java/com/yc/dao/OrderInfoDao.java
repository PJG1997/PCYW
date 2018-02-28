package com.yc.dao;

import java.util.List;

import com.yc.bean.Orderinfo;

public interface OrderInfoDao {

	
	/**
	 * @param listOrderInfo
	 * @return
	 */
	public int addOrderInfoDao(Orderinfo listOrderInfo);
	
	
	/**
	 * 批量删除订单详细表
	 * @param list
	 * @return
	 */
	public int delOrderInfo(List<Integer> list);
}
