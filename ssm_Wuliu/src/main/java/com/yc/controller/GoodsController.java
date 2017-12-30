package com.yc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.Goods;
import com.yc.biz.GoodsBiz;

@Controller
@Scope("prototype")
public class GoodsController {
	@Resource(name="goodsBizImpl")
	private GoodsBiz goodsBiz;
	Map<String,Object> map=new HashMap<String,Object>();
	
	@RequestMapping(name="findAllForGoods.action")
	public @ResponseBody Map<String,Object>  findDriver(Goods goods,HttpServletRequest request){
		//获取pageNo
		Integer pageNo=Integer.parseInt(request.getParameter("page"));  
		//获取pageSize
		Integer pageSize=Integer.parseInt(request.getParameter("rows"));
		goods.setPageNo((pageNo-1)*pageSize);	//pageNo表示pageNo
		goods.setPageSize(pageSize);	//pageSize表示pageSize
		List<Goods> list=new ArrayList<Goods>();
		
		for(Goods good:goodsBiz.selectAllGoodsForPage(goods)){
			//remark4存给gid
			good.setRemark4(String.valueOf(goods.getGid()));
			list.add(good);
		}
		
		//easyui必须接受这样的格式,rows和total是必须的
		map.put("rows", list);
		//goodsBiz.selectAllGoods(goods).size()调用的是带条件,不带分页的查询,这里不能带分页,如果一带分页,total就会等于pageSize
		map.put("total", goodsBiz.selectAllGoods(goods).size());
		return map;
	}
}
