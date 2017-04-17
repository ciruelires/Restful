/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.*;
import MODEL.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author alfon
 */
public class ControllerVote extends HttpServlet {
    private Connection connection;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session=request.getSession(true);
            Hero hero=(Hero)session.getAttribute("logged");
            ArrayList<Affiliation> teams=new ArrayList<>();
            teams=new Operations().getTeams(connection);  
            if(hero.isVoted()){
                session.setAttribute("msg", "You have already voted");
                response.sendRedirect("VIEW/ViewMessages.jsp");
            }
            else if(teams!=null){
                session.setAttribute("teams", teams);
                response.sendRedirect("VIEW/ViewVote.jsp");
            }
            else{
                session.setAttribute("msg", "My hero... there was a problem");
                response.sendRedirect("VIEW/ViewMessages.jsp");
            }
        }
        catch(Exception e){
            HttpSession session=request.getSession(true);
            session.setAttribute("msg", "My hero... there was a problem");
            response.sendRedirect("VIEW/ViewMessages.jsp");
        }
    }  

    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    public void init()throws ServletException{
        try{
            ConnectDB con= ConnectDB.getConnection();
            connection=con.getCon();
        }
        catch(ClassNotFoundException cnfe){

        }
        catch(SQLException sqle){
            
        }
    }
}
