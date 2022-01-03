/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sise.dao.mysql;

import com.mycompany.sise.dao.DAOException;
import com.mycompany.sise.dao.ICategoriaProductoDAO;
import com.mycompany.sise.entity.CategoriaProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Types;

/**
 *
 * @author jennifer
 */
public class MySqlCategoriaProductoDAO implements ICategoriaProductoDAO{
    
     private Connection cn;

    public MySqlCategoriaProductoDAO(Connection cn) {
        this.cn = cn;
    }
    
    //SQL Precompilados
    
    final String INSERT = "{call pa_insertar_categoriaProducto(?,?)}";
    final String GETALL = "{call pa_listar_categoriaProducto(?,?)}";
    final String UPDATE = "{call pa_modificar_categoriaProducto(?,?,?)}";
    final String DELETE = "{call pa_eliminar_categoriaProducto(?)}";
    
    final String BUSCAR = "select * from categoriaProducto where NOMBRE like ? ";
    final String COUNT = "select count(*) as cantidad from categoriaProducto";
    
    // Sql consultar si el nombre de la Categoria ya existe
    final String VALIDAR = "{call pa_validar_categoria(?,?)}";

    @Override
    public List<CategoriaProducto> busqueda(String valor) throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<CategoriaProducto> lista = new ArrayList<>();
        
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
    public void insertar(CategoriaProducto o) throws DAOException {
        CallableStatement cs = null;
        try {
            cs = cn.prepareCall(INSERT);
            
            int i = 1;
            cs.setString(i++, o.getNombre());
            cs.setString(i++, o.getDescripcion());
            if(cs.executeUpdate() == 0)
                throw new DAOException("No se pudo Registrar la Categoria!");
            
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
    public void modificar(CategoriaProducto o) throws DAOException {
        CallableStatement cs = null;
        
        try {
            cs = cn.prepareCall(UPDATE);
            int i = 1;
            cs.setString(i++, o.getNombre());
            cs.setString(i++, o.getDescripcion());
            cs.setInt(i++, o.getId_Cat());
            
            if(cs.executeUpdate() == 0){
                throw new DAOException("No se pudo modificar la Categoria!");
            }
        } catch (SQLException ex) {
            throw new DAOException("ERROR DE SQL", ex);
        }
    }

    @Override
    public void eliminar(CategoriaProducto o) throws DAOException {
        CallableStatement cs = null;
        
        try {
            cs = cn.prepareCall(DELETE);
            int i =1;
            cs.setInt(i++, o.getId_Cat());
            if(cs.executeUpdate() == 0){
                throw new DAOException("No se pudo eliminar la Categoria!");
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
    public List<CategoriaProducto> obtenerTodos() throws DAOException {
        CallableStatement cs = null;
        ResultSet rs = null;
        List<CategoriaProducto> lista = new ArrayList<>();
        
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
    public List<CategoriaProducto> paginacion(Integer inicio, Integer fin) throws DAOException {
        CallableStatement cs = null;
        ResultSet rs = null;
        List<CategoriaProducto> lista = new ArrayList<>();
        
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
    
    private CategoriaProducto getRS(ResultSet rs) throws SQLException{
        return new CategoriaProducto(
                rs.getInt("id_Cat"),
                rs.getString("nombre"),
                rs.getString("descripcion")
        );
    }


    @Override
    public Integer validador(String nombre) throws DAOException {
        
        CallableStatement cs = null;
        int rpta;
        
        try {
            cs = cn.prepareCall(VALIDAR);
            int i =1;
            cs.setString(i++, nombre);
            cs.registerOutParameter(i++, Types.INTEGER);
            cs.execute();
            rpta = cs.getInt("p_valida");     
        } catch (SQLException ex) {
            throw new DAOException("ERROR DE SQL", ex);
        }finally{
            try{
                if(cs != null) cs.close();
            } catch(SQLException ex){
                throw new DAOException("ERROR DE SQL", ex);
            }
        }
        
        return rpta;
    }
    
}
