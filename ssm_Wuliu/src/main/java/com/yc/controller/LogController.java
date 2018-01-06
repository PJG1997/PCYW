package com.yc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.Log;
import com.yc.biz.LogBiz;

@Controller
@Scope(value="prototype")
public class LogController {
	@Resource(name="logBizImpl")
	private LogBiz logBiz;
	
	@RequestMapping(value="findAllLog.action")
	@ResponseBody
	public Map<String,Object> findAllLog(HttpSession session,HttpServletRequest request,Log log){
		
		 Map<String,Object> map = new HashMap<String,Object>();

		 Integer pageNo=Integer.parseInt(request.getParameter("page"));  
		 //获取pageSize
		 Integer pageSize=Integer.parseInt(request.getParameter("rows"));
		 log.setPageNo((pageNo-1)*pageSize);	
		 log.setPageSize(pageSize);
		 List<Log> ls = logBiz.searchAllLog(log);
		 
		 map.put("rows", ls);
		 map.put("total", logBiz.searchAllLogNoCondition(log).size());
		 
		return map;
	}
	
	
}
