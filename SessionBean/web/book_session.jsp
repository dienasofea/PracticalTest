<%-- 
. Book Session View (10 Marks): Create book_session.jsp. 
o Design an HTML <form> that uses method="POST" and 
action="BookSessionServlet". 
o Include input fields for Student Name, Branch Location, and Lesson Type.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Session</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">             
    </head>
    <body>
       <header>
            <nav class="navbar navbar-expand-md navbar-dark"
            style="background-color: tomato">
            <div>
            <a href="" class="navbar-brand"> Book Session </a>
            </div>
            <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list"
            class="nav-link">Sessions</a></li>
            </ul>
            </nav>
        </header>
            
        <br>
        <div class="container col-md-5">
        <div class="card">
        <div class="card-body">
        <c:if test="${session != null}">
        <form action="BookSessionServlet" method="post">
        </c:if>
        <c:if test="${session == null}">
        <form action="BookSessionServlet" method="post">
        </c:if>
        <h2>
        <c:if test="${session != null}">
        Edit Session
        </c:if>
        <c:if test="${session == null}">
        Add New Session
        </c:if>
        </h2>
        <c:if test="${session != null}">
        <input type="hidden" name="id" value="
        <c:out value='${session.id}' />" />
        </c:if>
        <fieldset class="form-group">
        <label>Student Name</label>
        <input type="text" value="<c:out
        value='${session.name}' />"
        class="form-control" name="name"
        required="required">
        </fieldset>
        <fieldset class="form-group">
        <label>Branch Location</label>
        <input type="text" value="<c:out
        value='${session.branch}' />"
        class="form-control" name="branch">
        </fieldset>
        <fieldset class="form-group">
        <label>Lesson Type</label>
        <input lesson="lessonList" id="lesson"
        class="form-control"
        name="lesson" value="<c:out
        value='${session.lesson}' />">
        <datalist id="lessonList">
        <option value="Manual Car">
        <option value="Automatic Car">
        <option value="Motorcycle">
        </datalist>
        </fieldset>
        <button type="submit" class="btn btn
        success">Submit Booking</button>
        </form>
        </div>
        </div>
        </div>   
    </body>
</html>
