package com.yc.biz;

import java.util.List;

import com.yc.bean.Goods;

public interface GoodsBiz{
	//添加货物
	public void addGoods(Goods goods);
	//删除货物
	public void delGoods(List list);
	//修改货物
	public void updateGoods(Goods goods);
	//不带分页查询
	public List<Goods> selectAllGoods(Goods goods);
	//带条件 带分页查询
	public List<Goods> selectAllGoodsForPage(Goods goods);
}
