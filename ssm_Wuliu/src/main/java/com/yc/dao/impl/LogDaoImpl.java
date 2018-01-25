package com.yc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.yc.bean.Log;
import com.yc.dao.LogDao;
@Repository
public class LogDaoImpl implements LogDao {
	
	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public List<Log> searchAllLog(Log log) {
		List<Log> ls = sqlSession.selectList("log.searchAllLog",log);
		return ls;
	}

	@Override
	public List<Log> searchAllLogNoCondition(Log log) {
		return sqlSession.selectList("log.searchAllLogNoCondition",log);
	}

	@Override
	public List<Log> searchLogByLdate(Log log) {
		return sqlSession.selectList("log.searchLogByldate",log);
	}

	@Override
	public int insertLog(Log log) {
		return sqlSession.insert("log.insertLog",log);
	}

}
