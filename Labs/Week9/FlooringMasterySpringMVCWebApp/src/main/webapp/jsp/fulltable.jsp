<%-- 
    Document   : fulltable
    Created on : Jun 5, 2016, 6:21:08 PM
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
        <title>Flooring Table</title>

        <link href="${pageContext.request.contextPath}/css/flooring.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
        
        <c:set var="pageTitle" value="table" scope="session"/>
        <link href="https://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" />
        <link href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css" rel="stylesheet" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/table.js"></script>
    </head>
    <body>
        <div class="header-container">
            <jsp:include page="header.jsp"/>
        </div>
        <div class="container">
            
            <jsp:include page="navBar.jsp"/>
            <table class="table table-striped table-bordered display" id="example">
                <thead>
                    <tr> 
                        <th>Date</th>
                        <th>Cust. Name</th>
                        <th>State</th>
                        <th>Feet<sup>2</sup></th>
                        <th>Mat. Cost / Feet<sup>2</sup></th>
                        <th>Labor Cost / Feet<sup>2</sup></th>
                        <th>Lab. Cost</th>
                        <th>Mat. Cost</th>
                        <th>Tax Rate</th>
                        <th>Tax</th>
                        <th>Total</th>
                    </tr>
                </thead>
                <c:forEach items="${orders}" var="order">
                    <tr>
                        <td><fmt:formatDate  pattern="MM/dd/YYYY" value="${order.date}" /></td>
                        <td>${order.customerName}</td>
                        <td>${order.state}</td>
                        <td>${order.area}</td>
                        <td>${order.materialCostPerSF}</td>
                        <td>${order.laborCostPerSF}</td>
                        <td><fmt:formatNumber maxFractionDigits="2" value="${order.materialCost}"/></td>
                        <td><fmt:formatNumber maxFractionDigits="2" value="${order.laborCost}"/></td>
                        <td>${order.taxRate}</td>
                        <td><fmt:formatNumber maxFractionDigits="2" value="${order.tax}"/></td>
                        <td><fmt:formatNumber maxFractionDigits="2" value="${order.total}"/></td>                         
                    </tr>
                </c:forEach>
                <div>
                    ${emptyMessage}
                </div>
            </table>
        </div>
    </body>
</html>
