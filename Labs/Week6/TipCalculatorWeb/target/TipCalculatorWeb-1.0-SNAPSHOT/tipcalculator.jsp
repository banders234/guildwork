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
        <title>Tip Calculator App</title>
    </head>
    <body>
        <div class="container">
            <h1 style="text-align: center">Tip Calculator</h1>
            <div style="text-align: center">
                <form action="TipCalculatorServlet" method="POST" class="form-horizontal" role="form">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="subtotal"> Enter subtotal:</label>
                        <div class="col-sm-10">
                            <input name="subtotal" type="number" class="form-control"/><br>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="tipPercent"> Enter percentage you want to tip:</label>
                        <div class="col-sm-10">
                            <input name="tipPercent" type="number" class="form-control"/><br>
                        </div>
                    </div>
                    <button name="submit" type="submit">Submit</button>
                </form>
            </div>
        </div>
    </body>
</html>
