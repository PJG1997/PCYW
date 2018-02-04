package com.yc.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.yc.bean.Users;
import com.yc.dao.AdminDao;
@Repository
public class AdminDaoImpl implements AdminDao{
	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	
	/**
	 * 查询所有管理员
	 */
	@Override
	public List<Users> searchAllAdmin(Users users) {
		List<Users> ls = sqlSession.selectList("users.selectByPrimaryKey",users);
		return ls;
	}

	/**
	 * 查询总记录
	 */
	@Override
	public int total() {
		
		return sqlSession.selectOne("users.getTotal");
	}
	
	/**
	 * 添加管理员
	 */
	@Override
	public int addAdmin(Users u) {
		return sqlSession.insert("users.addUsers",u);
	}

	@Override
	public int deleteAdmin(List list) {
		return sqlSession.delete("users.deleteByPrimaryKey",list);
	}

	@Override
	public List<Users> searchAllAdminNoPage(Users users) {
		return sqlSession.selectList("users.selectByPrimaryKeyNoPage",users);
	}

	@Override
	public int updateAdmin(Users users) {
		return sqlSession.update("users.updateByPrimaryKeySelective",users);
	}

	@Override
	public int updateStatus(Users u) {
		return sqlSession.update("users.updateStatus", u);
	}
	
}
