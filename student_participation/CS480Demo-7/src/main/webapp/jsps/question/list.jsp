<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <body>
         <h2 align="left"><a href="jsps/question/add.jsp?command=questionAdd">Add Question</a></h2>
        <h3 align="center">Question Table </h3>
        <table border="1" width="70%" align="center">
            <tr>
                <th>Question ID</th>
                <th>Question</th>
                <th>Course</th>
                 <th>Student</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${QuestionList}" var="question">
                <tr>
                    <td>${question.questionid}</td>
                    <td>${question.question}</td>
                    <td>${question.courseid}</td>
                     <td>${question.studentid}</td>
                 <td><a href="jsps/question/add.jsp?command=questionEdit&questionID=${question.questionid}&question=${question.question}&studentID=${question.studentid}&courseID=${question.courseid}">Edit</a>
                 &nbsp;<a style="color: red" href="DeleteServlet?command=questionDelete&id=${question.questionid}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>