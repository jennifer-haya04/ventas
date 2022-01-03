/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sise.dao.mysql;

import com.mycompany.sise.dao.DAOException;
import com.mycompany.sise.dao.IProductoDescuentoDAO;
import com.mycompany.sise.entity.ProductoDescuento;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jennifer
 */
public class MySqlProdDescDAO implements IProductoDescuentoDAO{
    
    private Connection cn;

    public MySqlProdDescDAO(Connection cn) {
        this.cn = cn;
    }
    
    final String INSERT = "{call pa_insertar_productoDescuento(?,?,?,?)}";
    final String GETALL = "{call pa_listar_productoDescuento(?,?)}";
    final String UPDATE = "{call pa_modificar_productoDescuento(?,?,?,?)}";
    final String DELETE = "{call pa_eliminar_productoDescuento(?,?)}";
    
    final String BUSCAR = "{call pa_buscar_productoDescuento(?,?)}";
    final String COUNT = "select count(*) as cantidad from productoDescuento";

    @Override
    public List<ProductoDescuento> busqueda(String valor) throws DAOException {
        
        CallableStatement cs = null;
        ResultSet rs = null;
        List<ProductoDescuento> lista = new ArrayList<>();
        
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
    public void insertar(ProductoDescuento o) throws DAOException {
        
        CallableStatement cs = null;
        try {
            cs = cn.prepareCall(INSERT);
            
            int i = 1;
            cs.setInt(i++, o.getId_producto());
            cs.setInt(i++, o.getId_descuento());
            cs.setDate(i++, Date.valueOf(o.getFecha_inicio()));
            cs.setDate(i++, Date.valueOf(o.getFecha_fin()));
            if(cs.executeUpdate() == 0)
                throw new DAOException("No se pudo Registrar el Producto y su Descuento!");
            
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
    public void modificar(ProductoDescuento o) throws DAOException {
        
        CallableStatement cs = null;
        
        try {
            cs = cn.prepareCall(UPDATE);
            int i = 1;
            cs.setInt(i++, o.getId_producto());
            cs.setInt(i++, o.getId_descuento());
            cs.setDate(i++, Date.valueOf(o.getFecha_inicio()));
            cs.setDate(i++, Date.valueOf(o.getFecha_fin()));
            if(cs.executeUpdate() == 0){
                throw new DAOException("No se pudo modificar el Producto con su Descuento!");
            }
        } catch (SQLException ex) {
            throw new DAOException("ERROR DE SQL", ex);
        }
    }

    @Override
    public void eliminar(ProductoDescuento o) throws DAOException {
        
        CallableStatement cs = null;
        
        try {
            cs = cn.prepareCall(DELETE);
            int i =1;
            cs.setInt(i++, o.getId_producto());
            cs.setInt(i++, o.getId_descuento());
            if(cs.executeUpdate() == 0){
                throw new DAOException("No se pudo eliminar el Producto con su Descuento!");
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
    public List<ProductoDescuento> obtenerTodos() throws DAOException {
        
        CallableStatement cs = null;
        ResultSet rs = null;
        List<ProductoDescuento> lista = new ArrayList<>();
        
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
    public List<ProductoDescuento> paginacion(Integer inicio, Integer fin) throws DAOException {
        
        CallableStatement cs = null;
        ResultSet rs = null;
        List<ProductoDescuento> lista = new ArrayList<>();
        
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
    
    private ProductoDescuento getRS(ResultSet rs) throws SQLException{
        return new ProductoDescuento(
                rs.getInt("id_producto"),
                rs.getInt("id_descuento"),
                rs.getDate("fecha_inicio").toLocalDate(),
                rs.getDate("fecha_fin").toLocalDate(),
                rs.getString("modelo_Producto"),
                rs.getString("Descuento")
        );
    }
}
