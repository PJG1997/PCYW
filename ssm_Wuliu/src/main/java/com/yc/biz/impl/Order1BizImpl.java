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
@Transactional(readOnly=false,isolation=Isolation.DEFAULT,rollbackForClassName={"java.lang.RuntimeException"},propagation=Propagation.REQUIRED)

public class Order1BizImpl implements Order1Biz {

	@Resource(name="order1DaoImpl")
	private Order1Dao order1Dao;
	@Override
	@Transactional(readOnly=true)
	public List<Order1> findAll() {

		return order1Dao.findAll();
	}

}
