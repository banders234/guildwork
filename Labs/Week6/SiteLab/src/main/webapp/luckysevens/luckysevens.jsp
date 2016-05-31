<%-- 
    Document   : sevens.jsp
    Created on : May 26, 2016, 10:11:07 PM
    Author     : apprentice
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./css/sitelab.css"/>
        <title>Sevens Page</title>
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
                    <li class="active"><a href="LuckySevensServlet">Lucky Sevens</a></li>
                    <li><a href="FactorizerServlet">Factorizer</a></li> 
                    <li><a href="InterestCalculatorServlet">Interest Calculator</a></li>
                    <li><a href="FlooringCalculatorServlet">Flooring Calculator</a></li>
                    <li><a href="TipCalculatorServlet">Tip Calculator</a></li> 
                    <li><a href="UnitConverterServlet">Unit Converter</a></li> 
                </ul>
            </div> 
        </nav>
        <div class="container" style="margin: auto; text-align: center">
            <h1>Lucky Sevens</h1>

            <form action="LuckyServlet" method="POST">
                <label for="bet">Enter your bet:</label>
                <input name="bet" type="number" />
                <button name="submit" type="submit">Submit</button>

            </form>


           
        </div>
        <div class="footer navbar-fixed-bottom">
            <p>Created by Brandon Anderson 2016</p>
            <p>Powered by Java and Bootstrap</p>
        </div>
    </body>
</html>
