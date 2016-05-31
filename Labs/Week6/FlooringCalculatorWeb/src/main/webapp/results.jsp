<%-- 
    Document   : results
    Created on : May 27, 2016, 10:52:18 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flooring Calculator Results</title>
    </head>
    <body
        <div class="container" style="text-align: center">
            <p>Area of floor: ${area} square feet</p>
            <p>Flooring cost per square foot: ${costPerUnit}</p>
            <p>Total cost of flooring: ${totalFlooringCost}</p>
            <p>Billed hours for labor: ${billedTime}</p>
            <p>Total labor cost: ${totalLaborCost}</p>
        </div>
    </body>
</html>
