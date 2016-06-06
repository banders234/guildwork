<%-- 
    Document   : admin
    Created on : Jun 3, 2016, 4:30:10 PM
    Author     : apprentice
--%>
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
        <c:set var="pageTitle" value="admin" scope="session"/>
    </head>
    <body>
        <div class="header-container">
            <jsp:include page="header.jsp"/>
        </div>
        <div class="container">
            <jsp:include page="navBar.jsp"/>
            <div class="container">
                <div class="col-md-6">
                    <table class="table">
                        <thead>
                            <th>Product</th>
                            <th>Material Cost</th>
                            <th>Labor Cost</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </thead>
                        <c:forEach items="${products}" var="myProduct">
                            <tbody>
                                <tr>
                                    <td>${myProduct.type}</td>
                                    <td>${myProduct.materialCostPerSF}</td>
                                    <td>${myProduct.laborCostPerSF}</td>
                                    <td><a href="${pageContext.request.contextPath}/admin/editProduct?type=${myProduct.type}">Edit</a></td>
                                    <td><a href="${pageContext.request.contextPath}/admin/deleteProduct?type=${myProduct.type}">Delete</a></td>
                                </tr>
                            </tbody>
                        </c:forEach>
                    </table>
                    <table class="table">
                        <thead>
                            <th>State</th>
                            <th>Tax Rate</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </thead>
                        <c:forEach items="${taxes}" var="myTax">
                            <tbody>
                                <tr>
                                    <td>${myTax.state}</td>
                                    <td>${myTax.taxRate}</td>
                                    <td><a href="${pageContext.request.contextPath}/admin/editTax?state=${myTax.state}">Edit</a></td>
                                    <td><a href="${pageContext.request.contextPath}/admin/deleteTax?state=${myTax.state}">Delete</a></td>
                                </tr>
                            </tbody>
                        </c:forEach>
                    </table>
                </div>
                <div style="text-align: center">
                    <h2>Add Product</h2>
                </div>
                <div class="col-md-6">
                    <form:form action="${pageContext.request.contextPath}/admin/addProduct" modelAttribute="product" method="POST"  class="form-horizontal">
                        <div class="form-group">
                            <form:label class="col-md-4 control-label" path="type">Type:</form:label>
                            <div class="col-md-8">
                                <form:input class="form-control" path="type"/>
                                <p>${productMessage}</p>
                                <form:errors path="type"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label class="col-md-4 control-label" path="materialCostPerSF">Material Cost Per Square Foot:</form:label>
                            <div class="col-md-8">
                                <form:input class="form-control" path="materialCostPerSF"/>
                                <form:errors path="materialCostPerSF"/>
                            </div>
                        </div>
 
                        <div class="form-group">
                            <form:label class="col-md-4 control-label" path="laborCostPerSF">Labor Cost Per Square Foot:</form:label>
                            <div class="col-md-8">
                                <form:input class="form-control" path="laborCostPerSF"/>
                                <form:errors path="laborCostPerSF"/>
                            </div>
                        </div>
                        <div style="text-align: center">
                            <button class="btn btn-primary" type="submit">Submit</button> <br>
                        </div>
                    </form:form>
                    <div style="text-align: center">
                        <h2>Add State Tax Rate</h2>
                    </div>
                    <form:form action="${pageContext.request.contextPath}/admin/addTax" modelAttribute="tax" method="POST"  class="form-horizontal">
                        <div class="form-group">
                            <form:label class="col-md-4 control-label" path="state">State:</form:label>
                            <div class="col-md-8">
                                <form:select class="form-control" path="state">
                                    <form:option value="AL">Alabama</form:option>
                                    <form:option value="AK">Alaska</form:option>
                                    <form:option value="AZ">Arizona</form:option>
                                    <form:option value="AR">Arkansas</form:option>
                                    <form:option value="CA">California</form:option>
                                    <form:option value="CO">Colorado</form:option>
                                    <form:option value="CT">Connecticut</form:option>
                                    <form:option value="DE">Delaware</form:option>
                                    <form:option value="FL">Florida</form:option>
                                    <form:option value="GA">Georgia</form:option>
                                    <form:option value="HI">Hawaii</form:option>
                                    <form:option value="ID">Idaho</form:option>
                                    <form:option value="IL">Illinois</form:option>
                                    <form:option value="IN">Indiana</form:option>
                                    <form:option value="IA">Iowa</form:option>
                                    <form:option value="KS">Kansas</form:option>
                                    <form:option value="KY">Kentucky</form:option>
                                    <form:option value="LA">Louisiana</form:option>
                                    <form:option value="ME">Maine</form:option>
                                    <form:option value="MD">Maryland</form:option>
                                    <form:option value="MA">Massachusetts</form:option>
                                    <form:option value="MI">Michigan</form:option>
                                    <form:option value="MN">Minnesota</form:option>
                                    <form:option value="MT">Montana</form:option>
                                    <form:option value="NE">Nebraska</form:option>
                                    <form:option value="NV">Nevada</form:option>
                                    <form:option value="NH">New Hampshire</form:option>
                                    <form:option value="NJ">New Jersey</form:option>
                                    <form:option value="NM">New Mexico</form:option>
                                    <form:option value="NY">New York</form:option>
                                    <form:option value="NC">North Carolina</form:option>
                                    <form:option value="ND">North Dakota</form:option>
                                    <form:option value="OH">Ohio</form:option>
                                    <form:option value="OK">Oklahoma</form:option>
                                    <form:option value="OR">Oregon</form:option>
                                    <form:option value="PA">Pennsylvania</form:option>
                                    <form:option value="RI">Rhode Island</form:option>
                                    <form:option value="SC">South Carolina</form:option>
                                    <form:option value="SD">South Dakota</form:option>
                                    <form:option value="TN">Tennessee</form:option>
                                    <form:option value="TX">Texas</form:option>
                                    <form:option value="UT">Utah</form:option>
                                    <form:option value="VT">Vermont</form:option>
                                    <form:option value="VA">Virginia</form:option>
                                    <form:option value="WA">Washington</form:option>
                                    <form:option value="WV">West Virginia</form:option>
                                    <form:option value="WI">Wisconsin</form:option>
                                    <form:option value="WY">Wyoming</form:option>
                                </form:select>
                                <form:errors path="state"/>
                                <div>
                                    ${taxMessage}
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label class="col-md-4 control-label" path="taxRate">Tax Rate:</form:label>
                            <div class="col-md-8">
                                <form:input class="form-control" path="taxRate"/>
                                <form:errors path="taxRate"/>
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
