package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.Price;
import com.yc.biz.PriceBiz;
import com.yc.dao.PriceDao;
@Service
@Transactional(readOnly=false,isolation=Isolation.DEFAULT,rollbackForClassName={"java.lang.RuntimeException"},propagation=Propagation.REQUIRED)
public class PriceBizImpl implements PriceBiz{
	@Resource(name="priceDaoImpl")
	private PriceDao priceDao;
	/**
	 * 添加
	 */
	@Override
	public void addPrice(Price price) {
		this.priceDao.addPrice(price);
	}
	
	/**
	 * 修改
	 */
	@Override
	public void updatePrice(Price price) {
		this.priceDao.updatePrice(price);
	}
	
	/**
	 * 删除
	 */
	@Override
	public void deletePrice(Price price) {
		this.priceDao.deletePrice(price);
	}
	
	/**
	 * 查询
	 */
	@Override
	public List<Price> selectPrice(Price price) {
		return this.priceDao.selectPrice(price);
	}

}
