<%-- 
    Document   : edit
    Created on : Jun 5, 2016, 5:32:28 PM
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
            <div>
                <form:form action="${pageContext.request.contextPath}/address/edit" class="form-horizontal" modelAttribute="address" method="POST">
                    <form:hidden path="id"/>
                    <div class="form-group">
                        <form:label class="col-md-4" path="firstName">First Name:</form:label> 
                        <div class="col-md-8">
                            <form:input class="form-control" path="firstName"/>
                            <form:errors path="firstName"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label class="col-md-4" path="lastName">Last Name:</form:label>
                        <div class="col-md-8">
                            <form:input class="form-control" path="lastName"/>
                            <form:errors path="lastName"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label class="col-md-4" path="streetNumber">Street Number:</form:label> 
                        <div class="col-md-8">
                            <form:input class="form-control" path="streetNumber"/>
                            <form:errors path="streetNumber"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label class="col-md-4" path="streetName">Street Name:</form:label> 
                        <div class="col-md-8">
                            <form:input class="form-control" path="streetName"/>
                            <form:errors path="streetName"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label class="col-md-4" path="city">City:</form:label> 
                        <div class="col-md-8">
                            <form:input class="form-control" path="city"/>
                            <form:errors path="city"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label class="col-md-4" path="state">State:</form:label>
                        <div class="col-md-8">
                            <form:input class="form-control" path="state"/>
                            <form:errors path="state"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label class="col-md-4" path="zip">Zip Code:</form:label> 
                        <div class="col-md-8">
                            <form:input class="form-control" path="zip"/>
                            <form:errors path="zip"/>
                        </div>
                    </div>
                    <div style="text-align: center">
                        <form:button class="btn btn-primary" type="submit">Submit</form:button>
                    </div>
                </form:form>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
