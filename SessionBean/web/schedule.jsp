<%-- 
 Centralized Schedule View (10 Marks): Create schedule.jsp. 
o Design an HTML <table> to display the training data. 
o Use JSP Scriptlets (<% for(...) { %>) or JSTL (<c:forEach>) to iterate through the 
sessionList attribute and print the details of each training session inside the table 
rows. 
--%>

<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DriveSmart Integrated Academy</title>
    </head>
        <title>DriveSmart Integrated Academy</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <body>
            <header>
                <nav class="navbar navbar-expand-md navbar-dark"
                style="background-color: tomato">
                <div>
                <a href="" class="navbar-brand"> DriveSmart Integrated Academy </a>
                </div>
                <ul class="navbar-nav">
                <li><a href="<%=request.getContextPath()%>/list"
                class="nav-link">Training Session</a></li>
                </ul>
                </nav>
            </header>
            <br>
            <div class="row">
            <div class="container">
            <h3 class="text-center">List of Training Sessions</h3>
            <hr>
            <div class="container text-left">
            <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New Session</a>
            </div>
            <br>
            <table class="table table-bordered">
            <thead>
            <tr>
            <th>Session ID</th>
            <th>Student Name</th>
            <th>Branch Location</th>
            <th>Lesson Type</th>
            <th>Status</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="session"
            items="${listSession}">
            <tr>
            <td><c:out value="${session.id}"
            /></td>
            <td><c:out value="${session.name}"
            /></td>
            <td><c:out value="${session.branch}"
            /></td>
            <td><c:out value="${session.type}"
            /></td>
            <td><c:out value="${session.status}"
            /></td>
            <td>
            <a href="edit?id=<c:out value=
            '${session.id}' />">Edit</a>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <a href="delete?id=<c:out value=
            '${session.id}' />">Delete</a>
            </td>
            </tr>
            </c:forEach>
            </tbody>
            </table>
            </div>
            </div>

        </body>

</html>
