<%-- 
    Document   : editConfirmation
    Created on : Jun 4, 2016, 8:45:46 PM
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
        <title>Confirmation</title>
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
            <table class="table">
                <tr>
                    <td>Date</td>
                    <td><fmt:formatDate value="${order.date}" dateStyle="medium" /></td>
                </tr>
                <tr>
                    <td>Customer</td>
                    <td>${order.customerName}</td>
                </tr>
                <tr>
                    <td>Area</td>
                    <td>${order.area}</td>
                </tr> 
                <tr>
                    <td>State</td>
                    <td>${order.state}</td>
                </tr> 
                <tr>
                    <td>Tax Rate</td>
                    <td>${order.taxRate}</td>
                </tr> 
                <tr>
                    <td>Material Cost Per Square Foot</td>
                    <td><fmt:formatNumber type="number" maxFractionDigits="2" value="${order.materialCostPerSF}"/></td>
                <tr> 
                <tr>
                    <td>Labor Cost Per Square Foot</td>
                    <td><fmt:formatNumber type="number" maxFractionDigits="2" value="${order.laborCostPerSF}"/></td>
                </tr>
                <tr>
                    <td>Total Material Cost</td>
                    <td><fmt:formatNumber type="number" maxFractionDigits="2" value="${order.materialCost}"/></td>
                </tr>
                <tr>
                    <td>Total Labor Cost</div>
                    <td><fmt:formatNumber type="number" maxFractionDigits="2" value="${order.laborCost}"/></td>
                </tr>
                <tr>
                    <td>Tax</td>
                    <td><fmt:formatNumber type="number" maxFractionDigits="2" value="${order.tax}"/></td>
                </tr>
                <tr>
                    <td>Total</td>
                    <td><fmt:formatNumber type="number" maxFractionDigits="2" value="${order.total}"/></td>
                </tr> 
            </table>
            <div style="text-align: center">
                <form action="discard" method="POST">   
                    <button class="btn btn-danger" type="submit">Discard Changes</button>
                </form>
                <form:form modelAttribute="order" action="edit" method="POST">
                    <form:input type="hidden" path="orderNumber" value="${order.orderNumber}"/>
                    <form:input type="hidden" path="customerName" value="${order.customerName}"/>
                    <fmt:formatDate pattern="yyyy-MM-dd" value="${order.date}" var="dateString"/>
                    <form:input type="hidden" path="date" value="${dateString}"/>
                    <form:input type="hidden" path="state" value="${order.state}"/>
                    <form:input type="hidden" path="productType" value="${order.productType}"/>
                    <form:input type="hidden" path="area" value="${order.area}"/>
                    <form:input type="hidden" path="materialCostPerSF" value="${order.materialCostPerSF}"/>
                    <form:input type="hidden" path="laborCostPerSF" value="${order.laborCostPerSF}"/>
                    <form:input type="hidden" path="laborCost" value="${order.laborCost}"/>
                    <form:input type="hidden" path="materialCost" value="${order.materialCost}"/>
                    <form:input type="hidden" path="tax" value="${order.tax}"/>
                    <form:input type="hidden" path="taxRate" value="${order.taxRate}"/>
                    <form:input type="hidden" path="total" value="${order.total}"/>
                    <form:button class="btn btn-primary">Save Changes</form:button>                    
                </form:form>
            </div>
        </div>
    </body>
</html>
