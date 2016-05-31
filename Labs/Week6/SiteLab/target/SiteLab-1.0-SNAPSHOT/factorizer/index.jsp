<%-- 
    Document   : index
    Created on : May 26, 2016, 10:45:28 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="./css/sitelab.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Factorizer</title>
    </head>
    <body>
        <div class="page-header" style="text-align: center">
            <p>Software Craftsmanship Guild Java Cohort</p>
            <p>JSP Site Lab</p>
        </div>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <ul class="nav navbar-nav">
                    <li><a href="HomeServlet">Home</a></li>
                    <li><a href="LuckySevensServlet">Lucky Sevens</a></li>
                    <li class="active"><a href="FactorizerServlet">Factorizer</a></li> 
                    <li><a href="InterestCalculatorServlet">Interest Calculator</a></li>
                    <li><a href="FlooringCalculatorServlet">Flooring Calculator</a></li>
                    <li><a href="TipCalculatorServlet">Tip Calculator</a></li> 
                    <li><a href="UnitConverterServlet">Unit Converter</a></li> 
                </ul>
            </div> 
        </nav>
        <h1 style="text-align: center">Welcome to Factorizer!</h1>
            <br/>
        <div style="text-align: center">
            <form action="FactorizerServlet" method="GET">
                <button class="btn btn-primary">Play</button>
            </form>
        </div>
        <footer class="footer navbar-fixed-bottom">
            <p>Created by Brandon Anderson 2016</p>
            <p>Powered by Java and Bootstrap</p>
        </footer>
    </body>
</html>
