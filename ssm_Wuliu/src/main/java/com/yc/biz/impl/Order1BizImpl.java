package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.Order1;
import com.yc.biz.Order1Biz;
import com.yc.dao.Order1Dao;

@Service
@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.SUPPORTS)
public class Order1BizImpl implements Order1Biz{

	@Resource(name="order1DaoImpl")
	private Order1Dao order1dao;
	
	@Override
	public Integer addOrder1(Order1 order1) {
		return order1dao.addOrder1(order1);
	}

	@Override
	public List<Order1> findAll() {
		return order1dao.findAll();
	}

	@Override
	public Order1 findRid(Order1 order1) {
		return order1dao.findRid(order1);
	}

	@Override
	public List<Order1> findAllOrderToPage(Order1 order1) {
		return order1dao.findAllOrderToPage(order1);
	}

	@Override
	public int delOrder(List<Integer> list) {
		return order1dao.delOrder(list);
	}

	@Override
	public Integer updateOrder1(Order1 order1) {
		return order1dao.updateOrder1(order1);
	}
}
