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
            <jsp:include page="navbar.jsp"/>
            <form:form modelAttribute="dvd" action="update" method="POST" role="form" class="form-horizontal">
                <input type="hidden" name="id" value="${dvd.id}">
                <div class="form-group">
                    <label for="date" class="col-md-4 control-label">Date:</label>
                    <div class="col-md-8">
                        <fmt:formatDate pattern="yyyy-MM-dd" value="${dvd.releaseDate}" var="dateString"/>
                        <form:input type="date" path="releaseDate" class="form-control" value="${dateString}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="customerName" class="col-md-4 control-label">Customer Name:</label>
                    <div class="col-md-8">
                        <form:input path="title" class="form-control" value="${dvd.title}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-4 control-label" for="director">Director:</label>
                    <div class="col-md-8">
                        <form:input path="director" class="form-control" value="${dvd.director}"/>
                    </div>
                </div>
                    
                <div class="form-group">
                    <label class="col-md-4 control-label" for="studio">Studio:</label>
                    <div class="col-md-8">
                        <form:input path="studio" class="form-control" value="${dvd.studio}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-4 control-label" for="userRating">User Rating:</label>
                    <div class="col-md-8">
                        <form:select class="form-control" path="userRating">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                            <option>6</option>
                            <option>7</option>
                            <option>8</option>
                            <option>9</option>
                            <option>10</option>
                        </form:select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-4 control-label" for="notes">Notes (separated by commas):</label>
                    <div class="col-md-8">
                        <form:textarea class="form-control" path="notes"/>
                        <form:errors path="notes"/>
                    </div>
                </div>
                <button type="submit">Submit</button>
            </form:form>
        </div>
    </body>
</html>
