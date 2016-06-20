<%-- 
    Document   : stats
    Created on : Jun 5, 2016, 8:32:46 PM
    Author     : apprentice
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stats</title>
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
                <div class="col-md-3">
                    <div class="panel panel-default">
                        <div class="panel-heading">Number of DVDS</div>
                        <div class="panel-body">${count}</div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="panel panel-default">
                        <div class="panel-heading">Oldest DVD in Library</div>
                        <div class="panel-body">${oldest.title}</div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="panel panel-default">
                        <div class="panel-heading">Newest DVD in Library</div>
                        <div class="panel-body">${newest.title}</div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="panel panel-default">
                        <div class="panel-heading">Average Age of DVD's</div>
                        <div class="panel-body"><fmt:formatNumber maxFractionDigits="2" value="${averageAge}"/> years</div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="panel panel-default">
                        <div class="panel-heading">Average Number of Notes</div>
                        <div class="panel-body"><fmt:formatNumber value="${averageNotes}" maxFractionDigits="3"/></div>
                    </div>
                </div>
                    <c:forEach var="entry" items="${genreCount}">
                    <div class="col-md-3">
                        <div class="panel panel-default">
                            <div class="panel-heading"><c:out value="${entry.key}"/> Films in Database:</div>
                            <div class="panel-body"><c:out value="${entry.value}"/></div>
                        </div>
                    </div>
                    </c:forEach>
            </div>
        </div>
    </body>
</html>
