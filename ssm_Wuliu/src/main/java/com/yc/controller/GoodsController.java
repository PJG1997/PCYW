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
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.Goods;
import com.yc.bean.JsonModel;
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
		
		for(Goods good:goodsBiz.selectAllGoods(goods)){
			//remark4存给gid
			good.setRemark4(String.valueOf(good.getGid()));
			list.add(good);
		}
		
		//easyui必须接受这样的格式,rows和total是必须的
		map.put("rows", list);
		//goodsBiz.selectAllGoods(goods).size()调用的是带条件,不带分页的查询,这里不能带分页,如果一带分页,total就会等于pageSize
		map.put("total", goodsBiz.selectAllGoods(goods).size());
		return map;
	}
	
	//查询商品详细信息
	@RequestMapping("findGoodsInfo.action")
	public @ResponseBody JsonModel findGoodsInfo(Goods goods){
		JsonModel jsonModel=new JsonModel();
		jsonModel.setObj(goodsBiz.selectAllGoods(goods));
		return jsonModel;
	}
	
	//添加商品
	@RequestMapping("addgoods.action")
	public @ResponseBody int addDriver(Goods goods){
		try {
			goodsBiz.addGoods(goods);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	
	//批量删除
	@RequestMapping("delgoods.action")
	public @ResponseBody int delDriver(@Param(value = "gid") String gid){
		//要把gid存在list中
		String[] gids=gid.split(",");
		List<String> list=new ArrayList<String>();
		for(String g:gids){
			list.add(g);
		}
		try {
			goodsBiz.delGoods(list);;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	
}
