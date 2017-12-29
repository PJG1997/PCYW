package com.yc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.yc.bean.Goods;
import com.yc.dao.GoodsDao;

@Repository
public class GoodsDaoImpl implements GoodsDao{
	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	
	/**
	 * 添加货物
	 */
	@Override
	public void addGoods(Goods goods) {
		this.sqlSession.insert("goods.insert", goods);
	}
	
	/**
	 * 删除货物
	 */
	@Override
	public void delGoods(Goods goods) {
		this.sqlSession.delete("goods.deleteByPrimaryKey", goods);
	}
	
	/**
	 * 修改货物
	 */
	@Override
	public void updateGoods(Goods goods) {
		this.sqlSession.update("goods.updateByPrimaryKeySelective", goods);
	}
	/**
	 * 不带分页查询
	 */
	@Override
	public List<Goods> selectAllGoods(Goods goods) {
		return this.sqlSession.selectList("goods.select", goods);
	}
	/**
	 * 带分页
	 */
	@Override
	public List<Goods> selectAllGoodsForPage(Goods goods) {
		return this.sqlSession.selectList("goods.selectPage", goods);
	}

}
