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
            <form action="${pageContext.request.contextPath}/address/search" method="POST">
                <div>
                    <div class="col-md-12">
                        <label class="control-label" for="searchType">Enter search type and value:</label>
                    </div>
                    <div class="col-md-4">
                        <select class="form-control" name="searchType">
                            <option value="city">City</option>
                            <option value="state">State (Abbreviation)</option>
                            <option value="zip">Zip</option>
                            <option value="lastName">Last Name</option>
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
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Street Number</th>
                        <th>Street Name</th>
                        <th>City</th>
                        <th>State</th>
                        <th>Zip Code</th>
                        <th>Show</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <c:forEach items="${addresses}" var="address">
                    <tr>
                        <td>${address.firstName}</td>
                        <td>${address.lastName}</td>
                        <td>${address.streetNumber}</td>
                        <td>${address.streetName}</td>
                        <td>${address.city}</td>
                        <td>${address.state}</td>
                        <td>${address.zip}</td>                            
                        <td><a href="address/show?id=${address.id}">Show</a></td>
                        <td><a href="address/edit?id=${address.id}">Edit</a></td>
                        <td><a href="address/delete?id=${address.id}">Delete</a></td> 
                    </tr>
                </c:forEach>
                <div>
                    ${emptyMessage}
                </div>
            </table>
        </div>
    </body>
</html>
