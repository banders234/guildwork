<%-- 
    Document   : editProduct
    Created on : Jun 4, 2016, 11:08:06 PM
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Contact</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/flooring.css" rel="stylesheet">
        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body>
        <div class="header-container">
            <jsp:include page="header.jsp"/>
        </div>
        <div class="container">
            <jsp:include page="navBar.jsp"/>
            <form:form modelAttribute="product" action="editProduct" method="POST" role="form" class="form-horizontal">
                <div class="form-group">
                    <form:label class="col-md-4 control-label" path="type">Type:</form:label>
                    <div class="col-md-8">
                        <form:input class="form-control" path="type" type="text" readonly="true"/>
                    </div>
                </div>
                <div class="form-group">
                    <form:label class="col-md-4 control-label" path="materialCostPerSF">Material Cost Per Square Foot:</form:label>
                    <div class="col-md-8">
                        <form:input class="form-control" path="materialCostPerSF" type="text"/>
                    </div>
                </div>
                <div class="form-group">
                    <form:label class="col-md-4 control-label" path="laborCostPerSF">Labor Cost Per Square Foot:</form:label>
                    <div class="col-md-8">
                        <form:input class="form-control" path="laborCostPerSF" type="text"/> 
                    </div>
                </div>
                <form:button type="submit">Submit</form:button>
            </form:form>
        </div>
    </body>
</html>