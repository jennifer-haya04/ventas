/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sise.dao;

import com.mycompany.sise.entity.DetalleVenta;
import java.util.List;

/**
 *
 * @author jennifer
 */
public interface IDetalleVentaDAO extends IDAO<DetalleVenta, Integer>{
    
    List<DetalleVenta> busqueda(String valor) throws DAOException;
    List<String> obtenerNombresColumnas() throws DAOException;
    int[] cargarProductosBD(List<DetalleVenta> lista) throws DAOException;
}
