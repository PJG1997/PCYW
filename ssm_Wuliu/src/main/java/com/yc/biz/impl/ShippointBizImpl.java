package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.Shippoint;
import com.yc.biz.ShippointBiz;
import com.yc.dao.ShippointDao;


@Service
@Transactional(isolation=Isolation.DEFAULT,rollbackForClassName="java.lang.RuntimeException")
public class ShippointBizImpl implements ShippointBiz{

	@Resource(name="shippointDaoImpl")
	private ShippointDao shippointDao;
	
	@Override
	public List<Shippoint> findAllShippoint() {
		return shippointDao.findAllShippoint();
	}

}
