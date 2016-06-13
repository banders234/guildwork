<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">
        
        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
            <jsp:include page="header.jsp"/>
            <div class="container">
                <jsp:include page="navbar.jsp"/>
                <div class="col-md-6">
                    <a href="dvd/table" class="btn btn-link">Click to expand table and access search functions</a>
                    <table class="table" id="dvd-table">
                        <thead>
                            <th>Release Year</th>
                            <th>Title</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </thead>
                        <c:forEach items="${dvds}" var="dvd">
                            <tr id='dvd-row-${dvd.id}'>
                                <td><fmt:formatDate value="${dvd.releaseDate}" pattern="yyyy"/></td>
                                <td><a data-dvd-id='${dvd.id}' data-toggle='modal' data-target='#showDvdModal'>${dvd.title}</a></td>
                                <td><a data-dvd-id='${dvd.id}' data-toggle='modal' data-target='#editDvdModal'>Edit</a></td>
                                <td><a data-dvd-id='${dvd.id}' class='delete-link'>Delete</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div class="col-md-6">
                    <form method="POST" class="form-horizontal">
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="releaseDate">Release Date:</label>
                            <div class="col-md-8">
                                <input class="form-control" type="date" id="release-date-input">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="title">Title:</label>
                            <div class="col-md-8">
                                <input class="form-control" id="title-input"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="director">Director:</label>
                            <div class="col-md-8">
                                <input class="form-control" id="director-input"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="studio">Studio:</label>
                            <div class="col-md-8">
                                <input class="form-control" id="studio-input"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="mpaa">MPAA Rating:</label>
                            <div class="col-md-8">
                                <select class="form-control" id="mpaa-input">
                                    <option value="">Select</option>
                                    <option value="G">G</option>
                                    <option value="PG">PG</option>
                                    <option value="PG13">PG-13</option>
                                    <option value="R">R</option>
                                    <option value="NC17">NC-17</option>
                                </select>
                                <errors path="mpaa"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="userRating">User Rating:</label>
                            <div class="col-md-8">
                                <select class="form-control" id="user-rating-input">
                                    <option value="">Select</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                    <option value="10">10</option>
                                </select>
                            </div>
                            
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="notes">Notes (separated by commas):</label>
                            <div class="col-md-8">
                                <textarea id="notes-input"></textarea>
                            </div>
                        </div>
                        <button id="create-submit" type="submit">Submit</button>
                    </form>
                </div>
            </div>
        <div id="showDvdModal" class="modal fade" role="dialog">
          <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">DVD Details</h4>
                </div>
                <div class="modal-body">
                    <table class="table table-bordered" id='show-dvd-table'>
                      
                        <tr>
                            <th>Title:</th>
                            <td id="dvd-title"></td>
                        </tr>
                        <tr>
                            <th>Date:</th>
                            <td id="dvd-release-date"></td>
                        </tr>
                        <tr>
                            <th>Director:</th>
                            <td id="dvd-director"></td>
                        </tr>
                        <tr>
                            <th>Studio:</th>
                            <td id="dvd-studio"></td>
                        </tr>
                        <tr>
                            <th>MPAA Rating:</th>
                            <td id="dvd-mpaa"></td>
                        </tr>
                        <tr>
                            <th>User Rating:</th>
                            <td id="dvd-user-rating"></td>
                        </tr>
                        <tr>
                            <th>Notes:</th>
                            <td id="dvd-notes"></td>
                        </tr>
                        
                      
                      
                  </table>
                  
                  
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
                  
                  
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>

          </div>
          <div id="editDvdModal" class="modal fade" role="dialog">
            <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">DVD Details</h4>
                </div>
                <div class="modal-body">
                  <table class="table table-bordered" id='edit-dvd-table'>
                        
                        <input type="hidden" id="dvd-id">

                        <tr>
                            <th>Title:</th>
                            <td>
                                <input class="form-control" type='text' id="edit-dvd-title"/>
                            </td>
                        </tr>
                        <tr>
                            <th>Release Date:</th>
                            <td>
                                <input class="form-control" type='date' id="edit-dvd-release-date"/>
                            </td>
                        </tr>
                        
                        <tr>
                            <th>Director:</th>
                            <td>
                                <input class="form-control" type='text' id="edit-dvd-director"/>
                            </td>
                        </tr>
                        <tr>
                            <th>Studio:</th>
                            <td>
                                <input class="form-control" type='text' id="edit-dvd-studio"/>
                            </td>
                        </tr>
                        <tr>
                            <th>MPAA Rating:</th>
                            <td>
                                <select class="form-control" id="edit-dvd-mpaa">
                                    <option value="">Select</option>
                                    <option value="G">G</option>
                                    <option value="PG">PG</option>
                                    <option value="PG13">PG-13</option>
                                    <option value="R">R</option>
                                    <option value="NC17">NC-17</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th>User Rating:</th>
                            <td>
                                <select class="form-control" id="edit-dvd-user-rating">
                                    <option value="">Select</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                    <option value="10">10</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th>Notes:</th>
                            <td>
                                <input class="form-control" type='text' id="edit-dvd-notes"/>
                            </td>
                        </tr>
                  </table>
                  
                  
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-danger" id="edit-dvd-button">Edit</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
              </div>
            </div>

          </div>
          <script>
              contextRoot="/DVDLibrary";
              
          </script>
              
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/app.js"></script>
    </body>
</html>

