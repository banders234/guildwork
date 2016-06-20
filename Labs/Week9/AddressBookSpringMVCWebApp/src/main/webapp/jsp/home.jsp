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
                <table class="table table-bordered" id="address-table">
                    <thead>
                        <th>First</th>
                        <th>Last</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </thead>
                    <c:forEach items="${addresses}" var="address">
                        <tr id="address-row-${address.id}">
                            <td><a data-address-id="${address.id}" data-toggle="modal" data-target="#showAddressModal">${address.firstName}</a></td>
                            <td>${address.lastName}</td>
                            <td><a data-address-id="${address.id}" data-toggle="modal" data-target="#editAddressModal">Edit</a></td>
                            <td><a data-address-id="${address.id}" class='delete-link'>Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="col-md-6">
                <form class="form-horizontal" method="POST">
                    <div class="form-group">
                        <label class="col-md-4" for="firstName">First Name:</label> 
                        <div class="col-md-8">
                            <input class="form-control" id="first-name-input"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4" for="lastName">Last Name:</label>
                        <div class="col-md-8">
                            <input class="form-control" id="last-name-input"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4" for="streetNumber">Street Number:</label> 
                        <div class="col-md-8">
                            <input class="form-control" id="street-number-input"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4" for="streetName">Street Name:</label> 
                        <div class="col-md-8">
                            <input class="form-control" id="street-name-input"/>
                            <errors path="streetName"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4" for="city">City:</label> 
                        <div class="col-md-8">
                            <input class="form-control" id="city-input"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4" for="state">State:</label>
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
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4" for="zip-input">Zip Code:</label> 
                        <div class="col-md-8">
                            <input class="form-control" id="zip-input"/>
                        </div>
                    </div>
                    <div style="text-align: center">
                        <button class="btn btn-primary" id="create-submit" type="submit">Submit</button>
                    </div>
                </form>
            </div>
        </div>
                    <div id="showAddressModal" class="modal fade" role="dialog">
          <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Address Details</h4>
              </div>
              <div class="modal-body">
                  <table class="table table-bordered" id='show-address-table'>
                      
                        <tr>
                            <th>First Name:</th>
                            <td id="address-first-name"></td>
                        </tr>
                        <tr>
                            <th>Last Name:</th>
                            <td id="address-last-name"></td>
                        </tr>
                        <tr>
                            <th>Street Number:</th>
                            <td id="address-street-number"></td>
                        </tr>
                        <tr>
                            <th>Last Name:</th>
                            <td id="address-street-name"></td>
                        </tr>
                        <tr>
                            <th>City:</th>
                            <td id="address-city"></td>
                        </tr>
                        <tr>
                            <th>State:</th>
                            <td id="address-state"></td>
                        </tr>
                        <tr>
                            <th>Zip:</th>
                            <td id="address-zip"></td>
                        </tr>
                      
                  </table>
                  
                  
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
              </div>
            </div>

          </div>
        </div>
        <div id="editAddressModal" class="modal fade" role="dialog">
            <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Address Details</h4>
              </div>
              <div class="modal-body">
                  <table class="table table-bordered" id='edit-address-table'>
                        
                      <input type="hidden" id="edit-id">
                        <tr>
                            <th>First Name:</th>
                            <td>
                                <input type='text' id="edit-address-first-name"/>
                            </td>
                        </tr>
                        <tr>
                            <th>Last Name:</th>
                            <td>
                                <input type='text' id="edit-address-last-name"/>
                            </td>
                        </tr>
                        <tr>
                            <th>Street Number:</th>
                            <td>
                                <input type='text' id="edit-address-street-number"/>
                            </td>
                        </tr>
                        <tr>
                            <th>Street Name:</th>
                            <td>
                                <input type='text' id="edit-address-street-name"/>
                            </td>
                        </tr>
                        <tr>
                            <th>City:</th>
                            <td>
                                <input type='text' id="edit-address-city"/>
                            </td>
                        </tr>
                        <tr>
                            <th>State:</th>
                            <td>
                                <input type='text' id="edit-address-state"/>
                            </td>
                        </tr>
                      <tr>
                            <th>Zip:</th>
                            <td>
                                <input type='text' id="edit-address-zip"/>
                            </td>
                      </tr>
                      
                  </table>
                  
                  
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-danger" id="edit-address-button">Edit</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
              </div>
            </div>

          </div>
        </div>
        <script>
            var contextRoot = "/AddressBook";
        </script>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/app.js"></script>
    </body>
</html>

