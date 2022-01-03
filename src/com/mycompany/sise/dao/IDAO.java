/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sise.dao;

import java.util.List;

/**
 *
 * @author jennifer
 */
public interface IDAO<T,K> {
    
    void insertar(T o) throws DAOException;
    void modificar(T o) throws DAOException;
    void eliminar(T o) throws DAOException;
    List <T> obtenerTodos() throws DAOException;
    List<T> paginacion(Integer inicio, Integer fin) throws DAOException;
    Integer cantidadRegistros() throws DAOException;
    
}
