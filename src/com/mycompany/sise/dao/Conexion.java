/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sise.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * @author jennifer
 */
public class Conexion {
    
    ResourceBundle rb = ResourceBundle.getBundle("com.mycompany.sise.dao.cnx");
    
    //url, usuario, clave, driver de conexion
    
    private static String url = "";
    private static String usuario ="";
    private static String password = "";
    private static String driver = "com.mysql.cj.jdbc.Driver";
    
    Connection conn = null;
    
    static{
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error de conexión: " + ex);
        }
    }
    
    public Connection getCnx(){
       
        try {
            url = "jdbc:mysql://" + rb.getString("ip")+":"+ rb.getString("puerto") +"/"+rb.getString("base_datos");
            usuario = rb.getString("usuario");
            password = rb.getString("password");
            conn = DriverManager.getConnection(url, usuario, password);
        } catch (SQLException ex) {
            System.out.println("Error en DriverManager: " + ex); 
       }
        
        return conn;
    }
    
}
