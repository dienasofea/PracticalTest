<%-- 
    Document   : index
    Created on : 16 Jun 2026, 2:15:51 PM
    Author     : MP2-4

o Use the JSP Include Directive (<%@ include file="..." %>) to merge the 
header.html and footer.jsp into the top and bottom of the page. 
o Use standard HTML anchor tags (<a>) to create a central navigation menu 
pointing to the two functional modules: the Booking Form (book_session.jsp) and 
the Schedule Dashboard (ScheduleServlet). 

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="header.html" %>     
        <title>DriveSmart Integrated Academy</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
    <h1>DriveSmart Integrated Academy</h1><br>
    <ul>
    <li><a href="schedule.jsp"> All Training Session List </a></li>
    <li><a href="book_session.jsp"> Book a New Session </a></li>
    </ul>
    </body>
    <%@ include file="footer.jsp" %>
</html>