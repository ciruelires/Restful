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
    ArrayList<Hero> heroes=new ArrayList<Hero>();
    heroes=(ArrayList<Hero>)session.getAttribute("heroes");  
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
            <h2>THOSE ARE OUR REGISTERED HEROES</h2>
            <div id="container_thick">
                <h3>Have you already been recruited?</h3>
                <table class="recruited">
                    <tr>
                        <td class="green">NAME</td>
                        <td class="green">SURNAME</td>
                        <td class="green">ALIAS</td>
                        <td class="green">POWERS</td>
                        <td class="green">RECRUITED?</td>
                    </tr>
                    <%
                    for(int i=0;i<heroes.size();i++){
                        %>
                        <tr>
                            <td><%=heroes.get(i).getName()%></td>
                            <td><%=heroes.get(i).getSurname()%></td>
                            <td><%=heroes.get(i).getAlias()%></td>
                            <td><%=heroes.get(i).getPowers()%></td>
                            <td><%=heroes.get(i).isVoted()%></td>
                        </tr>
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
