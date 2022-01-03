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
public class TipoDocVenta {
    
    private Integer id_tipo_doc;
    private String nombre;

    public TipoDocVenta() {
    }

    public TipoDocVenta(Integer id_tipo_doc, String nombre) {
        this.id_tipo_doc = id_tipo_doc;
        this.nombre = nombre;
    }

    public Integer getId_tipo_doc() {
        return id_tipo_doc;
    }

    public void setId_tipo_doc(Integer id_tipo_doc) {
        this.id_tipo_doc = id_tipo_doc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre ;
    }
    
    
    
}
