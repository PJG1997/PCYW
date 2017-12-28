/*package com.yc.testDriver;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.bean.Driver;
import com.yc.bean.Shippoint;
import com.yc.biz.DriverBiz;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml","classpath:applicationContext-dao.xml"})
public class TestDriver {
	
	@Resource(name="driverBizImpl")
	private DriverBiz driverBiz;
	
	@Test
	public void testInsert(){
		Shippoint s=new Shippoint();
		s.setSpid(1);
		Driver d=new Driver();
		d.setShipPoint(s);
		d.setDname("马自达");
		d.setDnumber("213632472");
		d.setDphone("1273407472");
		d.setDidcard("2464836429373823");
		d.setDdage(23);
		d.setDstatus(0);
		System.out.println(driverBiz.insertDriver(d));
	}
	
	@Test
	public void testUpdate(){
		Shippoint s=new Shippoint();
		s.setSpid(1);
		Driver d=new Driver();
		d.setDid(1);
		d.setShipPoint(s);
		d.setDname("马自大");
		d.setDnumber("213632472");
		d.setDphone("1273407472");
		d.setDidcard("2464836429373823");
		System.out.println(driverBiz.updateDriver(d));
	}
	
	@Test
	public void testSelect(){
		Driver d=new Driver();
		//d.setDname("马");
		d.setDphone("734");
		System.out.println(driverBiz.findDriver(d));
	}
	
}
*/