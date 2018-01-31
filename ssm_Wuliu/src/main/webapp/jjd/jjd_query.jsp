<%@ page language="java" import="java.util.*,com.yc.bean.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="css/table.css" rel="stylesheet" type="text/css">
	<link href="css/jgpsdtable.css" rel="stylesheet" type="text/css">
	<link href="css/wenzi.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="../back/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
	
	
	
<script type="text/javascript">

</script>
<title>生成交接单</title>
<link href="../css/table.css" rel="stylesheet" type="text/css"> 
</head>
<body leftmargin="0" topmargin="15">
 <div id="content-header">
  <br/>
   <center><h1>交接单查询</h1></center> 
	<form id="form1" method="post" action="handover_selectHandoversByCondition">
		<table >
            <tr>
              <td bgcolor="#FFFFFF" width="25%">&nbsp;交接单状态:
						<select name="handover.hstatus">
							<option value="0" selected="selected">
								未发车
							</option>
							<option value="1">
								已发车
							</option>
							<option value="2">
								已完成
							</option>
						</select>
					</td>
			    <td bgcolor="#FFFFFF"  width="25%">&nbsp;订单编号:&nbsp;&nbsp;&nbsp;
			    	<input type="text" id="osid">
              </td>
              <td bgcolor="#FFFFFF" colspan="2"   width="25%">&nbsp;上车时间:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <input name="scsj" id="starttime" type="text" size="10" onfocus="WdatePicker({lang:'en'})"><img src="../images/img_date.gif" width="22" >
				</td>
			    <td bgcolor="#FFFFFF" rowspan="2" style="text-align:center">
			     <input type="submit"  size="12" style="background-image: url(../images/chaxun.jpg);border:none;width:81;height:22" value=""  /><!-- <img src="yemian/images/chaxun.jpg" width="81" height="22" onclick="sub1()"> --></td>
            </tr>
			 <tr> 
				  <td bgcolor="#FFFFFF">&nbsp;起始点:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				  	<select name="handover.hfromSpname" id="froms">
				    	
					</select>
				  </td>
				  <td bgcolor="#FFFFFF">&nbsp;终止点:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				  	<select name="handover.htoSpname" id="tos">
				    	
					</select>
				  </td>
            </tr>
        </table>
    </form>
</div>
 <div class="container-fluid">
    <hr>
    <div class="row-fluid">
      <div class="span12">     
        <div class="widget-box">
          <div class="widget-title">
          	 <h5>交接单列表</h5>
          </div>
    	  <div class="widget-content nopadding">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table data-table table-bordered"  >
			  <thead>
                <tr>
                	<th>序号</th>
                	<th>交接单号</th>
                	<th>所属订单号</th>
                	<th>起始点</th>
                	<th>目的地</th>
                	<th>上车时间</th>
                	<th>交接人(司机)</th>
                	<th>车牌号</th>
                	<th>交接时间</th>
                	<th>状态</th>
                </tr>
                </thead>
	    		<tbody id="jjdInfo">      
	          		
				</tbody>
		</table>
          </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>