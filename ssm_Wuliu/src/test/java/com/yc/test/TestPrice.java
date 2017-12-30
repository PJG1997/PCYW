package com.yc.test;


import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.bean.Price;
import com.yc.biz.PriceBiz;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml","classpath:applicationContext-dao.xml"})
public class TestPrice {
	@Resource(name="priceBizImpl")
	private PriceBiz priceBiz;
	@Test
	public void test1(){
		Price price =new Price();
		price.setPfrom("长沙");
		price.setPto("北京");
		price.setPfirstwei(50.0);
		price.setPrestwei(60.0);
		price.setPfirstvol(5.0);
		price.setPrestvol(10.0);
		price.setPretime("01-12");
		this.priceBiz.addPrice(price);
	}
	@Test
	public void test2(){
		Price price =new Price();
		price.setPid(1);
		this.priceBiz.deletePrice(price);
	}
	
	@Test
	public void test3(){
		Price price =new Price();
		price.setPid(1);
		price.setPrestvol(8.0);
		price.setPto("西安");
		this.priceBiz.updatePrice(price);
	}
	
	@Test
	public void test4(){
		Price price =new Price();
		List<Price> list = this.priceBiz.selectPrice(price);
		for(Price prices:list){
			System.out.println(prices);
		}
	}
}
