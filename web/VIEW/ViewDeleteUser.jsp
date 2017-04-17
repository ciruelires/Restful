<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if(session.getAttribute("logged")==null){
        response.sendRedirect("../index.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../css/style.css">
        <link href="https://fonts.googleapis.com/css?family=Chewy" rel="stylesheet">
    </head>
    <body>
        <div id="web">
            <h1>SUPER-HUMAN REGISTRATION ACT</h1>
            <h2>FILL IN TO DELETE AN USER</h2>
            <div id="container">
                <h3>Who will be deleted?</h3>
                <form action="../ControllerDeleteUser" method="post">
                    <input type="text" required="required" placeholder="Alias" name="alias"><br>
                    <input type="password" required="required" placeholder="Password" name="password"><br>
                    <button class="button">DELETE</button>
                </form>
            </div>
            <a href="../index.jsp">
                <div id="arrow">
                    <img src="../img/arrow.png">
                    <h3> Back to main menu</h3>               
                </div>
            </a>
        </div>
    </body>
</html>
