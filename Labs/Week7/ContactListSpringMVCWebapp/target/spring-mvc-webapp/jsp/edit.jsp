<%-- 
    Document   : edit
    Created on : May 31, 2016, 9:13:48 PM
    Author     : apprentice
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
                    <li role="presentation"><a href="${pageContext.request.contextPath}/">Home</a></li>
                </ul>    
            </div>
            <form action="/contact/update" method="POST" class="form-horizontal">
                <input type="hidden" name="id" value="${contact.id}">
                <div class="form-group">
                    <label for="firstName" class="col-md-3">First Name:</label>
                    <input name="firstName" class="col-md-6" value="${contact.firstName} ">
                </div>
                <div class="form-group">
                    <label for="lastName" class="col-md-3">Last Name:</label>
                    <input name="lastName" class="col-md-6" value="${contact.lastName} ">
                </div>
                <div class="form-group">
                    <label for="company" class="col-md-3">Company:</label>
                    <input name="company" class="col-md-6" value="${contact.company} ">
                </div>
                <div class="form-group">
                    <label for="email" class="col-md-3">Email:</label>
                    <input name="email" class="col-md-6" value="${contact.email}">
                </div>
                <div class="form-group">
                    <label for="phone" class="col-md-3">Phone:</label>
                    <input name="phone" class="col-md-6" value="${contact.phone}">
                </div>
                <button type="submit">Submit</button>
            </form>
        </div>
    </body>
</html>
