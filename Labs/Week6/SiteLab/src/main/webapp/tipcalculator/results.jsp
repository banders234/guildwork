<%-- 
    Document   : results
    Created on : May 27, 2016, 11:38:57 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./css/sitelab.css"/>
        <title>Tip Calculator Results</title>
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
                    <li><a href="FactorizerServlet">Factorizer</a></li> 
                    <li><a href="InterestCalculatorServlet">Interest Calculator</a></li>
                    <li><a href="FlooringCalculatorServlet">Flooring Calculator</a></li>
                    <li  class="active"><a href="TipCalculatorServlet">Tip Calculator</a></li> 
                    <li><a href="UnitConverterServlet">Unit Converter</a></li> 
                </ul>
            </div> 
        </nav>
        <div class="container" style="text-align: center">
            <p>Amount: ${subTotal}</p>
            <p>Tip %: ${tipPer}</p>
            <p>Tip: ${tip}</p>
            <p>Total: ${total}</p>
        </div>
        <footer class="footer navbar-fixed-bottom">
            <p>Created by Brandon Anderson 2016</p>
            <p>Powered by Java and Bootstrap</p>
        </footer>
    </body>
</html>
