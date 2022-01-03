/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sise.dao.mysql;

import com.mycompany.sise.dao.DAOException;
import com.mycompany.sise.dao.IInventarioDAO;
import com.mycompany.sise.entity.Inventario;
import com.mycompany.sise.util.Helper;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jennifer
 */
public class MySqlInventarioDAO implements IInventarioDAO{
    
    private Connection cn;

    public MySqlInventarioDAO(Connection cn) {
        this.cn = cn;
    }
    
    final String INSERT = "{call pa_insertar_inventario(?,?,?)}";
    final String GETALL = "{call pa_listar_inventario(?,?)}";
    final String UPDATE = "{call pa_modificar_inventario(?,?,?)}";
    final String DELETE = "{call pa_eliminar_inventario(?,?)}";
    
    final String BUSCAR = "{call pa_buscar_inventario(?,?,?,?)}";
    final String COUNT = "select count(*) as cantidad from inventario";

    @Override
    public List<Inventario> busqueda(String valor) throws DAOException {
        
        CallableStatement cs = null;
        ResultSet rs = null;
        List<Inventario> lista = new ArrayList<>();
        
        try {
            cs = cn.prepareCall(BUSCAR);
            int i = 1;
            cs.setString(i++, "%"+valor+"%");
            cs.setString(i++, "%"+valor+"%");
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

    
    public Helper insertarValidado(Inventario o){
        
        Helper help = new Helper(false, "Se registro exitoso");
        
        CallableStatement cs = null;
        try {
            cs = cn.prepareCall(INSERT);
            
            int i = 1;
            cs.setInt(i++, o.getId_sucursal());
            cs.setInt(i++, o.getId_producto());
            cs.setInt(i++, o.getStock());
            if(cs.executeUpdate() == 0)
                help.setValues(Boolean.TRUE, "No se pudo Registrar en el Inventario!");
        } catch (SQLException ex) {
             help.setException(ex);
             
            if(ex.getErrorCode() == 1062){
                help.setValues(Boolean.TRUE, "Registro Duplicado: La Sucursal ya contiene ese Producto!");
            } else{
                help.setValues(Boolean.TRUE, "Error en la transaction en BD!");
            }
        }finally{
            try{
                if(cs != null){
                    cs.close();
                }
            } catch(SQLException ex){
                help.setValues(Boolean.TRUE, "Error SQL Registrar en el Inventario!");
            }
        }
        
        return help;
    }

    @Override
    public void modificar(Inventario o) throws DAOException {
        
        CallableStatement cs = null;
        
        try {
            cs = cn.prepareCall(UPDATE);
            int i = 1;
            cs.setInt(i++, o.getStock());
            cs.setInt(i++, o.getId_sucursal());
            cs.setInt(i++, o.getId_producto());
            if(cs.executeUpdate() == 0){
                throw new DAOException("No se pudo modificar en el Inventario!");
            }
        } catch (SQLException ex) {
            throw new DAOException("ERROR DE SQL", ex);
        }
    }

    @Override
    public void eliminar(Inventario o) throws DAOException {
        
        CallableStatement cs = null;
        
        try {
            cs = cn.prepareCall(DELETE);
            int i =1;
            cs.setInt(i++, o.getId_sucursal());
            cs.setInt(i++, o.getId_producto());
            if(cs.executeUpdate() == 0){
                throw new DAOException("No se pudo eliminar en el Inventario!");
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
    public List<Inventario> obtenerTodos() throws DAOException {
        
        CallableStatement cs = null;
        ResultSet rs = null;
        List<Inventario> lista = new ArrayList<>();
        
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
    public List<Inventario> paginacion(Integer inicio, Integer fin) throws DAOException {
        
        CallableStatement cs = null;
        ResultSet rs = null;
        List<Inventario> lista = new ArrayList<>();
        
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
    
    private Inventario getRS(ResultSet rs) throws SQLException{
        return new Inventario(
                rs.getInt("id_sucursal"),
                rs.getInt("id_producto"),
                rs.getInt("stock"),
                rs.getString("nombre_sucursal"),
                rs.getString("modelo_Producto"),
                rs.getString("color"),
                rs.getString("talla")
        );
    }

    @Override
    public void insertar(Inventario o) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
