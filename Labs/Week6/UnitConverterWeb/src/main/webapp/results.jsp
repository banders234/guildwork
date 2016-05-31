<%-- 
    Document   : results
    Created on : May 27, 2016, 11:38:57 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Unit Converter Results</title>
    </head>
    <body>
        <div class="container" style="text-align: center; font-size: 150%">
            <p> ${unitType} Conversion</p>
            <br>
            <p>${amount} ${origUnit} is ${conversionAmount} ${newUnit}</p>
        </div>
    </body>
</html>
