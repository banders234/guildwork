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
                    <button class="btn btn-danger" type="submit">Cancel</button>
                </form>
                <form:form modelAttribute="order" action="delete" method="POST">
                    <input type="hidden" name="orderNumber" value="${order.orderNumber}"/>
                    <input type="hidden" name="customerName" value="${order.customerName}"/>
                    <input type="hidden" name="date" value="<fmt:formatDate pattern="MM/dd/yyyy" value="${order.date}"/>"/>
                    <input type="hidden" name="state" value="${order.state}"/>
                    <input type="hidden" name="productType" value="${order.productType}"/>
                    <input type="hidden" name="area" value="${order.area}"/>
                    <button class="btn btn-primary" type="submit">Delete</button>                    
                </form:form>
            </div>
        </div>
    </body>
</html>
