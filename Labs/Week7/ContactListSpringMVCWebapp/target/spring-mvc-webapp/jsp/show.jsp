<%-- 
    Document   : edit
    Created on : May 31, 2016, 9:13:48 PM
    Author     : apprentice
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
            <h1>Contact List</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li><a href="${pageContext.request.contextPath}/">Home</a></li>
                </ul>    
            </div>
            <div>
                <div class="panel panel-default">
                    <div class="panel-heading">First Name</div>
                    <div class="panel-body">${contact.firstName}</div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">Last Name</div>
                    <div class="panel-body">${contact.lastName}</div>
                </div> 
                <div class="panel panel-default">
                    <div class="panel-heading">Company</div>
                    <div class="panel-body">${contact.company}</div>
                </div> 
                <div class="panel panel-default">
                    <div class="panel-heading">Email</div>
                    <div class="panel-body">${contact.email}</div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">Phone</div>
                    <div class="panel-body">${contact.phone}</div>
                </div> 
            </div>
        </div>
    </body>
</html>
