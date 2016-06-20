<%-- 
    Document   : navbar
    Created on : Jun 5, 2016, 9:08:53 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="navbar navbar-inverse navbar-static-top" role="navigation">
	
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
		<span class="sr-only">Toggle navigation</span>
		<span class="icon-bar"></span>
		<span class="icon-bar"></span>
		<span class="icon-bar"></span>
		</button>
            <a class="navbar-brand" rel="home" href="${pageContext.request.contextPath}/" title="DVD Library - Homepage"><span class="navbar-item">DVD Library</span></a>
	</div>
	
	<div class="collapse navbar-collapse navbar-ex1-collapse">
		
		<ul class="nav navbar-nav">
                    <li><a class="navbar-item" href="${pageContext.request.contextPath}/dvd/stats"><span class="navbar-item">Stats</span></a></li>
                    <li><a class="navbar-item" href="${pageContext.request.contextPath}/dvd/table"><span class="navbar-item">DVD Data</span></a></li>
		</ul>
		
		<div class="col-sm-5 col-md-5 pull-right">
                    <form class="navbar-form" method="POST" action="${pageContext.request.contextPath}/dvd/search"role="search">
                    <div class="input-group">
                            <input type="text" class="form-control" placeholder="Search" name="srch-term" id="srch-term">
                            <div class="input-group-btn" style="width: 20%">
                                <select class="form-control" name="srch-type">
                                    <option value="All">All Movies (By Title)</option>
                                    <option value="director">Director</option>
                                    <option value="title">Title</option>
                                    <option value="age">Age (in years)</option>
                                    <option value="studio">Studio</option>
                                    <option value="mpaa">MPAA Rating</option>
                                </select>
                            </div>
                            <div class="input-group-btn">
                                    <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                            </div>
                    </div>
		</form>
		</div>
		
	</div>
</div>
