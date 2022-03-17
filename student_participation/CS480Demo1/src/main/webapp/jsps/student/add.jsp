<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Add/EDit Student</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
      <h1 align="center">Add/EDit Student</h1>

<p style="color: red; font-weight: 900">${msg}</p>
<% 
    String command=request.getParameter("command");
    String netID=request.getParameter("netID");
    String studentName=request.getParameter("studentName");
    String UIN=request.getParameter("UIN");
%>

<form action="<c:url value='/AddServlet'/>" method="post">
         
	<input type="hidden" name="method" value="<%=command%>"/>
        
	NetID    :<input type="text" required name="netID" value="<%=netID==null?"":netID %>"/>
	<span style="color: red; font-weight: 900">${errors.netID }</span>
	<br/>
	StudentName：<input type="text" required name="studentName" value="<%=studentName==null?"":studentName %>"/>
	<span style="color: red; font-weight: 900">${errors.studentName }</span>
	<br/>
        UIN：<input type="number" required name="UIN" value="<%=UIN%>"/>
	<span style="color: red; font-weight: 900">${errors.UIN}</span>
	<br/>
        <input type="submit" value="Submit"/> &nbsp; &nbsp; 
</form>
  </body>
</html>
