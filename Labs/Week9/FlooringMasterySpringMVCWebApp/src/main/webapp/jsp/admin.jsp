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
        <title>Admin Menu</title>
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
                    <table class="table table-bordered" id="product-table">
                        <thead>
                            <th>Product</th>
                            <th>Material Cost</th>
                            <th>Labor Cost</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </thead>
                        <tbody>
                        <c:forEach items="${products}" var="myProduct">
                            <tr id="tax-row-${myProduct.type}">
                                <td>${myProduct.type}</td>
                                <td>${myProduct.materialCostPerSF}</td>
                                <td>${myProduct.laborCostPerSF}</td>
                                <td><a data-product-type="${myProduct.type}" data-toggle='modal' data-target='#editProductModal'>Edit</a></td>
                                <td><a data-product-type="${myProduct.type}" class='delete-link'>Delete</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <table class="table table-bordered" id="tax-table">
                        <thead>
                            <th>State</th>
                            <th>Tax Rate</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </thead>
                        <tbody>
                        <c:forEach items="${taxes}" var="myTax">
                                <tr id="tax-row-${myTax.state}">
                                    <td>${myTax.state}</td>
                                    <td>${myTax.taxRate}</td>
                                    <td><a data-tax-state="${myTax.state}" data-toggle='modal' data-target='#editTaxModal'>Edit</a></td>
                                    <td><a data-tax-state="${myTax.state}" class='delete-link'>Delete</a></td>
                                </tr>                            
                        </c:forEach>
                       </tbody>
                    </table>
                </div>
                <div style="text-align: center">
                    <h2>Add Product</h2>
                </div>
                <div class="col-md-6">
                    <form method="POST"  class="form-horizontal">
                        <div class="form-group">
                            <label class="col-md-4 control-label" path="type">Type:</label>
                            <div class="col-md-8">
                                <input class="form-control" id="type-input"/>
                                <errors path="type"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" path="materialCostPerSF">Material Cost Per Square Foot:</label>
                            <div class="col-md-8">
                                <input class="form-control" id="material-cost-input"/>
                                <errors path="materialCostPerSF"/>
                            </div>
                        </div>
 
                        <div class="form-group">
                            <label class="col-md-4 control-label" path="laborCostPerSF">Labor Cost Per Square Foot:</label>
                            <div class="col-md-8">
                                <input class="form-control" id="labor-cost-input"/>
                                <errors path="laborCostPerSF"/>
                            </div>
                        </div>
                        <div style="text-align: center">
                            <button class="btn btn-primary" id="product-create-submit" type="submit">Submit</button> <br>
                        </div>
                        <div id="add-product-validation-errors">
                            
                        </div>
                    </form>
                    <div style="text-align: center">
                        <h2>Add State Tax Rate</h2>
                    </div>
                    <form method="POST"  class="form-horizontal">
                        <div class="form-group">
                            <label class="col-md-4 control-label">State:</label>
                            <div class="col-md-8">
                                <select class="form-control" id="state-input">
                                    <option value="AL">Alabama</option>
                                    <option value="AK">Alaska</option>
                                    <option value="AZ">Arizona</option>
                                    <option value="AR">Arkansas</option>
                                    <option value="CA">California</option>
                                    <option value="CO">Colorado</option>
                                    <option value="CT">Connecticut</option>
                                    <option value="DE">Delaware</option>
                                    <option value="FL">Florida</option>
                                    <option value="GA">Georgia</option>
                                    <option value="HI">Hawaii</option>
                                    <option value="ID">Idaho</option>
                                    <option value="IL">Illinois</option>
                                    <option value="IN">Indiana</option>
                                    <option value="IA">Iowa</option>
                                    <option value="KS">Kansas</option>
                                    <option value="KY">Kentucky</option>
                                    <option value="LA">Louisiana</option>
                                    <option value="ME">Maine</option>
                                    <option value="MD">Maryland</option>
                                    <option value="MA">Massachusetts</option>
                                    <option value="MI">Michigan</option>
                                    <option value="MN">Minnesota</option>
                                    <option value="MT">Montana</option>
                                    <option value="NE">Nebraska</option>
                                    <option value="NV">Nevada</option>
                                    <option value="NH">New Hampshire</option>
                                    <option value="NJ">New Jersey</option>
                                    <option value="NM">New Mexico</option>
                                    <option value="NY">New York</option>
                                    <option value="NC">North Carolina</option>
                                    <option value="ND">North Dakota</option>
                                    <option value="OH">Ohio</option>
                                    <option value="OK">Oklahoma</option>
                                    <option value="OR">Oregon</option>
                                    <option value="PA">Pennsylvania</option>
                                    <option value="RI">Rhode Island</option>
                                    <option value="SC">South Carolina</option>
                                    <option value="SD">South Dakota</option>
                                    <option value="TN">Tennessee</option>
                                    <option value="TX">Texas</option>
                                    <option value="UT">Utah</option>
                                    <option value="VT">Vermont</option>
                                    <option value="VA">Virginia</option>
                                    <option value="WA">Washington</option>
                                    <option value="WV">West Virginia</option>
                                    <option value="WI">Wisconsin</option>
                                    <option value="WY">Wyoming</option>
                                </select>
                                <errors path="state"/>
                                <div>
                                    ${taxMessage}
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label">Tax Rate:</label>
                            <div class="col-md-8">
                                <input class="form-control" id="tax-rate-input"/>
                                <errors path="taxRate"/>
                            </div>
                        </div>
                        <div style="text-align: center"> 
                            <button class="btn btn-primary" id="tax-create-submit" type="submit">Submit</button>
                        </div>
                        <div id="add-tax-validation-errors">
                            
                        </div>
                    </form>
                </div>
            </div>
            <div id="editProductModal" class="modal fade" role="dialog">
            <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Product Details</h4>
                </div>
                <div class="modal-body">
                  <table class="table table-bordered" id='edit-order-table'>
                        
                        <input type="hidden" id="edit-order-number">

                        <tr class="form-group">
                            <th>Type:</th>
                            <td>
                                <input class="form-control" type='text' id="edit-product-type" readonly="readonly"/>
                            </td>
                        </tr>
                        <tr class="form-group">
                            <th>Material Cost / Square Foot:</th>
                            <td>
                                <input class="form-control" type='text' id="edit-product-material-cost"/>
                            </td>
                        </tr>
                        <tr class="form-group">
                            <th>Material Cost / Square Foot:</th>
                            <td>
                                <input class="form-control" type='text' id="edit-product-labor-cost"/>
                            </td>
                        </tr>
                  </table>
                  
                  
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-danger" id="edit-product-button">Edit</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
              </div>
            </div>
            </div>
            </div>
            <div id="editTaxModal" class="modal fade" role="dialog">
            <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Tax Details</h4>
                </div>
                <div class="modal-body">
                  <table class="table table-bordered" id='edit-order-table'>
                        
                        <tr>
                            <th>State:</th>
                            <td>
                                <input class="form-control" readonly="readonly" type='text' id="edit-tax-state"/>
                            </td>
                        </tr>
                        <tr>
                            <th>Tax Rate:</th>
                            <td>
                                <input class="form-control" type='text' id="edit-tax-rate"/>
                            </td>
                        </tr>
                        
                  </table>
                  
                  
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-danger" id="edit-tax-button">Edit</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
              </div>
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
        <script src="${pageContext.request.contextPath}/js/taxapp.js"></script>
        <script src="${pageContext.request.contextPath}/js/productapp.js"></script>
    </body>
</html>
