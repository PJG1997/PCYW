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
		return this.shippointDao.findAllShippoint();
	}

	@Override
	public List<Shippoint> getShippointInfo(Shippoint sp) {
		// TODO Auto-generated method stub
		return this.shippointDao.getShippointInfo(sp);
	}

	@Override
	public void updateShippointInfo(Shippoint sp) {
		// TODO Auto-generated method stub
		this.shippointDao.updateShippointInfo(sp);
	}

	@Override
	public void delmanyShippoint(List list) {
		// TODO Auto-generated method stub
		this.shippointDao.delmanyShippoint(list);
	}

	@Override
	public void addShippoint(Shippoint sp) {
		// TODO Auto-generated method stub
		this.shippointDao.addShippoint(sp);
	}

}
