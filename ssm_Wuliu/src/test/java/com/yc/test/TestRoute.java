package com.yc.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.bean.Route;
import com.yc.biz.RouteBiz;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml","classpath:applicationContext-dao.xml"})
public class TestRoute {
	@Resource(name="routeBizImpl")
	private RouteBiz routeBiz;
	
	/**
	 * 添加
	 */
	@Test
	public void test1(){
		Route route = new Route();
		route.setRname("长北");
		route.setRvia("长沙—北京");
		this.routeBiz.addRoute(route);
	}
	
	/**
	 * 删除
	 */
	@Test
	public void test2(){
		Route route = new Route();
		route.setRid(1);
		this.routeBiz.deleteRoute(route);
	}
	
	/**
	 * 查询
	 */
	@Test
	public void test3(){
		Route route = new Route();
		List<Route> list=this.routeBiz.selectRoute(route);
		for(Route routes:list){
			System.out.println(routes);
		}
	}
	
	/**
	 * 修改
	 */
	@Test
	public void test4(){
		Route route = new Route();
		route.setRid(1);
		route.setRvia("长沙-西安");
		this.routeBiz.updateRoute(route);
	}
}
