<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if(session.getAttribute("logged")!=null){
        response.sendRedirect("VIEW/menu.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link href="https://fonts.googleapis.com/css?family=Chewy" rel="stylesheet">
    </head>
    <body>
        <div id="web">
            <h1>SUPER-HUMAN REGISTRATION ACT</h1>
            <h2>WHAT AFFILIATION DO YOU BELONG TO?</h2>
            <div id="container_thick">
                <h4>Since the D-Day, humanity has been devastated by the space invaders.
                <br>Governments all over the world joined strenght and resources acting like 
                a single unit.<br>After seeking a solution for months, we finally 
                got an idea. Now we have the solution.<br>Every single 
                super-human is being joined in 9 differents affiliations.
                <br>Most joined team will be encharged of bringing us peace.<br>
                NOW CHOOSE YOUR SIDE!</h4>
                <h3>You must be logged before start</h3>
                <a href="VIEW/ViewLogin.jsp">
                    <div class="button">LOGIN</div>
                </a>
                <a href="VIEW/ViewRegister.jsp">
                    <div class="button">REGISTER</div>
                </a>
            </div>
        </div>
    </body>
</html>
