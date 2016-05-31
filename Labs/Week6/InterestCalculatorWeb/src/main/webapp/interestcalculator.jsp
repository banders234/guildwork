<%-- 
    Document   : interestcalculator
    Created on : May 27, 2016, 9:25:15 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Interest Calculator App</title>
    </head>
    <body>
        <div class="container">
            <h1 style="text-align: center">Interest Calculator</h1>
            <div style="text-align: center">
                <form action="InterestCalculatorServlet" method="POST" class="form-horizontal" role="form">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="term"> Enter term in years:</label>
                        <div class="col-sm-10">
                            <input name="term" type="number" class="form-control"/><br>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="interestRate"> Enter interest rate:</label>
                        <div class="col-sm-10">
                            <input name="interestRate" type="number" class="form-control"/><br>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="principal"> Enter initial principal:</label>
                        <div class="col-sm-10">
                            <input name="principal" type="number" class="form-control"/><br>
                        </div>
                    </div>
                        <button name="submit" type="submit">Submit</button>
                    
                </form>
            </div>
        </div>
    </body>
</html>
