/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sise.dao;

import com.mycompany.sise.entity.Empleado;

/**
 *
 * @author jennifer
 */
public interface IEmpleadoDAO {
    
    Empleado validarAcceso(String nombre, String clave) throws DAOException;
    
}
