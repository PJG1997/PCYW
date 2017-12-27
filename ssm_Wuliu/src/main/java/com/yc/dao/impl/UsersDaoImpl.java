package com.yc.dao.impl;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.yc.bean.Users;
import com.yc.dao.UsersDao;
@Repository
public class UsersDaoImpl implements UsersDao{
	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	@Override
	public Users login(Users user) {
		return sqlSession.selectOne("users.loginByPrimaryKey",user);
	}

}
