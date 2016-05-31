<%-- 
    Document   : factorizer
    Created on : May 26, 2016, 10:52:46 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Factorizer App</title>
    </head>
    <body>
        <div class="container">
            <h1 style="text-align: center">Factorizer</h1>
            <div style="text-align: center">
                    <form action="FactorizerServlet" method="POST">
                        <label for="factorize"> Enter number to factorize:</label>
                        <input name="num" type="number" />
                        <button name="submit" type="submit">Submit</button>

                    </form>
            </div>

           
        </div>
    </body>
</html>
