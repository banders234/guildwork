<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Address Book Home</title>
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
            <div class="col-md-6">
                <a href="address/table" class="btn btn-link">Click to expand table and access search functions</a>
                <table class="table">
                    <thead>
                        <tr>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Show</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <c:forEach items="${addresses}" var="address">
                        <tr>
                            <td>${address.firstName}</td>
                            <td>${address.lastName}</td>
                            <td><a href="address/show?id=${address.id}">Show</a></td>
                            <td><a href="address/edit?id=${address.id}">Edit</a></td>
                            <td><a href="address/delete?id=${address.id}">Delete</a></td> 
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="col-md-6">
                <form:form action="${pageContext.request.contextPath}/address/create" class="form-horizontal" modelAttribute="address" method="POST">
                    <div class="form-group">
                        <form:label class="col-md-4" path="firstName">First Name:</form:label> 
                        <div class="col-md-8">
                            <form:input class="form-control" path="firstName"/>
                            <form:errors path="firstName"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label class="col-md-4" path="lastName">Last Name:</form:label>
                        <div class="col-md-8">
                            <form:input class="form-control" path="lastName"/>
                            <form:errors path="lastName"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label class="col-md-4" path="streetNumber">Street Number:</form:label> 
                        <div class="col-md-8">
                            <form:input class="form-control" path="streetNumber"/>
                            <form:errors path="streetNumber"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label class="col-md-4" path="streetName">Street Name:</form:label> 
                        <div class="col-md-8">
                            <form:input class="form-control" path="streetName"/>
                            <form:errors path="streetName"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label class="col-md-4" path="city">City:</form:label> 
                        <div class="col-md-8">
                            <form:input class="form-control" path="city"/>
                            <form:errors path="city"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label class="col-md-4" path="state">State:</form:label>
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
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label class="col-md-4" path="zip">Zip Code:</form:label> 
                        <div class="col-md-8">
                            <form:input class="form-control" path="zip"/>
                            <form:errors path="zip"/>
                        </div>
                    </div>
                    <div style="text-align: center">
                        <form:button class="btn btn-primary" type="submit">Submit</form:button>
                    </div>
                </form:form>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

