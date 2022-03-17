<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Add/EDit Professor</title>
    
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
      <h1 align="center">Add/EDit Professor</h1>

<p style="color: red; font-weight: 900">${msg}</p>
<% 
    String command=request.getParameter("command");
    String profID=request.getParameter("profID");
    String profName=request.getParameter("profName");
    String courseID=request.getParameter("courseID");
%>

<form action="<c:url value='/AddServlet'/>" method="post">
         
	<input type="hidden" name="method" value="<%=command%>"/>
        
	ProfID    :<input type="text" required name="profID" value="<%=profID==null?"":profID %>"/>
	<span style="color: red; font-weight: 900">${errors.profID }</span>
	<br/>
	ProfName：<input type="text" required name="profName" value="<%=profName==null?"":profName %>"/>
	<span style="color: red; font-weight: 900">${errors.profName }</span>
	<br/>
        CourseID	：<input type="number" required name="courseID" value="<%=courseID==null?"":courseID %>"/>
	<span style="color: red; font-weight: 900">${errors.courseID}</span>
	<br/>
        <input type="submit" value="Submit"/> &nbsp; &nbsp; 
</form>
  </body>
</html>
