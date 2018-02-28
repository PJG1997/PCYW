package com.yc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.yc.bean.Orderinfo;
import com.yc.dao.OrderInfoDao;

@Repository
public class OrderInfoDaoImpl implements OrderInfoDao{

	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int addOrderInfoDao(Orderinfo orderInfo) {
		int result=sqlSession.insert("orderinfo.insertPiLianOrderInfo", orderInfo);
		return result;
	}

	@Override
	public int delOrderInfo(List<Integer> list) {
		return sqlSession.delete("orderinfo.deleteOrderInfo", list);
	}
}
