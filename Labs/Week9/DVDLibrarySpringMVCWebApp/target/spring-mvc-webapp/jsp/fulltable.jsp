<%-- 
    Document   : fulltable
    Created on : Jun 5, 2016, 6:21:08 PM
    Author     : apprentice
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Data</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/dvdlibrary.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
        <link href="https://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" />
        <link href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css" rel="stylesheet" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/table.js"></script>
    </head>
    <body id="data-tables-body"> 
        <div class="container" id="data-tables-container">
            <jsp:include page="navbar.jsp"/>
            <table class="table" id="example">
                <thead>
                    <tr>
                        <th>Title</th>
                        <th>Release Date</th>
                        <th>MPAA Rating</th>
                        <th>Director</th>
                        <th>Studio</th>
                        <th>User Rating</th>
                        <th>Metascore</th>
                        <th>IMDB Rating</th>
                        <th>IMDB Votes</th>
                    </tr>
                </thead>
                <c:forEach items="${dvds}" var="dvd">
                    <tr>
                        <td>${dvd.title}</td>
                        <td><fmt:formatDate  dateStyle="medium" value="${dvd.releaseDate}" /></td>
                        <td>${dvd.mpaa}</td>
                        <td>${dvd.director}</td>
                        <td>${dvd.studio}</td>
                        <td>${dvd.userRating}</td>
                        <td>${dvd.metascore}</td>
                        <td>${dvd.imdbRating}</td>
                        <td>${dvd.imdbVotes}</td>
                    </tr>
                </c:forEach>
                
            </table>
        </div>
    </body>
</html>
