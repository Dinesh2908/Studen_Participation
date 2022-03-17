<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <body>
        <h2 align="left"><a href="jsps/course/add.jsp?command=courseAdd">Add Course</a></h2>
        <h3 align="center"> Course Table </h3>
        <table border="1" width="70%" align="center">
            <tr>
                <th>Course ID</th>
                <th>Course Name</th>
                <th>Max Participants</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${CourseList}" var="course">
                <tr>
                    <td>${course.courseID }</td>
                    <td>${course.courseName }</td>
                    <td>${course.maxParticipants}</td>
                    <td><a href="jsps/course/add.jsp?command=courseEdit&courseID=${course.courseID}&courseName=${course.courseName}&maxParticipants=${course.maxParticipants}">Edit</a>
                    &nbsp; <a style="color: red" href="DeleteServlet?command=courseDelete&id=${course.courseID}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>