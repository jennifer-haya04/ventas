/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sise.entity;

/**
 *
 * @author jennifer
 */
public class CategoriaProducto {
    
    private Integer id_Cat;
    private String nombre;
    private String descripcion;

    public CategoriaProducto() {
    }

    public CategoriaProducto(Integer id_Cat, String nombre, String descripcion) {
        this.id_Cat = id_Cat;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getId_Cat() {
        return id_Cat;
    }

    public void setId_Cat(Integer id_Cat) {
        this.id_Cat = id_Cat;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
}
