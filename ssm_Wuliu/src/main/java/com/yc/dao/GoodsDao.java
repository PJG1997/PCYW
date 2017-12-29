package com.yc.dao;

import java.util.List;

import com.yc.bean.Goods;

public interface GoodsDao {
	//添加货物
	public void addGoods(Goods goods);
	//删除货物
	public void delGoods(Goods goods);
	//修改货物
	public void updateGoods(Goods goods);
	//带条件 不带分页查询
	public List<Goods> selectAllGoods(Goods goods);
	//带条件 带分页查询
	public List<Goods> selectAllGoodsForPage(Goods goods);
}
