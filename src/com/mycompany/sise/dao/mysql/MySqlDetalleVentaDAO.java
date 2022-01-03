/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sise.dao.mysql;

import com.mycompany.sise.dao.DAOException;
import com.mycompany.sise.dao.IDetalleVentaDAO;
import com.mycompany.sise.entity.DetalleVenta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jennifer
 */
public class MySqlDetalleVentaDAO implements IDetalleVentaDAO{
    
    private Connection cn;

    public MySqlDetalleVentaDAO(Connection cn) {
        this.cn = cn;
    }

    final String INSERT = "{call pa_insertar_detalle_venta(?,?,?,?)}";
    final String GETALL = "{call pa_listar_detalle_venta(?,?)}";
    final String UPDATE = "{call pa_modificar_detalle_venta(?,?,?,?)}";
    final String DELETE = "{call pa_eliminar_detalle_venta(?,?)}";
    
    final String BUSCAR = "{call pa_buscar_detalle_venta(?,?)}";
    final String COUNT = "select count(*) as cantidad from detalle_venta";
    
    
    @Override
    public List<DetalleVenta> busqueda(String valor) throws DAOException {
        
        CallableStatement cs = null;
        ResultSet rs = null;
        List<DetalleVenta> lista = new ArrayList<>();
        
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
    public void insertar(DetalleVenta o) throws DAOException {
       
        CallableStatement cs = null;
        try {
            cs = cn.prepareCall(INSERT);
            
            int i = 1;
            cs.setInt(i++, o.getId_venta());
            cs.setInt(i++, o.getId_producto());
            cs.setInt(i++, o.getCantidad());
            cs.setDouble(i++, o.getTotal());
            if(cs.executeUpdate() == 0)
                throw new DAOException("No se pudo Registrar en el Detalle de Venta!");
            
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
    }

    @Override
    public void modificar(DetalleVenta o) throws DAOException {
        
        CallableStatement cs = null;
        
        try {
            cs = cn.prepareCall(UPDATE);
            int i = 1;
            
            cs.setInt(i++, o.getId_producto());
            cs.setInt(i++, o.getCantidad());
            cs.setDouble(i++, o.getTotal());
            cs.setInt(i++, o.getId_venta());
            if(cs.executeUpdate() == 0){
                throw new DAOException("No se pudo modificar en el Detalle de Venta!");
            }
        } catch (SQLException ex) {
            throw new DAOException("ERROR DE SQL", ex);
        }
    }

    @Override
    public void eliminar(DetalleVenta o) throws DAOException {
        
        CallableStatement cs = null;
        
        try {
            cs = cn.prepareCall(DELETE);
            int i =1;
            cs.setInt(i++, o.getId_venta());
            cs.setInt(i++, o.getId_producto());
            if(cs.executeUpdate() == 0){
                throw new DAOException("No se pudo eliminar en el detalle de Venta!");
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
    public List<DetalleVenta> obtenerTodos() throws DAOException {
        
         CallableStatement cs = null;
        ResultSet rs = null;
        List<DetalleVenta> lista = new ArrayList<>();
        
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
    public List<DetalleVenta> paginacion(Integer inicio, Integer fin) throws DAOException {
        
        CallableStatement cs = null;
        ResultSet rs = null;
        List<DetalleVenta> lista = new ArrayList<>();
        
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
    
    private DetalleVenta getRS(ResultSet rs) throws SQLException{
        return new DetalleVenta(
                rs.getInt("id_venta"),
                rs.getInt("id_producto"),
                rs.getInt("cantidad"),
                rs.getDouble("total"),
                rs.getString("modelo"),
                rs.getDouble("precio")
        );
    }
    
    //Metodo para insertar los Productos al realizar una Venta
    @Override
    public int[] cargarProductosBD(List<DetalleVenta> lista) throws DAOException {
        
        CallableStatement cs = null;
        int[] resultados;
        try{
            cs = cn.prepareCall(INSERT);
            for(DetalleVenta o: lista){
                int i=1;
                cs.setInt(i++,o.getId_venta());
                cs.setInt(i++,o.getId_producto());
                cs.setInt(i++, o.getCantidad());
                cs.setDouble(i++, o.getTotal());
                cs.addBatch();
            }
            
            resultados = cs.executeBatch();
            if(resultados.length==0)
                throw new DAOException("No se pudo agregar los Productos!!!");
            
        } catch (SQLException ex) {
            throw new DAOException("Error de SQL", ex);
        }finally{
            try{
                if(cs!=null) cs.close();
            }catch(SQLException ex){
                throw new DAOException("Error de SQL", ex);
            }
        }
        return resultados;
    }
}
