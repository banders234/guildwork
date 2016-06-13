<%-- 
    Document   : navBar
    Created on : Jun 4, 2016, 8:58:45 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="navbar navbar-default">
    <ul class="nav navbar-nav">
        <li ${pageTitle == 'home' ?  "class='active'" : ''}><a  href="${pageContext.request.contextPath}">Home</a></li>
        <li ${pageTitle == 'admin' ? "class='active'" : ''}><a  href="${pageContext.request.contextPath}/admin/menu">Admin Menu</a></li>
    </ul>    
</div>
