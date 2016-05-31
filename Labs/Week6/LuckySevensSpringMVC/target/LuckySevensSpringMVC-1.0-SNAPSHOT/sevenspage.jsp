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

        <style>
            #resultTable {
                display: hidden;
            }

        </style>


        <title>Sevens Page</title>
    </head>
    <body>
        <div class="container">
            <h1 style="text-align: center">Lucky Sevens</h1>

            <p style="text-align: center">How much would you like to bet?</p>
            <form action="LuckyServlet" method="POST">

                <input name="bet" type="number" />
                <button name="submit" type="submit">Submit</button>

            </form>


           
        </div>
    </body>
</html>
