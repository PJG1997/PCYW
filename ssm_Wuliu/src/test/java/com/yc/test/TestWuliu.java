package com.yc.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml","classpath:applicationContext-dao.xml"})
public class TestWuliu {
	
	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Test
	public void testSqlSession(){
		System.out.println(sqlSession);
	}
}
