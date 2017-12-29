package com.yc.biz;

import java.util.List;

import com.yc.bean.Price;

public interface PriceBiz {
	//添加price
	public void addPrice(Price price);
	//修改
	public void updatePrice(Price price);
	//删除
	public void deletePrice(Price price);
	//查询
	public List<Price> selectPrice(Price price);
}
