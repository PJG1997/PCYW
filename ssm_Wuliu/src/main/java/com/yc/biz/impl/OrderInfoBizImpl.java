package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.bean.Orderinfo;
import com.yc.biz.OrderInfoBiz;
import com.yc.dao.OrderInfoDao;

@Service
public class OrderInfoBizImpl implements OrderInfoBiz{

	@Resource(name="orderInfoDaoImpl")
	private OrderInfoDao orderInfoDaoImpl;
	
	@Override
	public int addOrderInfoDao(Orderinfo orderInfo) {
		return orderInfoDaoImpl.addOrderInfoDao(orderInfo);
	}

	@Override
	public int delOrderInfo(List<Integer> list) {
		return orderInfoDaoImpl.delOrderInfo(list);
	}

	@Override
	public int delOrderInfoByOsid(Orderinfo orderinfo) {
		return orderInfoDaoImpl.delOrderInfoByOsid(orderinfo);
	}

}
