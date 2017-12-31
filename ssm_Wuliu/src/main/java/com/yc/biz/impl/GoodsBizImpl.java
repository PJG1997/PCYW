package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.Goods;
import com.yc.biz.GoodsBiz;
import com.yc.dao.GoodsDao;
@Service
@Transactional(readOnly=false,isolation=Isolation.DEFAULT,rollbackForClassName={"java.lang.RuntimeException"},propagation=Propagation.REQUIRED)
public class GoodsBizImpl implements GoodsBiz{
	@Resource(name="goodsDaoImpl")
	private GoodsDao goodsDao;
	@Override
	public void addGoods(Goods goods) {
		this.goodsDao.addGoods(goods);
	}

	@Override
	public void delGoods(List list) {
		this.goodsDao.delGoods(list);
	}

	@Override
	public void updateGoods(Goods goods) {
		this.goodsDao.updateGoods(goods);
	}

	@Override
	public List<Goods> selectAllGoods(Goods goods) {
		return this.goodsDao.selectAllGoods(goods);
	}

	@Override
	public List<Goods> selectAllGoodsForPage(Goods goods) {
		return this.goodsDao.selectAllGoodsForPage(goods);
	}

}
