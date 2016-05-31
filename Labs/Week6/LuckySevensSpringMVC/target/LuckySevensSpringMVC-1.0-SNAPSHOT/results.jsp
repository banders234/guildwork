<%-- 
    Document   : results
    Created on : May 26, 2016, 10:10:23 PM
    Author     : apprentice
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RESULTS</title>
    </head>
    <body>
        <h1 style="text-align: center">RESULTS</h1>

        <div id="resultTable">


            <p>You took ${diceRollCounter} rolls before the money ran out. </p>
            <p>You had $${maxCash} after rolling ${maxMoneyCounter} times. </p>

        </div>
            
            <button onclick="location.href='sevenspage.jsp';">Play Again</button>

    </body>
</html>
