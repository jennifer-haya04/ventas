/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sise.dao;

import com.mycompany.sise.entity.CategoriaProducto;
import java.util.List;

/**
 *
 * @author jennifer
 */
public interface ICategoriaProductoDAO extends IDAO<CategoriaProducto, Integer>{
    
    List<CategoriaProducto> busqueda(String valor) throws DAOException;
    List<String> obtenerNombresColumnas() throws DAOException;
    Integer validador(String nombre) throws DAOException;
}
