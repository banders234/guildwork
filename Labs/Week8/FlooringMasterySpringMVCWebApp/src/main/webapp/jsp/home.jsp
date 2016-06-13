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
                    <div class="table-info">
                        <div class="col-md-8">
                            <div class="form-inline">
                                <div class="row">
                                    <label for="dateString">Filter By Date:</label>
                                    <select name="dateString" id="filter-date">
                                        <option value="Show All">Show All</option>
                                        <c:forEach items="${dateList}" var="date" >
                                            <fmt:formatDate pattern="MM/dd/yyyy" value="${date}" var="dateString"/>
                                            <option value="${dateString}">${dateString}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4" style="text-align: right">
                            <a class="btn btn-primary" href="${pageContext.request.contextPath}/order/table">Expand table</a>     
                        </div>
                    </div>

                    <table class="table table-bordered" id="order-table">
                        <thead>
                            <th>Date</th>
                            <th>Customer</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </thead>
                        <tbody>
                            <c:forEach items="${orders}" var="order">
                                <tr id="order-row-${order.orderNumber}">
                                    <td id='order-date-cell'><fmt:formatDate pattern="MM/dd/yyyy" value="${order.date}"/></td>
                                    <td><a data-order-order-number="${order.orderNumber}" data-toggle="modal" data-target="#showOrderModal">${order.customerName}</a></td>
                                    <td><a data-order-order-number="${order.orderNumber}" data-toggle="modal" data-target="#editOrderModal">Edit</a></td>
                                    <td><a data-order-order-number="${order.orderNumber}" class='delete-link'>Delete</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                        
                    </table>
                </div>
                <div class="col-md-6">
                    <form method="POST"  class="form-horizontal">
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="date-input">Date:</label>
                            <div class="col-md-8">
                                <input type="date" class="form-control" id="date-input"/>
                                <errors path="date"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" path="customerName">Customer Name:</label>
                            <div class="col-md-8">
                                <input class="form-control" id="customer-name-input"/>
                                <errors path="customerName"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" path="state">State:</label>
                            <div class="col-md-8">
                                <select class="form-control" id="state-input">
                                    <c:forEach items="${taxes}" var="tax">
                                        <option value="${tax.state}">${tax.state}</option>
                                    </c:forEach>
                                </select>
                                <errors path="state"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="product-type-input">Product Type:</label>
                            <div class="col-md-8">
                                <select class="form-control" id="product-type-input">
                                    <c:forEach items="${products}" var="product">
                                        <option value="${product.type}">${product.type}</option>
                                    </c:forEach>
                                </select>
                                <errors path="productType"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" path="area">Square Footage:</label>
                            <div class="col-md-8">
                                <input class="form-control" id="area-input"/>
                                <errors path="area"/>
                            </div>
                        </div>
                        <div id="add-contact-validation-errors"></div>
                        <div style="text-align: center">
                            <button id="create-submit" class="btn btn-primary" type="submit">Submit</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div id="showOrderModal" class="modal fade" role="dialog">
            <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Order Details</h4>
                </div>
                <div class="modal-body">
                    <table class="table table-bordered" id='show-order-table'>
                      
                        <tr>
                            <th>Customer Name:</th>
                            <td id="order-customer-name"></td>
                        </tr>
                        <tr>
                            <th>Date:</th>
                            <td id="order-date"></td>
                        </tr>
                        <tr>
                            <th>State:</th>
                            <td id="order-state"></td>
                        </tr>
                        <tr>
                            <th>Product Type:</th>
                            <td id="order-product-type"></td>
                        </tr>
                        <tr>
                            <th>Area:</th>
                            <td id="order-area"></td>
                        </tr>
                        <tr>
                            <th>Tax Rate:</th>
                            <td id="order-tax-rate"></td>
                        </tr>
                        <tr>
                            <th>Material Cost Per SF:</th>
                            <td id="order-material-cost-per-sf"></td>
                        </tr>
                        <tr>
                            <th>Labor Cost Per SF:</th>
                            <td id="order-labor-cost-per-sf"></td>
                        </tr>
      
                        <tr>
                            <th>Material Cost:</th>
                            <td id="order-material-cost"></td>
                        </tr>
                        <tr>
                            <th>Labor Cost:</th>
                            <td id="order-labor-cost"></td>
                        </tr>
                        <tr>
                            <th>Tax:</th>
                            <td id="order-tax"></td>
                        </tr>
                        <tr>
                            <th>Total:</th>
                            <td id="order-total"></td>
                        </tr>
                      
                      
                  </table>
                  
                  
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>

          </div>
        </div>
        <div id="editOrderModal" class="modal fade" role="dialog">
            <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Order Details</h4>
                </div>
                <div class="modal-body">
                  <table class="table table-bordered" id='edit-order-table'>
                        
                        <input type="hidden" id="edit-order-number">

                        <tr>
                            <th>Street Number:</th>
                            <td>
                                <input type='text' id="edit-order-customer-name"/>
                            </td>
                        </tr>
                        <tr>
                            <th>Order Date:</th>
                            <td>
                                <input type='date' id="edit-order-date"/>
                            </td>
                        </tr>
                        
                        <tr>
                            <th>State:</th>
                            <td>
                                <select type='text' id="edit-order-state">
                                    <c:forEach items="${taxes}" var="tax">
                                        <option value="${tax.state}">${tax.state}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th>Product Type:</th>
                            <td>
                                <select type='text' id="edit-order-product-type">
                                    <c:forEach items="${products}" var="product">
                                        <option value="${product.type}">${product.type}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th>Area:</th>
                            <td>
                                <input type='text' id="edit-order-area"/>
                            </td>
                        </tr>
                  </table>
                  
                  
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-danger" id="edit-order-button">Edit</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
              </div>
            </div>

          </div>
        </div>
        <script>
            var contextRoot = "/FlooringMastery";
        </script>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/app.js"></script>
            

    </body>
</html>

