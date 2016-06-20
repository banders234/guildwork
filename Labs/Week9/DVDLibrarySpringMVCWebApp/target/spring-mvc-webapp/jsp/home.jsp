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
        <link href="${pageContext.request.contextPath}/css/dvdlibrary.css" rel="stylesheet">
        
        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
            <div class="container">
                <jsp:include page="navbar.jsp"/>
                <div style="text-align: center">
                    <button id="add-form-hider" data-toggle="collapse" class="btn btn-primary" data-target="#add-dvd-form">Add DVD<span class="glyphicon glyphicon-chevron-down"></span></button>
                </div>
                <div id="add-dvd-form" class="collapse">
                    <form method="POST" class="form-horizontal">
                        <div class="form-group">
                            <label class="col-md-2 control-label" for="releaseDate">Release Date:</label>
                            <div class="col-md-10">
                                <input class="form-control" type="date" id="release-date-input">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label" for="title">Title:</label>
                            <div class="col-md-10">
                                <input class="form-control" id="title-input"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label" for="director">Director:</label>
                            <div class="col-md-10">
                                <input class="form-control" id="director-input"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label" for="studio">Studio:</label>
                            <div class="col-md-10">
                                <input class="form-control" id="studio-input"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label" for="mpaa">MPAA Rating:</label>
                            <div class="col-md-10">
                                <select class="form-control" id="mpaa-input">
                                    <option value="">Select</option>
                                    <option value="G">G</option>
                                    <option value="PG">PG</option>
                                    <option value="PG-13">PG-13</option>
                                    <option value="R">R</option>
                                    <option value="NC-17">NC-17</option>
                                </select>
                                <errors path="mpaa"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label" for="userRating">User Rating:</label>
                            <div class="col-md-10">
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
                        <div class="form-group" id="notes-input-group">
                            <div id = "notes-1">
                                <label class="col-md-2 control-label" for="notes">Note 1:</label>
                                <div class="col-md-8">
                                    <input class="form-control" id="notes-input-1"/>
                                </div>
                                <div class="col-md-2" id="notes-buttons-1">
                                    <button type="button" class="btn btn-primary btn-circle" id="add-notes-input" aria-label="Left Align">
                                        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                                    </button>
                                </div>
                            </div>
                        </div>
                        <div style="text-align: center">
                            <button id="create-submit" class="btn btn-primary" type="submit">Submit</button>
                        </div>
                    </form>
                </div>
                <div class="col-md-12 col-lg-12 row" id="dvd-table-container">

                            <c:forEach items="${dvds}" var="dvd">
                                <div class="col-sm-12 col-md-4 col-lg-4 dvd-container" id='dvd-row-${dvd.id}'>
                                    <div class="poster-title col-md-12">
                                        <div class="col-md-12" style="white-space: nowrap; overflow-x: hidden">
                                            ${dvd.title}
                                        </div>
                                        <div class="col-md-12" style="text-align: center;">
                                            <a data-dvd-id='${dvd.id}' class="glyphicon glyphicon-pencil" href="#" data-toggle='modal' data-target='#editDvdModal'></a>
                                            <button class="btn btn-link delete-link glyphicon glyphicon-trash" data-dvd-id='${dvd.id}'></button>
                                        </div>
                                    </div>
                                    <div class="col-md-12 col-lg-12 poster-container">
                                        <a data-dvd-id='${dvd.id}' href="#" data-toggle='modal' data-target='#showDvdModal'><img class="img-responsive" src="${dvd.posterLink}" alt="No Poster Available" height="450px" width="300px"/></a>
                                    </div> 
                                    <div class="col-md-12" style="text-align: center; font-weight: bold; font-size: 125%">
                                        <fmt:formatDate value="${dvd.releaseDate}" pattern="yyyy"/>
                                    </div>
                                </div>
                            </c:forEach>
                    </table>
                </div>
                
            </div>
        <div id="showDvdModal" class="modal fade" role="dialog">
          <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 id="imdb-title"></h4>
                </div>
                <div class="modal-body">
                    <div id="dvd-poster">
                            
                    </div>
                    <table class="table table-bordered" id='show-dvd-table'>
                        <div id="show-dvd-id"></div>
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
                        
                      
                      
                  </table>
                  <div id="imdb-info-container">
                            <table class="table table-bordered modal-table" id='imdb-dvd-table'>
                                <tr>
                                    <th class="imdb-table-left">Rated: </th>
                                    <td id='imdb-mpaa'></td>
                                </tr>
                                <tr>
                                    <th class="imdb-table-left">Genre: </th>
                                    <td id='imdb-genre'></td>
                                </tr>
                                <tr>
                                    <th class="imdb-table-left">Date:</th>
                                    <td id='imdb-date'></td>
                                </tr>
                                <tr>
                                    <th class="imdb-table-left">Director</th>
                                    <td id='imdb-director'></td>
                                </tr>
                                <tr>
                                    <th class="imdb-table-left">Plot:</th>
                                    <td id='imdb-plot'></td>
                                </tr>
                                <tr>
                                    <th class="imdb-table-left">Actors: </th>
                                    <td id='imdb-actors'></td>
                                </tr>
                                <tr>
                                    <th class="imdb-table-left">Awards: </th>
                                    <td id='imdb-awards'></td>
                                </tr>                                
                                <tr>
                                    <th class="imdb-table-left">Metascore: </th>
                                    <td id='imdb-metascore'></td>
                                </tr>
                                <tr>
                                    <th class="imdb-table-left">IMDB Rating: </th>
                                    <td id='imdb-rating'></td>
                                </tr>
                                <tr>
                                    <th class="imdb-table-left">IMDB Votes: </th>
                                    <td id='imdb-votes'></td>
                                </tr>
                                <tr>
                                    <th class="imdb-table-left">Studio:</th>
                                    <td id="imdb-studio"></td>
                                </tr>
                                <tr>
                                    <th class="imdb-table-left">User Rating:</th>
                                    <td id="imdb-user-rating"></td>
                                </tr>
                            </table>
                  
                </div>
                <div class="modal-footer" style="text-align: center" id="imdb-footer">
                    <button id="relink-button"  class="btn btn-primary" value="" data-dvd-id='' data-toggle='modal' data-target='#linkDvdModal'>
                        <span class='link-option'>Link To IMDB</span>

                    </button>
                </div>
                  
            </div>

            </div>
          

        </div>
        </div>
        <div id="linkDvdModal" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        
                    </div>
                    <div class="modal-body">
                        <input hidden="true" id="link-dvd-id"/>
                        
                        <div id="link-table-container">
                            <table class="table table-bordered modal-table" id='link-dvd-table'>




                            </table>
                        </div>
                        
                        </div>
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
                  <table class="table table-bordered modal-table" id='edit-dvd-table'>
                        
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
                                    <option value="PG-13">PG-13</option>
                                    <option value="R">R</option>
                                    <option value="NC-17">NC-17</option>
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
                        <tbody id="edit-notes-group">
                            <tr>
                                <th>Note 1:</th>
                                <td id="edit-notes-cell-1">
                                    <div class="col-md-8">
                                        <input class="form-control" id="edit-notes-input-1"/>
                                    </div>
                                    <div id="edit-notes-buttons-1" class="col-md-4">
                                        <button type="button" class="btn btn-primary btn-circle" id="add-edit-notes-input" aria-label="Left Align">
                                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                  </table>
                  
                  
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" id="edit-dvd-button">Edit</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
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

