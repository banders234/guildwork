<%-- 
    Document   : temperature
    Created on : May 27, 2016, 4:06:02 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Temperature Converter</title>
    </head>
    <body>
        <div class="container" style="text-align: center">
            <h1 style="text-align: center">Temperature Converter</h1>
            <form action="TemperatureServlet" method="POST" class="form-horizontal" role="form">
                <div class="form-group" id="temperature">
                    <label for="origUnit">Select unit to be converted from:</label>
                    <select class="form-control" name="origUnit">
                        <option>Fahrenheit</option>
                        <option>Celsius</option>
                    </select>
                </div>
                <div class="form-group" id="temperature">
                    <label for="newUnit">Select unit to be converted to:</label>
                    <select class="form-control" name="newUnit">
                        <option>Fahrenheit</option>
                        <option>Celsius</option>
                    </select>
                </div>
                <div class="form-group" id="amount" >
                    <label for="amount"> Enter amount:</label>
                    <div>
                        <input name="amount" type="number" class="form-control"/><br>
                    </div>
                </div>
                <button name="submit" type="submit">Submit</button>
            </form>
        </div>
    </body>
</html>
