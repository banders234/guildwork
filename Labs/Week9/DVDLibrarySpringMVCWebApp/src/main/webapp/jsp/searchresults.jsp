<%-- 
    Document   : searchresults
    Created on : Jun 18, 2016, 1:48:35 PM
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
        <title>Search Results</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/dvdlibrary.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body> 
        <div class="container">
            <jsp:include page="navbar.jsp"/>
            <div>
                ${emptyMessage}
            </div>
            <div class="search-results-container">
                <c:forEach items="${dvds}" var="dvd">
                    <div class="col-md-12 poster-search-container">
                        <div class="col-md-3">
                            <c:if test="${dvd.posterLink != 'N/A'}">
                                <img class="poster-search" src="${dvd.posterLink}" alt="${dvd.title}"/>
                            </c:if>
                            <c:if test="${dvd.posterLink == 'N/A'}">
                                <img class="poster-search" src="/DVDLibrary/img/noposter.jpg" alt="${dvd.title}"/>
                            </c:if>
                        </div>
                        <div class="col-md-9"  class="search-title-container">
                            <h2>${dvd.title}</h2>
                            <h4>${dvd.year}</h4>
                            <div id="imdb-link-search-${dvd.imdbId}">
                                <button class='btn btn-success imdb-link-search-button' value="${dvd.imdbId}">Add To Collection</button>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
    <script>
        contextRoot="/DVDLibrary";         
    </script>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/app.js"></script>
</html>