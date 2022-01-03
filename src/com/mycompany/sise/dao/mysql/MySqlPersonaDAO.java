/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sise.dao.mysql;

import com.mycompany.sise.dao.DAOException;
import com.mycompany.sise.dao.IPersonaDAO;
import com.mycompany.sise.entity.Persona;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jennifer
 */
public class MySqlPersonaDAO implements IPersonaDAO{
    
    private Connection cn;

    public MySqlPersonaDAO(Connection cn) {
        this.cn = cn;
    }
    
    final String INSERT = "{call pa_insertar_persona(?,?,?,?,?)}";
    final String GETALL = "{call pa_listar_persona(?,?)}";
    final String UPDATE = "{call pa_modificar_persona(?,?,?,?,?,?)}";
    final String DELETE = "{call pa_eliminar_persona(?)}";
    
    final String BUSCAR = "select * from persona where nombre like ? || apellidos like ? ";
    final String COUNT = "select count(*) as cantidad from persona";
    
    //Sql para validar si el DNI ya existe en nuestro Sistema
    final String VALIDAR = "{call pa_validar_dni(?,?)}";

    @Override
    public List<Persona> busqueda(String valor) throws DAOException {
         
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Persona> lista = new ArrayList<>();
        
        try {
            ps = cn.prepareStatement(BUSCAR);
            int i = 1;
            ps.setString(i++, "%"+valor+"%");
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
    public void insertar(Persona o) throws DAOException {
        
        CallableStatement cs = null;
        try {
            cs = cn.prepareCall(INSERT);
            
            int i = 1;
            cs.setString(i++, o.getNombre());
            cs.setString(i++, o.getApellidos());
            cs.setString(i++, o.getDoc_identidad());
            cs.setString(i++, o.getDireccion());
            cs.setInt(i++, o.getEdad());
            if(cs.executeUpdate() == 0)
                throw new DAOException("No se pudo Registrar la Persona!");
            
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
    public void modificar(Persona o) throws DAOException {
        
        CallableStatement cs = null;
        
        try {
            cs = cn.prepareCall(UPDATE);
            int i = 1;
            cs.setString(i++, o.getNombre());
            cs.setString(i++, o.getApellidos());
            cs.setString(i++, o.getDoc_identidad());
            cs.setString(i++, o.getDireccion());
            cs.setInt(i++, o.getEdad());
            cs.setInt(i++, o.getId_persona());
            
            if(cs.executeUpdate() == 0){
                throw new DAOException("No se pudo modificar la Persona!");
            }
        } catch (SQLException ex) {
            throw new DAOException("ERROR DE SQL", ex);
        }
    }

    @Override
    public void eliminar(Persona o) throws DAOException {
        
        CallableStatement cs = null;
        
        try {
            cs = cn.prepareCall(DELETE);
            int i =1;
            cs.setInt(i++, o.getId_persona());
            if(cs.executeUpdate() == 0){
                throw new DAOException("No se pudo eliminar la Persona!");
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
    public List<Persona> obtenerTodos() throws DAOException {
       
        CallableStatement cs = null;
        ResultSet rs = null;
        List<Persona> lista = new ArrayList<>();
        
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
    public List<Persona> paginacion(Integer inicio, Integer fin) throws DAOException {
        
        CallableStatement cs = null;
        ResultSet rs = null;
        List<Persona> lista = new ArrayList<>();
        
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
    
    private Persona getRS(ResultSet rs) throws SQLException{
        return new Persona(
                rs.getInt("id_persona"),
                rs.getString("nombre"),
                rs.getString("apellidos"),
                rs.getString("doc_identidad"),
                rs.getString("direccion"),
                rs.getInt("edad")
        );
    }

    @Override
    public Integer validador(String dni) throws DAOException {
        
        CallableStatement cs = null;
        int rpta;
        
        try {
            cs = cn.prepareCall(VALIDAR);
            int i =1;
            cs.setString(i++, dni);
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
