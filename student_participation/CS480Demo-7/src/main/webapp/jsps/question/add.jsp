<%@page import="user.domain.Student"%>
<%@page import="user.dao.StudentDao"%>
<%@page import="user.domain.Course"%>
<%@page import="user.dao.CourseDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>

        <title>Add/EDit Question</title>

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
        <h1 align="center">Add/EDit Question</h1>

        <p style="color: red; font-weight: 900">${msg}</p>
        <%
            String command = request.getParameter("command");
            String questionID = request.getParameter("questionID");
            String question = request.getParameter("question");
            String studentID = request.getParameter("studentID");
            String courseId = request.getParameter("courseID");
        %>

        <form action="<c:url value='/AddServlet'/>" method="post">

            <input type="hidden" name="method" value="<%=command%>"/>

            <% if (questionID != null && !questionID.isEmpty()) {%>

            Question ID    :<input type="text" required name="questionID" readonly value="<%=questionID == null ? "" : questionID%>"/>
            <span style="color: red; font-weight: 900">${errors.questionID }</span>
            <br/><br/>
            <%}%>
            Question：<input type="text" required name="question" maxlength="500" size="60" value="<%=question == null ? "" : question%>"/>
            <span style="color: red; font-weight: 900">${errors.question }</span>
            <br/><br/>
            StudentID：<select class="form-control" id="studentID" name="studentID" value="<%=courseId%>">
                <% StudentDao studentDao = new StudentDao();
                    for (Student student : studentDao.findallWithOutCount()) {
                %>
                <option value="<%= student.getNetID()%>" <%=student.getNetID().equals(studentID) ? "selected" : ""%>> <%=student.getStudentName()%></option> 
                <%}%>
            </select>
             <span style="color: red; font-weight: 900">${errors.courseId }</span>
            <br/><br/>
            Course: <select class="form-control" id="StudentCourse" name="courseID" value="<%=courseId%>">
                <% CourseDao courseDao = new CourseDao();
                    for (Course course : courseDao.findall()) {
                %>
                <option value="<%= course.getCourseID()%>" <%=course.getCourseID().equals(courseId) ? "selected" : ""%> ><%=course.getCourseName()%></option> 
                <%}%>
            </select>
            <br/> <br/>
            <input type="submit" value="Submit"/> &nbsp; &nbsp; 
        </form>
    </body>
</html>
