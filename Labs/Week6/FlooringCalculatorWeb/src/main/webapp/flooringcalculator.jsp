<%-- 
    Document   : flooringcalculator
    Created on : May 27, 2016, 10:52:07 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flooring Calculator App</title>
    </head>
    <body>
        <div class="container">
            <h1 style="text-align: center">Flooring Calculator</h1>
            <div style="text-align: center">
                <form action="FlooringCalculatorServlet" method="POST" class="form-horizontal" role="form">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="width"> Enter width in feet:</label>
                        <div class="col-sm-10">
                            <input name="width" type="number" class="form-control"/><br>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="length"> Enter length in feet:</label>
                        <div class="col-sm-10">
                            <input name="length" type="number" class="form-control"/><br>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="costPerUnit"> Enter cost per square foot of flooring:</label>
                        <div class="col-sm-10">
                            <input name="costPerUnit" type="number" class="form-control"/><br>
                        </div>
                    </div>
                    <button name="submit" type="submit">Submit</button>
                    
                </form>
            </div>
        </div>
    </body>
</html>
