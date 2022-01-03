/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sise.dao.mysql;

import com.mycompany.sise.dao.Conexion;
import com.mycompany.sise.dao.IDAOManager;
import java.sql.Connection;
import com.mycompany.sise.dao.ICategoriaProductoDAO;
import com.mycompany.sise.dao.IDescuentoDAO;
import com.mycompany.sise.dao.IDetalleVentaDAO;
import com.mycompany.sise.dao.IEmpleadoDAO;
import com.mycompany.sise.dao.IInventarioDAO;
import com.mycompany.sise.dao.IPersonaDAO;
import com.mycompany.sise.dao.IProductoDAO;
import com.mycompany.sise.dao.IProductoDescuentoDAO;
import com.mycompany.sise.dao.ISucursalDAO;
import com.mycompany.sise.dao.ITipoDocVentaDAO;
import com.mycompany.sise.dao.ITipoPagoDAO;
import com.mycompany.sise.dao.IVentaDAO;

/**
 *
 * @author jennifer
 */
public class MySqlDAOManager implements IDAOManager{
    
    private static final MySqlDAOManager instancia = new MySqlDAOManager();
    private Connection cn;
    private ICategoriaProductoDAO categoriaProductoDao = null;
    private IDescuentoDAO descuentoDao = null;
    private IInventarioDAO inventarioDao = null;
    private IPersonaDAO personaDao = null;
    private IProductoDAO productoDao = null;
    private IProductoDescuentoDAO productoDescuentoDao = null;
    private ISucursalDAO sucursalDao = null;
    private ITipoDocVentaDAO tipoDocDao = null;
    private ITipoPagoDAO tipoPagoDao = null;
    private IVentaDAO ventaDao = null;
    private IDetalleVentaDAO detalleVentaDao = null;
    private IEmpleadoDAO empleadoDao = null;
    
    private MySqlDAOManager(){
        cn = new Conexion().getCnx();
    }
    
    public static MySqlDAOManager getInstancia(){
        return instancia;
    }

    @Override
    public ICategoriaProductoDAO getCategoriaProductoDAO() {
        if(categoriaProductoDao == null){
           categoriaProductoDao = new MySqlCategoriaProductoDAO(cn);
        }
        
        return categoriaProductoDao;
    }

    @Override
    public IDescuentoDAO getDescuentoDAO() {
        if(descuentoDao == null){
           descuentoDao = new MySqlDescuentoDAO(cn);
        }
        
        return descuentoDao;
    }

    @Override
    public IInventarioDAO getInventarioDAO() {
        if(inventarioDao == null){
           inventarioDao = new MySqlInventarioDAO(cn);
        }
        
        return inventarioDao;
    }

    @Override
    public IPersonaDAO getPersonaDAO() {
        if(personaDao == null){
           personaDao = new MySqlPersonaDAO(cn);
        }
        
        return personaDao;
    }

    @Override
    public IProductoDAO getProductoDAO() {
        
        if(productoDao == null){
           productoDao = new MySqlProductoDAO(cn);
        }
        
        return productoDao;
    }

    @Override
    public IProductoDescuentoDAO getProductoDescuentoDAO() {
        if(productoDescuentoDao == null){
            productoDescuentoDao = new MySqlProdDescDAO(cn);
        }
        return productoDescuentoDao;
    }

    @Override
    public ISucursalDAO getSucursalDAO() {
        
        if(sucursalDao == null){
           sucursalDao = new MySqlSucursalDAO(cn);
        }
        
        return sucursalDao;
    }

    @Override
    public ITipoDocVentaDAO getTipoDocVentaDAO() {
        
        if(tipoDocDao == null){
           tipoDocDao = new MySqlTipoDocVentaDAO(cn);
        }
        
        return tipoDocDao;
    }

    @Override
    public ITipoPagoDAO getTipoPagoDAO() {
        
        if(tipoPagoDao == null){
           tipoPagoDao = new MySqlTipoPagoDAO(cn);
        }
        
        return tipoPagoDao;
    }

    @Override
    public IVentaDAO getVentaDAO() {
        
        if(ventaDao == null){
           ventaDao = new MySqlVentaDAO(cn);
        }
        
        return ventaDao;
    }

    @Override
    public IDetalleVentaDAO getDetalleVentaDAO() {
        
        if(detalleVentaDao == null){
           detalleVentaDao = new MySqlDetalleVentaDAO(cn);
        }
        
        return detalleVentaDao;
    }

    @Override
    public IEmpleadoDAO getEmpleado() {
        
        if(empleadoDao == null){
           empleadoDao = new MySqlLoginDAO(cn);
        }
        
        return empleadoDao;
    }
    
}
