package com.yc.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.bean.Car;
import com.yc.bean.Driver;
import com.yc.bean.Handover;
import com.yc.bean.Order1;
import com.yc.bean.Route;
import com.yc.bean.Shippoint;
import com.yc.bean.Users;
import com.yc.biz.CarBiz;
import com.yc.biz.DriverBiz;
import com.yc.biz.HandoverBiz;
import com.yc.biz.Order1Biz;
import com.yc.biz.RouteBiz;
import com.yc.biz.UsersBiz;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml","classpath:applicationContext-dao.xml"})

public class TestHandover {
	@Resource(name="handoverBizImpl")
	private HandoverBiz handoverBiz;
	@Resource(name="order1BizImpl")
	private Order1Biz order1Biz;
	@Resource(name="routeBizImpl")
	private RouteBiz routeBiz;
	@Resource(name="driverBizImpl")
	private DriverBiz driverBiz;
	@Resource(name="carBizImpl")
	private CarBiz carBiz;
	@Resource(name="usersBizImpl")
	private UsersBiz usersBiz;
	//添加
	@Test
	public void test1(){
		Integer osid=1;
		Order1 o=new Order1();
		o.setOsid(osid);
		Order1 or=new Order1();
		or=  order1Biz.findRid(o);
		Integer rid=Integer.parseInt(or.getRemark1());
		Route r=new Route();
		r.setRid(rid);
		String rvia=routeBiz.findRvia(r).getRvia();
		String rivaname[]=rvia.split("-");
		for(int i=0;i<rivaname.length-1;i++){
			Handover h=new Handover();
			h.setHfromspname(rivaname[i]);
			h.setHtospname(rivaname[i+1]);
			h.setOrder1(o);
			h.setRoute(r);
			Car c=new Car();
			Driver d=new Driver();
			h.setCar(c);
			h.setDriver(d);
			handoverBiz.addHandover(h);
		}
		
		
	}
	//查询改地点能委派的司机
	@Test
	public void test2(){
		Integer hid=1;
		Handover h=new Handover();
		h.setHid(hid);
		Handover hand=handoverBiz.gethandover(h);
		String spname=hand.getHfromspname();
		Driver d=new Driver();
		Shippoint sp=new Shippoint();
		sp.setSpaddress(spname);
		d.setShipPoint(sp);
		List<Driver> list=new ArrayList<Driver>();
		for(Driver driver:driverBiz.findDriverNoCondition(d))
			list.add(driver);
		System.out.println(list);
	}
	
	//查询改地点能委派的车辆
		@Test
		public void test3(){
			Integer hid=1;
			Handover h=new Handover();
			h.setHid(hid);
			Handover hand=handoverBiz.gethandover(h);
			String spname=hand.getHfromspname();
			Car c=new Car();
			Shippoint sp=new Shippoint();
			sp.setSpaddress(spname);
			c.setShipPoint(sp);
			List<Car> list=new ArrayList<Car>();
			for(Car car:carBiz.getCarInfo(c))
				list.add(car);
			System.out.println(list);
		}
	//权限
		@Test
		public void test4(){
			Integer usid=1;
			Users u=new Users();
			u.setUsid(usid);
			Users user=usersBiz.findUsersByUsid(u);
			String address=user.getUaddress();
			 
			
		}
}
