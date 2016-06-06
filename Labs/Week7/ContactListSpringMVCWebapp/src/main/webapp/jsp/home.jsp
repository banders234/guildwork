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
            <h1>Contact List</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li><a href="${pageContext.request.contextPath}/">Home</a></li>
                </ul>    
            </div>
            <div class="container">
                <div class="col-md-6">
                    <table class="table">
                        <thead>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Show</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </thead>
                        <c:forEach items="${contacts}" var="contact">
                            <tr>
                                <td>${contact.firstName}</td>
                                <td>${contact.lastName}</td>
                                <td><a href="contact/show?id=${contact.id}">Show</a></td>
                                <td><a href="contact/edit?id=${contact.id}">Edit</a></td>
                                <td><a href="contact/delete?id=${contact.id}">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div class="col-md-6">
                    <form:form commandName="contact" action="${pageContext.request.contextPath}/contact/create" method="POST" class="form-horizontal">
                        <div class="form-group">
                            <label class="col-md-2 control-label" for="firstName">First:</label>
                            <div class="col-md-4">
                                <form:input path="firstName" class="form-control"></form:input>
                                <form:errors path="firstName"></form:errors>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label" for="lastName">Last:</label>
                            <div class="col-md-4">
                                <form:input class="form-control" path="lastName"/>
                                <form:errors path="lastName"></form:errors>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label" for="company">Company:</label>
                            <div class="col-md-4">
                                <form:input class="form-control" path="company"/>
                                <form:errors path="company"></form:errors>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label" for="email">Email:</label>
                            <div class="col-md-4">
                                <form:input class="form-control" path="email"/>
                                <form:errors path="email"></form:errors>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label" for="phone">Phone:</label>
                            <div class="col-md-4">
                                <form:input class="form-control" path="phone"/>
                                <form:errors path="phone"></form:errors>
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

