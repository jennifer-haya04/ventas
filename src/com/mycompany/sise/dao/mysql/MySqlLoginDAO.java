/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sise.dao.mysql;

import com.mycompany.sise.dao.IEmpleadoDAO;
import com.mycompany.sise.entity.Empleado;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jennifer
 */
public class MySqlLoginDAO  implements IEmpleadoDAO{
    
    private Connection cn;

    public MySqlLoginDAO(Connection cn) {
        this.cn = cn;
    }
    
    final String VALIDARACCESO = "{call pa_validar_acceso(?,?)}";
    
    public Empleado validarAcceso(String nombre, String clave){
        
        CallableStatement cs = null;
        ResultSet rs = null;
        Empleado objEmpleado =  null;
        
        try {
            cs = cn.prepareCall(VALIDARACCESO);
            int i = 1;
            cs.setString(i++, "%"+nombre+"%");
            cs.setString(i++, "%"+clave+"%");
            rs = cs.executeQuery();
            while(rs.next()){
                objEmpleado = new Empleado(
                        rs.getInt("id_empleado"),
                        rs.getString("nombre"),
                        rs.getString("clave")
                );
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }finally{
            if(cs!=null){
                try {
                    if(rs != null){
                        rs.close();
                    }
                    if(cs != null){
                        cs.close();
                    }
                } catch (SQLException ex) {
                    System.out.println("Error al cerrar conexión: "+ ex);
                }
            }
        }
        return objEmpleado;
    }
    
}
