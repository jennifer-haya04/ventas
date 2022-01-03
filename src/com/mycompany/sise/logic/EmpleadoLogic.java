/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sise.logic;

import com.mycompany.sise.dao.IEmpleadoDAO;
import com.mycompany.sise.dao.mysql.MySqlDAOManager;
import com.mycompany.sise.entity.Empleado;

/**
 *
 * @author jennifer
 */
public class EmpleadoLogic {
    
    MySqlDAOManager factory = MySqlDAOManager.getInstancia();
    IEmpleadoDAO dao = factory.getEmpleado();
    
    public Empleado validarAcceso(String nombre, String clave) throws Exception{
        
        return dao.validarAcceso(nombre, clave);
    }
    
}
