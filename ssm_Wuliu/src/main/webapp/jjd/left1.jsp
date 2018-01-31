<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<title>页面左边</title>
<script language="JavaScript" type="text/JavaScript">
</script>


</head>

<body background="../images/leftbg1.jpg" leftmargin="0" topmargin="0" >
<table width="100" height="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td height="9"><img src="" width="1" height="1"></td>
  </tr>
  <tr> 
    <td height="11"><img src="../images/left01.jpg" width="145" height="36"></td>
  </tr>
  <tr> 
    <td height="11" valign="top" background="../images/leftbg.jpg">&nbsp;
    <img src="../images/jjdgl.jpg" name="ksblbt031" width="130" height="23" border="0" style="cursor: hand"></td>
  </tr>
  <tr id="Menu1">
    <td valign="top" background="../images/leftbg.jpg">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="5" valign="top"><img src="../images/line.jpg" width="137" height="2"></td>
        </tr>
        <tr>
          <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr> 
                <td width="4">&nbsp;</td>
                <td><table width="98" border="0" cellspacing="0" cellpadding="0">
                    <tr> 
                      <td><img src="" width="131" height="5"></td>
                    </tr>
                    <!-- 交接单查询 -->
                    <tr> 
                      <td background=""><div align="center">
                      <a href="jjd_query.jsp" target="mainFrame1">
                      <img src="../images/jjdcx.jpg" name="ksblbt018" width="124" height="24" border="0"></a></div></td>
                    </tr>
                   
                   <!-- 生成交接单 -->
					<tr>
					  <td background=""><div align="center"><a href="handover_selectAllNewOrders" target="mainFrame1">
					  <img src="../images/scjjd.jpg" name="ksblbt020" width="124" height="24" border="0"></a></div>
					</tr>
					
					<!-- 未发车交接单维护 -->
					<tr>
					  <td background=""><div align="center"><a href="handover_selectAllNewHandovers?handover.hstatus=0" target="mainFrame1" style="font-size: 14">新交接单维护</a></div></td>
					</tr>
					
					<!-- 已发车交接单维护 -->
					<tr>
					  <td background=""><div align="center"><a href="handover_selectAllOldHandovers?handover.hstatus=1" target="mainFrame1"><img src="../images/dhjjwh.jpg" name="xddcx" width="124" height="24" border="0"></a></div></td>
					</tr>
					
                  </table></td>
              </tr>
            </table></td>
        </tr>
      </table> </td>
  </tr>
  <tr> 
    <td height="5"><img src="../images/left02.jpg" width="145" height="36"></td>
  </tr>
  <tr> 
    <td height="6"><img src="" width="1" height="1"></td>
  </tr>
</table>
</body>
</html>
