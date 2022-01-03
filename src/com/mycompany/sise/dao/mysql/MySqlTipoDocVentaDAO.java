/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sise.dao.mysql;

import com.mycompany.sise.dao.DAOException;
import com.mycompany.sise.dao.ITipoDocVentaDAO;
import com.mycompany.sise.entity.TipoDocVenta;
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
public class MySqlTipoDocVentaDAO implements ITipoDocVentaDAO{
    
    private Connection cn;

    public MySqlTipoDocVentaDAO(Connection cn) {
        this.cn = cn;
    }
    
    final String INSERT = "{call pa_insertar_tipoDocVenta(?)}";
    final String GETALL = "{call pa_listar_tipoDocVenta(?,?)}";
    final String UPDATE = "{call pa_modificar_tipoDocVenta(?,?)}";
    final String DELETE = "{call pa_eliminar_tipoDocVenta(?)}";
    
    final String BUSCAR = "select * from tipoDocVenta where nombre like ?";
    final String COUNT = "select count(*) as cantidad from tipoDocVenta";

    @Override
    public List<TipoDocVenta> busqueda(String valor) throws DAOException {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<TipoDocVenta> lista = new ArrayList<>();
        
        try {
            ps = cn.prepareStatement(BUSCAR);
            int i = 1;
            ps.setString(i++, "%"+valor+"%");
            
            rs = ps.executeQuery();
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
                if(ps != null){
                    ps.close();
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
    public void insertar(TipoDocVenta o) throws DAOException {
        
        CallableStatement cs = null;
        try {
            cs = cn.prepareCall(INSERT);
            
            int i = 1;
            cs.setString(i++, o.getNombre());
            if(cs.executeUpdate() == 0)
                throw new DAOException("No se pudo Registrar el Tipo de Documento de Venta!");
            
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
    public void modificar(TipoDocVenta o) throws DAOException {
        
        CallableStatement cs = null;
        
        try {
            cs = cn.prepareCall(UPDATE);
            int i = 1;
            cs.setString(i++, o.getNombre());
            cs.setInt(i++, o.getId_tipo_doc());
            
            if(cs.executeUpdate() == 0){
                throw new DAOException("No se pudo modificar el Tipo de Documento de Venta!");
            }
        } catch (SQLException ex) {
            throw new DAOException("ERROR DE SQL", ex);
        }
    }

    @Override
    public void eliminar(TipoDocVenta o) throws DAOException {
        
        CallableStatement cs = null;
        
        try {
            cs = cn.prepareCall(DELETE);
            int i =1;
            cs.setInt(i++, o.getId_tipo_doc());
            if(cs.executeUpdate() == 0){
                throw new DAOException("No se pudo eliminar el Tipo de Documento de Venta!");
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
    public List<TipoDocVenta> obtenerTodos() throws DAOException {
        
        CallableStatement cs = null;
        ResultSet rs = null;
        List<TipoDocVenta> lista = new ArrayList<>();
        
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
    public List<TipoDocVenta> paginacion(Integer inicio, Integer fin) throws DAOException {
        
        CallableStatement cs = null;
        ResultSet rs = null;
        List<TipoDocVenta> lista = new ArrayList<>();
        
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
    
    private TipoDocVenta getRS(ResultSet rs) throws SQLException{
        return new TipoDocVenta(
                rs.getInt("id_tipo_doc"),
                rs.getString("nombre")
        );
    }
    
}
