package com.yc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.JsonModel;
import com.yc.bean.Route;
import com.yc.biz.RouteBiz;

@Controller
@Scope("prototype")
public class RouteController {
	@Resource(name="routeBizImpl")
	private RouteBiz routeBiz;
	Map<String,Object> map=new HashMap<String,Object>();
	private JsonModel jsonModel=new JsonModel();
	
	//查询
	@RequestMapping(value="findAllForRoute.action")
	public @ResponseBody Map<String,Object>  findRoute(Route route,HttpServletRequest request){
		//获取pageNo
		Integer pageNo=Integer.parseInt(request.getParameter("page"));  
		//获取pageSize
		Integer pageSize=Integer.parseInt(request.getParameter("rows"));
		route.setPageNo((pageNo-1)*pageSize);	//pageNo表示pageNo
		route.setPageSize(pageSize);	//pageSize表示pageSize
		List<Route> list=new ArrayList<Route>();
		
		for(Route r:routeBiz.selectRouteForPage(route)){
			//remark4存给gid
			r.setRemark4(String.valueOf(r.getRid()));
			list.add(r);
		}
		
		//easyui必须接受这样的格式,rows和total是必须的
		map.put("rows", list);
		//routeBiz.selectRoute(route).size()调用的是带条件,不带分页的查询,这里不能带分页,如果一带分页,total就会等于pageSize
		map.put("total", routeBiz.selectRoute(route).size());
		return map;
	}
	//查询商品详细信息
	@RequestMapping("findRouteInfo.action")
	public @ResponseBody JsonModel findRouteInfo(Route route){
		JsonModel jsonModel=new JsonModel();
		jsonModel.setObj(routeBiz.selectRoute(route));
		return jsonModel;
	}
	
	//添加商品
	@RequestMapping("addRoute.action")
	public @ResponseBody JsonModel addDriver(@RequestParam(value="route_rid") Integer rid,@RequestParam(value="routeName") String routeName,@RequestParam(value="routeShunxu") String routeShunxu){
		Route route=new Route();
		String[] routes=routeShunxu.split(",");
		String rs="";
		for(int i=0,len=routes.length;i<len;i++){
			if(i==len-1){
				rs+=routes[i];
			}else{
				rs+=routes[i]+"-";
			}
		}
		route.setRname(routeName);
		route.setRvia(rs);
		try {
			if(rid==0){
				routeBiz.addRoute(route);
			}else{
				route.setRid(rid);
				routeBiz.updateRoute(route);
			}
			jsonModel.setCode(1);
		} catch (Exception e) {
			jsonModel.setCode(0);
			e.printStackTrace();
		}
		jsonModel.setObj(route);
		return jsonModel;
	}
	
	//批量删除
	@RequestMapping("delRoute.action")
	public @ResponseBody int delRoute(@Param(value = "rid") String rid){
		//要把gid存在list中
		String[] rids=rid.split(",");
		List<String> list=new ArrayList<String>();
		for(String r:rids){
			list.add(r);
		}
		try {
			routeBiz.deleteRoute(list);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	
	//修改商品信息:不能直接用对象去接受了
		@RequestMapping("updateRoute.action")
		public @ResponseBody int updateRoute(@RequestParam(value="update_insert_rid_route") Integer rid,@RequestParam(value="update_insert_rname_route") String rname,
				@RequestParam(value="update_insert_rvia_route") String rvia){
			Route route = new Route();
			route.setRname(rname);
			route.setRvia(rvia);
			route.setRid(rid);
			try {
				routeBiz.updateRoute(route);
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
			return 1;
		}
	
}
