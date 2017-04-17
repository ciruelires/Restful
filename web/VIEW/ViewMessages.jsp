<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String msg = (String)session.getAttribute("msg");
    if(msg==null){
        msg="How is going on, my hero?";
    }
    session.removeAttribute("msg");
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
            <div id="container">
                <h3>SYSTEM MESSAGE</h3>
                <h3><%=msg%></h3>
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
