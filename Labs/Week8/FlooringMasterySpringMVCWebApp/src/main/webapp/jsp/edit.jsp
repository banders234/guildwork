<%-- 
    Document   : edit
    Created on : May 31, 2016, 9:13:48 PM
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
            <form:form modelAttribute="order" action="update" method="POST" role="form" class="form-horizontal">
                <form:input type="hidden" path="orderNumber"/>
                <div class="form-group">
                    <label for="date" class="col-md-2 control-label">Date:</label>
                    <div class="col-md-4">
                      
                        <form:input type="date" path="date" class="form-control" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="customerName" class="col-md-2 control-label">Customer Name:</label>
                    <div class="col-md-4">
                        <form:input path="customerName" class="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label" for="productType">Product Type:</label>
                    <div class="col-md-4">
                        <form:select class="form-control" path="productType">
                            <c:forEach items="${products}" var="product">
                                <option ${product.type == order.productType ? 'selected' : ''}>${product.type}</option>           
                            </c:forEach>
                        </form:select>
                    </div>
                </div>
                    
                <div class="form-group">
                    <label class="col-md-2 control-label" for="state">State:</label>
                    <div class="col-md-4">
                        <form:select class="form-control" path="state">
                            <c:forEach items="${taxes}" var="tax">
                                <option ${tax.state == order.state ? 'selected' : ''}>${tax.state}</option>
                            </c:forEach>
                        </form:select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label" for="area">Square Footage:</label>
                    <div class="col-md-4">
                        <form:input class="form-control" value="${order.area}" path="area"/>
                    </div>
                </div>                       
                <button type="submit">Submit</button>
            </form:form>
        </div>
    </body>
</html>
