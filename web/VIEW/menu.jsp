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
            <h2>MAIN MENU</h2>
            <div id="container">
                
                <h3>What do you want to do?</h3>
                <form action="../Dispatcher" method="post">
                    <input type="submit" class="button" name="submit" value="VOTE!">
                    <input type="submit" class="button" name="submit" value="RECRUITED HEROES">
                    <input type="submit" class="button" name="submit" value="DELETE USER">
                    <input type="submit" class="button" name="submit" value="CHOSEN SAVIOR">
                    <input type="submit" class="button logout" name="submit" value="LOG OUT">  
                </form>
            </div>
        </div>
    </body>
</html>
