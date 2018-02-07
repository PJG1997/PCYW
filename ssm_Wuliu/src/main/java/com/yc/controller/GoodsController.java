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

import com.yc.bean.Driver;
import com.yc.bean.Goods;
import com.yc.bean.JsonModel;
import com.yc.biz.GoodsBiz;

@Controller
@Scope("prototype")
public class GoodsController {
	@Resource(name="goodsBizImpl")
	private GoodsBiz goodsBiz;
	private JsonModel jsonModel=new JsonModel();
	Map<String,Object> map=new HashMap<String,Object>();
	
	//查询
	@RequestMapping(value="findAllForGoods.action")
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
	
	//修改商品信息:不能直接用对象去接受了
		@RequestMapping("updategoods.action")
		public @ResponseBody int updateGoods(@RequestParam(value="update_insert_gid") Integer gid,@RequestParam(value="update_insert_gname") String gname,
				@RequestParam(value="update_insert_gcount") String gcount,@RequestParam(value="update_insert_gprice") Double gprice,@RequestParam(value="update_insert_gweight") Double gweight,
				@RequestParam(value="update_insert_gvolume") Double gvolume,@RequestParam(value="update_insert_gtype") String gtype,@RequestParam(value="update_insert_gremark") String gremark){
			Goods goods = new Goods();
			
			goods.setGid(gid);
			goods.setGname(gname);
			goods.setGprice(gprice);
			goods.setGremark(gremark);
			goods.setGtype(gtype);
			goods.setGvolume(gvolume);
			goods.setGweight(gweight);
			try {
				goodsBiz.updateGoods(goods);
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
			return 1;
		}
	
		
	/**
	 * 查询到所有的商品然后赋给前台
	 * @return
	 */
	@RequestMapping("qiantai_findAllGoods.action")
	public @ResponseBody JsonModel findAllGoods(){
		Goods goods=new Goods();
		try {
			jsonModel.setObj(goodsBiz.selectAllGoodsForPage(goods));
			jsonModel.setCode(1);
		} catch (Exception e) {
			jsonModel.setCode(0);
			e.printStackTrace();
		}
		return jsonModel;
	}
		
}
