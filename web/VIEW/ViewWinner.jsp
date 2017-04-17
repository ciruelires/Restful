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
    Affiliation winner=(Affiliation)session.getAttribute("winner");
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
            <h2>WE ALREADY HAVE A SAVIOR!</h2>
            <div id="container_thick">
                <h3>Seems like the <%=winner.getName()%> are the most joined.</h3>
                <img class="winner" src="../<%=winner.getLogoSrc()%>">
                <h3>Long life to the <%=winner.getName()%>.<br>
                We all trust you.</h3>
                <h3>Total of heroes joined.</h3>
                <table class="recruited">
                    <tr>
                        <td class="green">LOGO</td>
                        <td class="green">NAME</td>
                        <td class="green">HEROES JOINED</td>
                    </tr>
                    <%
                    for(int i=0;i<teams.size();i++){
                        %>
                        <tr class="voted_teams">
                            <td><img src="../<%=teams.get(i).getLogoSrc()%>"></td>
                            <td><%=teams.get(i).getName()%></td>
                            <td><%=teams.get(i).getVotes()%></td>
                        </td>
                        <%
                    }
                    %>
                </table>
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
