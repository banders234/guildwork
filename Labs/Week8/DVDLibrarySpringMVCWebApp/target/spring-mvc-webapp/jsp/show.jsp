<%-- 
    Document   : edit
    Created on : May 31, 2016, 9:13:48 PM
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
                        <td>Release Date</td>
                        <td><fmt:formatDate value="${dvd.releaseDate}" dateStyle="medium" /></td>
                    </tr>
                    <tr>
                        <td>Title</td>
                        <td>${dvd.title}</td>
                    </tr>
                    <tr>
                        <td>Director</td>
                        <td>${dvd.director}</td>
                    </tr>
                    <tr>
                        <td>Studio</td>
                        <td>${dvd.studio}</td>
                    </tr>
                    <tr>
                        <td>User Rating</td>
                        <td>${dvd.userRating}</td>
                    </tr>
                    <tr>
                        <td>Notes</td>
                        <td>
                        <c:forEach items="${dvd.noteList}" var="note">
                            ${note}<br>
                        </c:forEach>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>
