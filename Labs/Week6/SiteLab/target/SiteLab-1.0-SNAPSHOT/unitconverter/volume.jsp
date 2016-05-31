<%-- 
    Document   : volume
    Created on : May 27, 2016, 4:06:28 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="./css/sitelab.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Volume Converter</title>
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
        <div class="container" style="text-align: center">
            <h1 style="text-align: center">Volume Converter</h1>
            <form action="VolumeServlet" method="POST" class="form-horizontal" role="form">
                <div class="form-group" id="volume">
                    <label for="volume">Select unit to be converted from:</label>
                    <select class="form-control" name="origUnit">
                        <option>Gallons</option>
                        <option>Liters</option>
                    </select>
                </div>
                <div class="form-group" id="volume">
                    <label for="volume">Select unit to be converted to:</label>
                    <select class="form-control" name="newUnit">
                        <option>Gallons</option>
                        <option>Liters</option>
                    </select>
                </div>
                <div class="form-group" id="amount">
                    <label for="amount"> Enter amount:</label>
                    <div>
                        <input name="amount" type="number" class="form-control"/><br>
                    </div>
                </div>
                <button name="submit" type="submit">Submit</button>
            </form>
            
        <div class="footer navbar-fixed-bottom">
            <p>Created by Brandon Anderson 2016</p>
            <p>Powered by Java and Bootstrap</p>
        </div>
    </body>
</html>
