<%-- 
    Document   : results
    Created on : May 27, 2016, 9:24:58 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Interest Calculator Results</title>
    </head>
    <body>
        <div class="col-md-4">
            <h3>Year</h3>
            <c:forEach items="${yearList}" var="year">
                ${year}<br>
            </c:forEach>
        </div>
        <div class="col-md-4">
            <h3>Starting Principal</h3>
            <c:forEach items="${sPrincipalList}" var="sPrincipal">
                ${sPrincipal}<br>
            </c:forEach>
        </div>
        <div class="col-md-4">
            <h3>Ending Principal</h3>
            <c:forEach items="${ePrincipalList}" var="ePrincipal">
                ${ePrincipal}<br>
            </c:forEach>
        </div>
    </body>
</html>
