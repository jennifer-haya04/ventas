/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sise.dao;

import com.mycompany.sise.entity.TipoDocVenta;
import java.util.List;

/**
 *
 * @author jennifer
 */
public interface ITipoDocVentaDAO extends IDAO<TipoDocVenta, Integer> {
    
    List<TipoDocVenta> busqueda(String valor) throws DAOException;
    List<String> obtenerNombresColumnas() throws DAOException;
    
}
