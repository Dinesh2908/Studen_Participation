<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <body>
         <h2 align="left"><a href="jsps/student/add.jsp?command=studentAdd">Add Student</a></h2>
        <h3 align="center"> Student Table </h3>
        <table border="1" width="70%" align="center">
            <tr>
                <th>NetID ID</th>
                <th>Student Name</th>
                <th>UIN Participants</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${StudentList}" var="student">
                <tr>
                    <td>${student.netID }</td>
                    <td>${student.studentName }</td>
                    <td>${student.UIN}</td>
                 <td><a href="jsps/student/add.jsp?command=studentEdit&netID=${student.netID}&studentName=${student.studentName}&courseID=${student.UIN}">Edit</a>
                 &nbsp;<a style="color: red" href="DeleteServlet?command=studentDelete&id=${student.netID}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>