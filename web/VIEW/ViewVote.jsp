<%@page import="java.util.ArrayList"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="MODEL.Affiliation"%>
<%@page import="MODEL.Hero"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if(session.getAttribute("logged")==null){
        response.sendRedirect("../index.jsp");
    }
%>
<%
    Hero hero=(Hero)session.getAttribute("logged");
    ArrayList<Affiliation> teams=new ArrayList<Affiliation>();
    teams=(ArrayList<Affiliation>)session.getAttribute("teams");  
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
            <h2>WHAT AFFILIATION DO YOU BELONG TO</h2>
            <div id="container_thick">
                <h3>Please Mr/Mrs <%=hero.getAlias()%>, choose your team</h3>
                <form action="../ControllerVotedTeam" method="post">
                    <%
                    for(int i=0;i<teams.size();i++){
                        %>
                        <div class="affiliation">
                            <img src="../<%=teams.get(i).getLogoSrc()%>">
                            <h3><%=teams.get(i).getName()%></h3>
                            <div class="vote"><label>Join!</label><input type="radio" name="voted" value="<%=teams.get(i).getId()%>"></div>
                        </div>
                        <%
                    }
                    %>
                    <button class="button">JOIN!</button>
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
