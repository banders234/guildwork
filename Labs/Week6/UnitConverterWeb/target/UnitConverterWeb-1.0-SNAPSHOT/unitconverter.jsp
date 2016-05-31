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
        <script src="unitconverter.js"></script>
        <title>Unit Converter App</title>
    </head>
    <body>
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
    </body>
</html>
