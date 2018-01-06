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
import com.yc.bean.Proxy;
import com.yc.bean.Shippoint;
import com.yc.biz.ProxyBiz;

@Controller
@Scope("prototype")
public class ProxyController {

	@Resource(name="proxyBizImpl")
	private ProxyBiz proxyBiz;
	Map<String,Object> map=new HashMap<String,Object>();
	private Shippoint sp=new Shippoint();

	//带条件,带分页查询司机的信息
	@RequestMapping("findAllProxy.action")
	public @ResponseBody Map<String,Object>  findProxy(Proxy proxy,HttpServletRequest request,@RequestParam(value="spid") Integer spid){
		sp.setSpid(spid);
		proxy.setShippoint(sp);
		//获取pageNo
		Integer pageNo=Integer.parseInt(request.getParameter("page"));  
		//获取pageSize
		Integer pageSize=Integer.parseInt(request.getParameter("rows"));
		proxy.setPageNo((pageNo-1)*pageSize);	
		proxy.setPageSize(pageSize);	
		List<Proxy> list=new ArrayList<Proxy>();
		//因为status表示的是1或0  所以需要转换一下,0代表空闲，1代表在忙
		for(Proxy p:proxyBiz.findProxy(proxy)){
			//暂时用remark3存配送点名字
			p.setRemark3(p.getShippoint().getspname());
			p.setRemark4(String.valueOf(p.getPrid()));
			list.add(p);
		}

		//easyui必须接受这样的格式,rows和total是必须的
		map.put("rows", list);
		//proxyBiz.findDriverNoCondition(proxy).size()调用的是带条件,不带分页的查询,这里不能带分页,如果一带分页,total就会等于pageSize
		map.put("total", proxyBiz.findProxyNoCondition(proxy).size());
		return map;
	}

	//添加司机信息
	@RequestMapping("addproxy.action")
	public @ResponseBody int addProxy(Proxy proxy,@RequestParam(value="spid") Integer spid){
		sp.setSpid(spid);
		proxy.setShippoint(sp);
		try {
			proxyBiz.insertProxy(proxy);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	//批量删除司机信息
	@RequestMapping("delproxy.action")
	public @ResponseBody int delProxy(@Param(value = "prid") String prid){
		//要把prid存在list中
		String[] prids=prid.split(",");
		List<String> list=new ArrayList<String>();
		for(String p:prids){
			list.add(p);
		}
		try {
			proxyBiz.deleteProxy(list);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	//修改司机信息:不能直接用对象去接受了
	@RequestMapping("updateproxy.action")
	public @ResponseBody int updateProxy(@RequestParam(value="update_insert_prid_proxy") Integer prid,@RequestParam(value="update_insert_prname_proxy") String prname,
			@RequestParam(value="update_insert_spid") Integer spid,@RequestParam(value="update_insert_prprice_proxy") Double prprice,@RequestParam(value="update_insert_prtime_proxy") String prtime,
			@RequestParam(value="update_insert_prremark_proxy") String prremark){
		Proxy proxy=new Proxy();
		sp.setSpid(spid);
		proxy.setPrid(prid);
		proxy.setPrname(prname);
		proxy.setPrprice(prprice);
		proxy.setPrtime(prtime);
		proxy.setPrremark(prremark);
		proxy.setShippoint(sp);
		try {
			proxyBiz.updateProxy(proxy);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}


	//查询代理点详细信息
	@RequestMapping("findAproxyInfo.action")
	public @ResponseBody JsonModel findAdriveInfo(Proxy proxy){
		proxy.setShippoint(sp);
		JsonModel jsonModel=new JsonModel();
		jsonModel.setObj(proxyBiz.findProxyNoCondition(proxy));
		return jsonModel;
	}
}
