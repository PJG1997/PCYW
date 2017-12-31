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

import com.yc.bean.Price;
import com.yc.bean.JsonModel;
import com.yc.bean.Price;
import com.yc.biz.PriceBiz;

@Controller
@Scope("prototype")
public class PriceController {
	
	@Resource(name="priceBizImpl")
	private PriceBiz priceBiz;
	Map<String,Object> map=new HashMap<String,Object>();
	private JsonModel jsonModel=new JsonModel();
	
	//带条件,带分页查询价格的信息
		@RequestMapping("findAllPrice.action")
		public @ResponseBody Map<String,Object>  findPrice(Price price,HttpServletRequest request){
			//获取pageNo
			Integer pageNo=Integer.parseInt(request.getParameter("page"));  
			//获取pageSize
			Integer pageSize=Integer.parseInt(request.getParameter("rows"));
			price.setPageNo((pageNo-1)*pageSize);	
			price.setPageSize(pageSize);	
			List<Price> list=new ArrayList<Price>();
			//因为status表示的是1或0  所以需要转换一下,0代表空闲，1代表在忙
			for(Price p:priceBiz.selectPrice(price)){
				p.setRemark4(String.valueOf(p.getPid()));
				list.add(p);
			}
			
			//easyui必须接受这样的格式,rows和total是必须的
			map.put("rows", list);
			//PriceBiz.findPriceNoCondition(Price).size()调用的是带条件,不带分页的查询,这里不能带分页,如果一带分页,total就会等于pageSize
			map.put("total", priceBiz.selectPriceNoPage(price).size());
			return map;
		}
		
		//添加价格信息
		@RequestMapping("addPrice.action")
		public @ResponseBody int addPrice(Price price){
			try {
				priceBiz.addPrice(price);;
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
			return 1;
		}
		//批量删除价格信息
		@RequestMapping("delPrice.action")
		public @ResponseBody int delPrice(@Param(value = "pid") String pid){
			//要把did存在list中
			String[] dids=pid.split(",");
			List<String> list=new ArrayList<String>();
			for(String d:dids){
				list.add(d);
			}
			try {
				priceBiz.deletePrice(list);;
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
			return 1;
		}
		
		//修改价格信息:不能直接用对象去接受了
		@RequestMapping("updatePrice.action")
		public @ResponseBody int updatePrice(@RequestParam(value="update_insert_pid") Integer pid,@RequestParam(value="update_insert_pfrom") String pfrom,
				@RequestParam(value="update_insert_pto") String pto,@RequestParam(value="update_insert_pfirstwei") Double pfirstwei,@RequestParam(value="update_insert_prestwei") Double prestwei,
				@RequestParam(value="update_insert_pfirstvol") Double pfirstvol,@RequestParam(value="update_insert_prestvol") Double prestvol,@RequestParam(value="update_insert_pretime") String pretime){
			Price price=new Price();
			price.setPid(pid);
			price.setPfrom(pfrom);
			price.setPto(pto);
			price.setPfirstwei(pfirstwei);
			price.setPrestwei(prestwei);
			price.setPfirstvol(pfirstvol);
			price.setPrestvol(prestvol);
			price.setPretime(pretime);
			try {
				priceBiz.updatePrice(price);;
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
			return 1;
		}
		
		
		//查询价格详细信息
		@RequestMapping("findPriceInfo.action")
		public @ResponseBody JsonModel findPriceInfo(Price price){
			JsonModel jsonModel=new JsonModel();
			jsonModel.setObj(priceBiz.selectPriceNoPage(price));
			return jsonModel;
		}
	
}
