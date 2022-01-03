/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sise.dao;

import com.mycompany.sise.entity.Producto;
import java.util.List;

/**
 *
 * @author jennifer
 */
public interface IProductoDAO extends IDAO<Producto, Integer>{
    
    List<Producto> busqueda(String valor) throws DAOException;
    List<String> obtenerNombresColumnas() throws DAOException;
    
}
