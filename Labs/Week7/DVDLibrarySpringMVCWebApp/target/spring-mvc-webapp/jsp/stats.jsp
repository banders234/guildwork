<%-- 
    Document   : stats
    Created on : Jun 5, 2016, 8:32:46 PM
    Author     : apprentice
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Contact</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">
        
        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body>
        <div class="container">
            <jsp:include page="header.jsp"/>
            <jsp:include page="navbar.jsp"/>
            <div>
                <table class="table">
                    <tr>
                        <td>Number of DVDS</td>
                        <td>${count}</td>
                    </tr>
                    <tr>
                        <td>Oldest DVD in Library</td>
                        <td>${oldest.title}</td>
                    </tr>
                    <tr>
                        <td>Newest DVD in Library</td>
                        <td>${newest.title}</td>
                    </tr>
                    <tr>
                        <td>Average Age of DVD's in Library</td>
                        <td><fmt:formatNumber maxFractionDigits="2" value="${averageAge}"/> years</td>
                    </tr>
                    <tr>
                        <td>Average Number of Notes Per DVD</td>
                        <td>${averageNotes}</td>
                    </tr>
                </table>
                <div style="text-align: center">
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/">Return Home</a>
                </div>
            </div>
        </div>
    </body>
</html>
