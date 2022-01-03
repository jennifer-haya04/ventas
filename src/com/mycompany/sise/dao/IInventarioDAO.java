/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sise.dao;

import com.mycompany.sise.entity.Inventario;
import com.mycompany.sise.util.Helper;
import java.util.List;

/**
 *
 * @author jennifer
 */
public interface IInventarioDAO extends IDAO<Inventario, Integer> {
    
    List<Inventario> busqueda(String valor) throws DAOException;
    List<String> obtenerNombresColumnas() throws DAOException;
    Helper insertarValidado(Inventario o);
    
}
