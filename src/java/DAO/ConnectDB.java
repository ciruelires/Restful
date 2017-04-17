/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;

/**
 *
 * @author alfon
 */
public class ConnectDB {
    static Connection connection;
    private static ConnectDB instance=null;
    
    private ConnectDB() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        //String db="BDEncuesta_AVV";
        String url="localhost/BDEncuesta_AVV";
        connection=DriverManager.getConnection(url,"root","root");
        //String url="jdbc:mysql://mysql55018-alfonvv.fi.cloudplatform.fi/BDEncuesta_AVV";
        //connection=DriverManager.getConnection(url,"root","AYQykr49025");
    }
    public synchronized static ConnectDB getConnection() throws  ClassNotFoundException, SQLException{
        if(instance == null){
            instance=new ConnectDB();
        }
        return instance;
    }
    public Connection getCon(){
        return connection;
    }
}
