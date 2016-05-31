<%-- 
    Document   : tipcalculator
    Created on : May 27, 2016, 11:38:48 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./css/sitelab.css"/>
        <title>Unit Converter App</title>
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
                    <li><a href="TipCalculatorServlet">Tip Calculator</a></li> 
                    <li class="active"><a href="UnitConverterServlet">Unit Converter</a></li> 
                </ul>
            </div> 
        </nav>
        <div class="container">
            <h1 style="text-align: center">Unit Converter</h1>
            <div style="text-align: center">
                <form action="UnitConverterServlet" method="POST" class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="unitType">Select unit:</label>
                            <select class="form-control" name="unitType" id="unitType" onchange="typeSelectCheck(this);">
                                <option value="Temperature">Temperature</option>
                                <option value="Currency">Currency</option>
                                <option value="Volume">Volume</option>
                                <option value="Mass">Mass</option>
                            </select>
                    </div>
                    <button name="submit" type="submit">Submit</button>
                </form>
                
            </div>
        </div>
        <footer class="footer navbar-fixed-bottom">
            <p>Created by Brandon Anderson 2016</p>
            <p>Powered by Java and Bootstrap</p>
        </footer>
    </body>
</html>
