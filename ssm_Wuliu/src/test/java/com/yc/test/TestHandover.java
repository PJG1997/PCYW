package com.yc.test;

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
import com.yc.biz.HandoverBiz;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml","classpath:applicationContext-dao.xml"})

public class TestHandover {
	@Resource(name="handoverBizImpl")
	private HandoverBiz handoverBiz;
	
	//添加
	@Test
	public void test1(){
		String route="长沙-上海-北京";

		String r[]=route.split("-");
		for(int i=0;i<r.length-1;i++){
			Handover h=new Handover();
			Car c=new Car();
			Driver d=new Driver();
			Order1 o=new Order1();
			Route ro=new Route();
			h.setHfromspname(r[i]);
			h.setHtospname(r[i+1]);
			c.setCid(0);
			o.setOsid(0);
			d.setDid(0);
			ro.setRid(0);
			h.setCar(c);
			h.setDriver(d);
			h.setOrder1(o);
			h.setRoute(ro);
			handoverBiz.addHandover(h);
		}
		
	}

}
