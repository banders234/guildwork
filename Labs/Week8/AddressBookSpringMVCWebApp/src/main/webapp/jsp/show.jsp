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
        <title>Address Display</title>
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
                        <td>First Name</td>
                        <td>${address.firstName}</td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td>${address.lastName}</td>
                    </tr>
                    <tr>
                        <td>Street Number</td>
                        <td>${address.streetNumber}</td>
                    </tr>
                    <tr>
                        <td>Street Name</td>
                        <td>${address.streetName}</td>
                    </tr>
                    <tr>
                        <td>City</td>
                        <td>${address.city}</td>
                    </tr>
                    <tr>
                        <td>State</td>
                        <td>${address.state}</td>
                    </tr>
                    <tr>
                        <td>Zip Code</td>
                        <td>${address.zip}</td>
                    </tr>
                    
                </table>
                <div style="text-align: center">
                    <a href="${pageContext.request.contextPath}/" class="btn btn-primary">Return</a>
                </div>
            </div>
        </div>
    </body>
</html>
