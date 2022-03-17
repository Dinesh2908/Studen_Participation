<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <body>
        <h2 align="left"><a href="jsps/professor/add.jsp?command=professorAdd">Add Professor</a></h2>
        <h3 align="center">Professor Table </h3>
        <table border="1" width="70%" align="center">
            <tr>
                <th>Prof ID</th>
                <th>Professor Name</th>
                <th>Course ID</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${ProfessorList}" var="professor">
                <tr>
                    <td>${professor.profID }</td>
                    <td>${professor.profName }</td>
                    <td>${professor.courseID}</td>
                    <td><a href="jsps/professor/add.jsp?command=professorEdit&profID=${professor.profID}&profName=${professor.profName}&courseID=${professor.courseID}">Edit</a>
                 &nbsp;<a style="color: red" href="DeleteServlet?command=professorDelete&id=${professor.profID}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>