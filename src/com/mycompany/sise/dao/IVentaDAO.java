/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sise.dao;

import com.mycompany.sise.entity.DetalleVenta;
import com.mycompany.sise.entity.Venta;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author jennifer
 */
public interface IVentaDAO extends IDAO<Venta, Integer>{
    
    List<Venta> busqueda(String valor) throws DAOException;
    List<String> obtenerNombresColumnas() throws DAOException;
    List<DetalleVenta> obtenerDetalle(Integer id_Venta) throws DAOException;
    Integer insertarReturnId(Venta o) throws DAOException;
    Double obtenerDescuentoxProducto(Integer id_producto, LocalDate fecha_venta) throws DAOException;
    List<Venta> obtenerReportexSuc(Integer id_suc) throws DAOException;
    List<Venta> obtenerReportexCliente(Integer id_cliente) throws DAOException;
    int obtenerCantidadInventario(Integer id_producto, Integer id_sucursal) throws DAOException;
    
}
