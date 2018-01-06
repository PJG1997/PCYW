package com.yc.dao;

import java.util.List;

import com.yc.bean.Log;

public interface LogDao {
	
	/**
	 * 查询所有日志
	 * 分页
	 * @param log
	 * @return
	 */
	public List<Log> searchAllLog(Log log);
	
	
	/**
	 * 无分页查询
	 * @param log
	 * @return
	 */
	public List<Log> searchAllLogNoCondition(Log log);
	
	
	/**
	 * 根据日期查询日志
	 * @param log
	 * @return
	 */
	public List<Log> searchLogByLdate(Log log);
	
	
}
