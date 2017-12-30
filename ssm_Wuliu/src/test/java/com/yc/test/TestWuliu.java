/*package com.yc.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.bean.Car;
import com.yc.bean.Shippoint;
import com.yc.biz.CarBiz;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml","classpath:applicationContext-dao.xml"})
public class TestWuliu {
	
	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Test
	public void testSqlSession(){
		System.out.println(sqlSession);
	}
	
	@Resource(name="carBizImpl")
	private CarBiz carBiz;
	
	//测试添加车子的信息
	@Test
	public void test1(){
		Car c=new Car();
		Shippoint sp=new Shippoint();
		sp.setSpid(1);
		c.setShipPoint(sp);
		c.setCnumber("123");
		c.setCtype("法拉利");
		c.setCbuyday(new Date(117,12,25));
		c.setCrunnum("123123");
		c.setCvolume(123.0);
		c.setCton(225.5);
		c.setCstatus(0);
		c.setCisbox(0);
		c.setCremake(" ");
		this.carBiz.addCar(c);
	}
	//更新车子的状态测试
	@Test
	public void test3(){
		Car c=new Car();
		c.setCstatus(1);
		c.setCid(2);
		this.carBiz.updateCarStatus(c);
	}
	
}
*/