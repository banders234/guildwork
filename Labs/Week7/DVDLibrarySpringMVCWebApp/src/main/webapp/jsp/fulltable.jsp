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
        <title>Address Book Home</title>
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
            <form action="${pageContext.request.contextPath}/dvd/search" method="POST">
                <div>
                    <div class="col-md-12">
                        <label class="control-label" for="searchType">Enter search type and value:</label>
                    </div>
                    <div class="col-md-4">
                        <select class="form-control" name="searchType">
                            <option value="director">Director</option>
                            <option value="age">Age in Years (Less Than)</option>
                            <option value="mpaa">MPAA Rating</option>
                            <option value="studio">Studio</option>
                        </select>
                    </div>
                    <div class="col-md-5">
                        <input class="form-control" name="searchValue"/>
                    </div>
                    <div class="col-md-3">
                        <button class="btn btn-default" type="submit">Search</button>
                    </div>
                </div>
            </form>
            <table class="table">
                <thead>
                    <tr>
                        <th>Title</th>
                        <th>Release Date</th>
                        <th>MPAA Rating</th>
                        <th>Director</th>
                        <th>Studio</th>
                        <th>User Rating</th>
                        <th>Show</th>
                        <th>Edit</th>
                        <th>Delete</th>
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
                        <td><a href="dvd/show?id=${dvd.id}">Show</a></td>
                        <td><a href="dvd/edit?id=${dvd.id}">Edit</a></td>
                        <td><a href="dvd/delete?id=${dvd.id}">Delete</a></td> 
                    </tr>
                </c:forEach>
                <div>
                    ${emptyMessage}
                </div>
            </table>
        </div>
    </body>
</html>
