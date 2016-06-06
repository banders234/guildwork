<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/flooring.css" rel="stylesheet">
        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
        <c:set var="pageTitle" value="home" scope="session"/>
    </head>
    <body>
        <div class="header-container">
            <jsp:include page="header.jsp"/>
        </div>
        <div class="container">
            <jsp:include page="navBar.jsp"/>
            <div class="container">
                <div class="col-md-6">
                    <form action="${pageContext.request.contextPath}/order/filterByDate" method="POST">
                        <label for="dateString">Filter By Date:</label>
                        <select name="dateString">
                            <c:forEach items="${dateList}" var="date" >
                                <fmt:formatDate pattern="MM/dd/yyyy" value="${date}" var="dateString"/>
                                <option ${dateString == selectedDateString ? 'selected' : ''} value="${dateString}">${dateString}</option>
                            </c:forEach>
                        </select>
                        <input type="submit" value="Filter">
                    </form>
                    <table class="table">
                        <thead>
                            <th>Date</th>
                            <th>Customer</th>
                            <th>Show</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </thead>
                        <c:forEach items="${orders}" var="myOrder">
                            <tbody>
                                <tr>
                                    <td><fmt:formatDate value="${myOrder.date}" dateStyle="medium"/></td>
                                    <td>${myOrder.customerName}</td>
                                    <td><a href="order/show?orderNumber=${myOrder.orderNumber}">Show</a></td>
                                    <td><a href="order/edit?orderNumber=${myOrder.orderNumber}">Edit</a></td>
                                    <td><a href="order/delete?orderNumber=${myOrder.orderNumber}">Delete</a></td>
                                </tr>
                            </tbody>
                        </c:forEach>
                    </table>
                </div>
                <div class="col-md-6">
                    <form:form action="${pageContext.request.contextPath}/order/create" modelAttribute="order" method="POST"  class="form-horizontal">
                        <div class="form-group">
                            <form:label class="col-md-4 control-label" path="date">Date:</form:label>
                            <div class="col-md-8">
                                <form:input type="date" class="form-control" path="date"/>
                                <form:errors path="date"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label class="col-md-4 control-label" path="customerName">Customer Name:</form:label>
                            <div class="col-md-8">
                                <form:input class="form-control" path="customerName"/>
                                <form:errors path="customerName"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label class="col-md-4 control-label" path="state">State:</form:label>
                            <div class="col-md-8">
                                <form:select class="form-control" path="state">
                                    <c:forEach items="${taxes}" var="tax">
                                        <form:option value="${tax.state}">${tax.state}</form:option>
                                    </c:forEach>
                                </form:select>
                                <form:errors path="state"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label class="col-md-4 control-label" path="productType">Product Type:</form:label>
                            <div class="col-md-8">
                                <form:select class="form-control" path="productType">
                                    <c:forEach items="${products}" var="product">
                                        <form:option value="${product.type}">${product.type}</form:option>
                                    </c:forEach>
                                </form:select>
                                <form:errors path="productType"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label class="col-md-4 control-label" path="area">Square Footage:</form:label>
                            <div class="col-md-8">
                                <form:input class="form-control" path="area"/>
                                <form:errors path="area"/>
                            </div>
                        </div>
                        <div style="text-align: center">
                            <button class="btn btn-primary" type="submit">Submit</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

