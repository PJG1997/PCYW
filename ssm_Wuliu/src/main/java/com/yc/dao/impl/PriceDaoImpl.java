package com.yc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.yc.bean.Price;
import com.yc.dao.PriceDao;
@Repository
public class PriceDaoImpl implements PriceDao{
	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	
	/**
	 * 添加
	 */
	@Override
	public void addPrice(Price price) {
		this.sqlSession.insert("price.insert", price);
	}
	
	/**
	 * 修改
	 */
	@Override
	public void updatePrice(Price price) {
		this.sqlSession.update("price.updateByPrimaryKeySelective", price);
	}
	
	/**
	 * 删除
	 */
	@Override
	public void deletePrice(Price price) {
		this.sqlSession.update("price.deleteByPrimaryKey",price);
	}
	
	/**
	 * 查询
	 */
	@Override
	public List<Price> selectPrice(Price price) {
		return this.sqlSession.selectList("price.selectByPrimaryKey", price);
	}

}
