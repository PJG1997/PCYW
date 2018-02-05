package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.Log;
import com.yc.biz.LogBiz;
import com.yc.dao.LogDao;
@Service
@Transactional(isolation=Isolation.DEFAULT,rollbackForClassName={"java.lang.RuntimeException"},propagation=Propagation.REQUIRED)
public class LogBizImpl implements LogBiz {
	
	@Resource(name="logDaoImpl")
	private LogDao logDao;
	
	@Override
	public List<Log> searchAllLog(Log log) {
		return logDao.searchAllLog(log);
	}

	@Override
	public List<Log> searchAllLogNoCondition(Log log) {
		return logDao.searchAllLogNoCondition(log);
	}

	@Override
	public List<Log> searchLogByldate(Log log) {
		return logDao.searchLogByLdate(log);
	}

	@Override
	public int insertLog(Log log) {
		return logDao.insertLog(log);
	}

}
