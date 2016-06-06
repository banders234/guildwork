<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home Page</title>
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
            <div class="container">
                <div class="col-md-6">
                    <a href="dvd/table" class="btn btn-link">Click to expand table and access search functions</a>
                    <table class="table">
                        <thead>
                            <th>Release Year</th>
                            <th>Title</th>
                            <th>Show</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </thead>
                        <c:forEach items="${dvds}" var="dvd">
                            <tr>
                                <td><fmt:formatDate value="${dvd.releaseDate}" pattern="yyyy"/></td>
                                <td>${dvd.title}</td>
                                <td><a href="dvd/show?id=${dvd.id}">Show</a></td>
                                <td><a href="dvd/edit?id=${dvd.id}">Edit</a></td>
                                <td><a href="dvd/delete?id=${dvd.id}">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div class="col-md-6">
                    <form:form modelAttribute="dvd" action="${pageContext.request.contextPath}/dvd/create" method="POST" class="form-horizontal">
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="releaseDate">Release Date:</label>
                            <div class="col-md-8">
                                <form:input class="form-control" type="date" path="releaseDate"/>
                                <form:errors path="releaseDate"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="title">Title:</label>
                            <div class="col-md-8">
                                <form:input class="form-control" path="title"/>
                                <form:errors path="title"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="director">Director:</label>
                            <div class="col-md-8">
                                <form:input class="form-control" path="director"/>
                                <form:errors path="director"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="studio">Studio:</label>
                            <div class="col-md-8">
                                <form:input class="form-control" path="studio"/>
                                <form:errors path="studio"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="mpaa">MPAA Rating:</label>
                            <div class="col-md-8">
                                <form:select class="form-control" path="mpaa">
                                    <form:option value="">Select</form:option>
                                    <form:option value="G">G</form:option>
                                    <form:option value="PG">PG</form:option>
                                    <form:option value="PG13">PG-13</form:option>
                                    <form:option value="R">R</form:option>
                                    <form:option value="NC17">NC-17</form:option>
                                </form:select>
                                <form:errors path="mpaa"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="userRating">User Rating:</label>
                            <div class="col-md-8">
                                <form:select class="form-control" path="userRating">
                                    <form:option value="">Select</form:option>
                                    <form:option value="1">1</form:option>
                                    <form:option value="2">2</form:option>
                                    <form:option value="3">3</form:option>
                                    <form:option value="4">4</form:option>
                                    <form:option value="5">5</form:option>
                                    <form:option value="6">6</form:option>
                                    <form:option value="7">7</form:option>
                                    <form:option value="8">8</form:option>
                                    <form:option value="9">9</form:option>
                                    <form:option value="10">10</form:option>
                                </form:select>
                                <form:errors path="userRating"/>
                            </div>
                            
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="notes">Notes (separated by commas):</label>
                            <div class="col-md-8">
                                <form:textarea class="form-control" path="notes"/>
                                <form:errors path="notes"/>
                            </div>
                        </div>
                        <button type="submit">Submit</button> <br>
                    </form:form>
                </div>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

