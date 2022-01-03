/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sise.dao.mysql;

import com.mycompany.sise.dao.DAOException;
import com.mycompany.sise.dao.IVentaDAO;
import com.mycompany.sise.entity.DetalleVenta;
import com.mycompany.sise.entity.Venta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jennifer
 */
public class MySqlVentaDAO implements IVentaDAO{
    
    private Connection cn;

    public MySqlVentaDAO(Connection cn) {
        this.cn = cn;
    }

    //SQL for VENTA
    final String INSERT = "{call pa_insertar_venta(?,?,?,?,?,?,?,?)}";
    final String GETALL = "{call pa_listar_venta(?,?)}";
    final String UPDATE = "{call pa_modificar_venta(?,?,?,?,?,?,?,?)}";
    final String DELETE = "{call pa_eliminar_venta(?)}";
    
    final String BUSCAR = "{call pa_buscar_venta(?,?)}";
    final String COUNT = "select count(*) as cantidad from venta";
    
    //SQL for DETALLE-VENTA
    
    final String GETDETALLE = "{call pa_listar_detalle_venta(?)}";
    final String GETDESCUENTO = "{call pa_obtener_descuento_producto(?,?,?)}";
    final String GETCANTIDAD = "{call pa_obtener_cantidad_inventario(?,?,?)}";
    
    //SQL for Reporte de Ventas
    final String SUCURSAL = "{call pa_ventas_Sucursal(?)}";
    final String CLIENTE = "{call pa_ventas_Cliente(?)}";
    
    @Override
    public List<Venta> busqueda(String valor) throws DAOException {
        
        CallableStatement cs = null;
        ResultSet rs = null;
        List<Venta> lista = new ArrayList<>();
        
        try {
            cs = cn.prepareCall(BUSCAR);
            int i = 1;
            cs.setString(i++, "%"+valor+"%");
            cs.setString(i++, "%"+valor+"%");
            
            rs = cs.executeQuery();
            while(rs.next()){
                lista.add(getRS(rs));
            }
        } catch (SQLException ex) {
            throw new DAOException("ERROR DE SQL", ex);
        }finally{
            try{
                if(rs != null){
                    rs.close();
                }
                if(cs != null){
                    cs.close();
                }
            } catch(SQLException ex){
                throw new DAOException("ERROR DE SQL", ex);
            }
        }
        return lista;
    }

    @Override
    public List<String> obtenerNombresColumnas() throws DAOException {
        
        CallableStatement cs = null;
        ResultSet rs = null;
        ResultSetMetaData rsmd = null;
        List<String> lista = new ArrayList<>();
        
        try {
            cs = cn.prepareCall(GETALL);
            int i = 1;
            cs.setInt(i++, 0);
            cs.setInt(i++, 0);
            rs = cs.executeQuery();
            rsmd = rs.getMetaData();
            
            for(int j = 1; j <= rsmd.getColumnCount(); j++){
                lista.add(rsmd.getColumnName(j));
            }
        } catch (SQLException ex) {
            throw new DAOException("ERROR DE SQL", ex);
        }finally{
            try{
                if(rs != null){
                    rs.close();
                }
                if(cs != null){
                    cs.close();
                }
            } catch(SQLException ex){
                throw new DAOException("ERROR DE SQL", ex);
            }
        }
        return lista;
    }


    @Override
    public void eliminar(Venta o) throws DAOException {
        
        CallableStatement cs = null;
        
        try {
            cs = cn.prepareCall(DELETE);
            int i =1;
            cs.setInt(i++, o.getId_venta());
            if(cs.executeUpdate() == 0){
                throw new DAOException("No se pudo eliminar la Venta!");
            }      
        } catch (SQLException ex) {
            throw new DAOException("ERROR DE SQL", ex);
        }finally{
            try{
                if(cs != null) cs.close();
            } catch(SQLException ex){
                throw new DAOException("ERROR DE SQL", ex);
            }
        }
    }

    @Override
    public List<Venta> obtenerTodos() throws DAOException {
        
        CallableStatement cs = null;
        ResultSet rs = null;
        List<Venta> lista = new ArrayList<>();
        
        try {
            cs = cn.prepareCall(GETALL);
            int i = 1;
            cs.setInt(i++, 0);
            cs.setInt(i++, Integer.MAX_VALUE);
            rs = cs.executeQuery();
            while(rs.next()){
                lista.add(getRS(rs));
            }
        } catch (SQLException ex) {
            throw new DAOException("ERROR DE SQL", ex);
        }finally{
            try{
                if(rs != null){
                    rs.close();
                }
                if(cs != null){
                    cs.close();
                }
            } catch(SQLException ex){
                throw new DAOException("ERROR DE SQL", ex);
            }
        }
        return lista;
    }

    

    @Override
    public List<Venta> paginacion(Integer inicio, Integer fin) throws DAOException {
        
        CallableStatement cs = null;
        ResultSet rs = null;
        List<Venta> lista = new ArrayList<>();
        
        try {
            cs = cn.prepareCall(GETALL);
            int i = 1;
            cs.setInt(i++, inicio);
            cs.setInt(i++, fin);
            rs = cs.executeQuery();
            while(rs.next()){
                lista.add(getRS(rs));
            }
        } catch (SQLException ex) {
            throw new DAOException("ERROR DE SQL", ex);
        }finally{
            try{
                if(rs != null){
                    rs.close();
                }
                if(cs != null){
                    cs.close();
                }
            } catch(SQLException ex){
                throw new DAOException("ERROR DE SQL", ex);
            }
        }
        return lista;
    }

    @Override
    public Integer cantidadRegistros() throws DAOException {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        int cantidad = 0;
        
        try {
            ps = cn.prepareStatement(COUNT);
            rs = ps.executeQuery();
            if(rs.next()){
                cantidad = rs.getInt(1);
            }
        } catch (SQLException ex) {
            throw new DAOException("ERROR DE SQL", ex);
        }finally{
            try{
                if(rs != null){
                    rs.close();
                }
                if(ps != null){
                    ps.close();
                }
            } catch(SQLException ex){
                throw new DAOException("ERROR DE SQL", ex);
            }
        }
        
        return cantidad;
    }
    
    private Venta getRS(ResultSet rs) throws SQLException{
        return new Venta(
                rs.getInt("id_venta"),
                rs.getInt("id_persona"),
                rs.getInt("id_tipo_doc"),
                rs.getInt("id_tipo_pago"),
                rs.getInt("id_sucursal"),
                rs.getDate("fecha").toLocalDate(),
                rs.getDouble("total_Desc"),
                rs.getDouble("total_Venta"),
                rs.getString("nombre"),
                rs.getString("apellidos"),
                rs.getString("doc_venta"),
                rs.getString("tipo_pago"),
                rs.getString("sucursal")
        );
    }
    
    private DetalleVenta getRSDetalle(ResultSet rsd) throws SQLException{
        return new DetalleVenta(
                rsd.getInt("id_venta"),
                rsd.getInt("id_producto"),
                rsd.getInt("cantidad"),
                rsd.getDouble("total"),
                rsd.getString("modelo"),
                rsd.getDouble("precio")
                
        );
    }
    
    @Override
    public List<DetalleVenta> obtenerDetalle(Integer id_Venta) throws DAOException {
        
        CallableStatement cs = null;
        ResultSet rs = null;
        List<DetalleVenta> lista = new ArrayList<>();
        
        try {
            cs = cn.prepareCall(GETDETALLE);
            int i = 1;
            cs.setInt(i++, id_Venta);
            rs = cs.executeQuery();
            while(rs.next()){
                lista.add(getRSDetalle(rs));
            }
        } catch (SQLException ex) {
            throw new DAOException("ERROR DE SQL", ex);
        }finally{
            try{
                if(rs != null){
                    rs.close();
                }
                if(cs != null){
                    cs.close();
                }
            } catch(SQLException ex){
                throw new DAOException("ERROR DE SQL", ex);
            }
        }
        return lista;
    }

    @Override
    public Integer insertarReturnId(Venta o) throws DAOException {
        
        CallableStatement cs = null;
        int id;
        try {
            cs = cn.prepareCall(INSERT);
            
            int i = 1;
            cs.setInt(i++, o.getId_persona());
            cs.setInt(i++, o.getId_tipo_doc());
            cs.setInt(i++, o.getId_tipo_pago());
            cs.setInt(i++, o.getId_sucursal());
            cs.setDate(i++, Date.valueOf(o.getFecha()));
            cs.setDouble(i++, o.getTotal_Desc());
            cs.setDouble(i++, o.getTotal_Venta());
            cs.registerOutParameter(i++, Types.INTEGER);
            cs.execute();
            id = cs.getInt("p_id"); 
            
            if(id == 0)
                throw new DAOException("No se pudo Registrar la Venta!");
            
        } catch (SQLException ex) {
            throw new DAOException("ERROR DE SQL", ex);
        }finally{
            try{
                if(cs != null){
                    cs.close();
                }
            } catch(SQLException ex){
                throw new DAOException("ERROR DE SQL", ex);
            }
        }
        
        return id;
    }

    
    //Consulta si el producto a vender tiene Descuento
    @Override
    public Double obtenerDescuentoxProducto(Integer id_producto, LocalDate fecha_venta) throws DAOException {
        
        CallableStatement cs = null;
        Double descuento;
        try {
            cs = cn.prepareCall(GETDESCUENTO);
            
            int i = 1;
            cs.setInt(i++, id_producto);
            cs.setDate(i++, Date.valueOf(fecha_venta));
            cs.registerOutParameter(i++, Types.DOUBLE);
            cs.execute();
            descuento = cs.getDouble("p_descuento"); 
        } catch (SQLException ex) {
            throw new DAOException("ERROR DE SQL", ex);
        }finally{
            try{
                if(cs != null){
                    cs.close();
                }
            } catch(SQLException ex){
                throw new DAOException("ERROR DE SQL", ex);
            }
        }
        
        return descuento;
    }

    @Override
    public List<Venta> obtenerReportexSuc(Integer id_suc) throws DAOException {
        
        CallableStatement cs = null;
        ResultSet rs = null;
        List<Venta> lista = new ArrayList<>();
        try {
            cs = cn.prepareCall(SUCURSAL);
            int i=1;
            cs.setInt(i++, id_suc);
            rs = cs.executeQuery();
            
            while(rs.next())
                lista.add(getRS(rs));
        } catch (SQLException ex) {
            throw new DAOException("Error de SQL", ex);
        }finally{
            try{
                if(rs!=null) rs.close();
                if(cs!=null) cs.close();
            }catch(SQLException ex){
                throw new DAOException("Error de SQL", ex);
            }
        }
        return lista;
    }


    @Override
    public List<Venta> obtenerReportexCliente(Integer id_cliente) throws DAOException {
        
        CallableStatement cs = null;
        ResultSet rs = null;
        List<Venta> lista = new ArrayList<>();
        try {
            cs = cn.prepareCall(CLIENTE);
            int i=1;
            cs.setInt(i++, id_cliente);
            rs = cs.executeQuery();
            while(rs.next())
                lista.add(getRS(rs));
        } catch (SQLException ex) {
            throw new DAOException("Error de SQL", ex);
        }finally{
            try{
                if(rs!=null) rs.close();
                if(cs!=null) cs.close();
            }catch(SQLException ex){
                throw new DAOException("Error de SQL", ex);
            }
        }
        return lista;
    }

    //valida la cantidad del producto antes de Vender
    @Override
    public int obtenerCantidadInventario(Integer id_producto, Integer id_sucursal) throws DAOException {
        
        CallableStatement cs = null;
        int cantidad;
        try {
            cs = cn.prepareCall(GETCANTIDAD);
            
            int i = 1;
            cs.setInt(i++, id_producto);
            cs.setInt(i++, id_sucursal);
            cs.registerOutParameter(i++, Types.INTEGER);
            cs.execute();
            cantidad = cs.getInt("p_stock"); 
        } catch (SQLException ex) {
            throw new DAOException("ERROR DE SQL", ex);
        }finally{
            try{
                if(cs != null){
                    cs.close();
                }
            } catch(SQLException ex){
                throw new DAOException("ERROR DE SQL", ex);
            }
        }
        
        return cantidad;
    }

    @Override
    public void insertar(Venta o) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Venta o) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
