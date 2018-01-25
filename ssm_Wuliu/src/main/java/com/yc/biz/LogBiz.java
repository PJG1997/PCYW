package com.yc.biz;

import java.util.List;

import com.yc.bean.Log;

public interface LogBiz {
	
	/**
	 * 查询所有日志
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
	public List<Log> searchLogByldate(Log log);
	
	/**
	 * 添加日志
	 * @param log
	 * @return
	 */
	public int insertLog(Log log);
	
}
