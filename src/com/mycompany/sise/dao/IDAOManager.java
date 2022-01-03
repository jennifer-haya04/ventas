/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sise.dao;

/**
 *
 * @author jennifer
 */
public interface IDAOManager {
    
    ICategoriaProductoDAO getCategoriaProductoDAO();
    IDescuentoDAO getDescuentoDAO();
    IInventarioDAO getInventarioDAO();
    IPersonaDAO getPersonaDAO();
    IProductoDAO getProductoDAO();
    IProductoDescuentoDAO getProductoDescuentoDAO();
    ISucursalDAO getSucursalDAO();
    ITipoDocVentaDAO getTipoDocVentaDAO();
    ITipoPagoDAO getTipoPagoDAO();
    IVentaDAO getVentaDAO();
    IDetalleVentaDAO getDetalleVentaDAO();
    IEmpleadoDAO getEmpleado();
    
    
}
