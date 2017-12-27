package com.yc.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(
		value="/back/manager/*",
		initParams={@WebInitParam(name="errorPage",value="back/login.html")}
)	//过滤路径
public class CheckUserLoginFilter implements Filter{

	private String errorLogin="back/login.html";
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) arg0;
		HttpServletResponse response=(HttpServletResponse) arg1;
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html charset=utf-8");
		
		
		HttpSession session=request.getSession();
		if(session.getAttribute("uname")==null){
			String path=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
			PrintWriter out=response.getWriter();
			out.println("<script>alert('请先登录...');location.href='"+path+errorLogin+"'</script>");
			out.flush();
			out.close();
		}else{
			arg2.doFilter(arg0, arg1);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		String str=arg0.getInitParameter("errorPage");
		if(str!=null){
			errorLogin=str;
		}
	}
}
