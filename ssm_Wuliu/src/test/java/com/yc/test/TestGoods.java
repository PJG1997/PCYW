/*package com.yc.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.bean.Goods;
import com.yc.biz.GoodsBiz;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml","classpath:applicationContext-dao.xml"})
public class TestGoods {
	@Resource(name="goodsBizImpl")
	private GoodsBiz goodsBiz;
	
	*//**
	 * 添加
	 *//*
	@Test
	public void test1(){
		Goods goods = new Goods();
		goods.setGname("书");
		goods.setGprice(18.00);
		goods.setGcount("1");
		goods.setGtype("文件");
		goods.setGweight(1.20);
		goods.setGvolume(0.20);
		goods.setGremark("好看");
		this.goodsBiz.addGoods(goods);
	}
	*//**
	 * 删除
	 *//*
	@Test 
	public void test2(){
		Goods goods = new Goods();
		goods.setGid(1);
		this.goodsBiz.delGoods(goods);
	}
	*//**
	 * 查询
	 *//*
	@Test 
	public void test3(){
		Goods goods = new Goods();
		List<Goods> list=this.goodsBiz.selectAllGoods(goods);
		for(Goods good:list){
			System.out.println(good);
		}
	}
	
	
	*//**
	 * 修改
	 *//*
	@Test 
	public void test4(){
		Goods goods = new Goods();
		goods.setGid(2);
		goods.setGremark("很好看");
		goods.setGname("好书");
		this.goodsBiz.updateGoods(goods);
	}
}
*/