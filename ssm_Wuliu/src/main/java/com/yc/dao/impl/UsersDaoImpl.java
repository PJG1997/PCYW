package com.yc.dao.impl;

import java.util.List;

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
	/**
	 * 分页查询
	 */
	@Override
	public List<Users> searchAllUsers(Users u) {
		
		List<Users> ls = sqlSession.selectList("users.searchAllUsers",u);
		return ls;
		
	}
	/**
	 * 无分页查询
	 */
	public List<Users> searchAllUsersNoCondition(Users u){
		return sqlSession.selectList("users.selectDriverNoCondition",u);
	}
	
	/**
	 * 获取总数
	 */
	@Override
	public int total() {
		
		return sqlSession.selectOne("users.getTotal2");
	}
	@Override
	public int insertUser(Users u) {
		
		return sqlSession.insert("users.insertSelective",u);
	}
	/**
	 * 修改用户
	 */
	@Override
	public int updateUser(Users u) {
		
		return sqlSession.update("users.updateByPrimaryKeySelective",u);
		
	}
	
	/**
	 * 删除用户
	 */
	@Override
	public int deleteUsers(Users u) {
		
		return sqlSession.update("users.updateByPrimaryKeySelective",u);
	}

}
