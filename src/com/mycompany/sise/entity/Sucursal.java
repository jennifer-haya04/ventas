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
public class Sucursal {
    
    private Integer id_sucursal;
    private String nombre;
    private String direccion;
    private String telefono;

    public Sucursal() {
    }

    public Sucursal(Integer id_sucursal, String nombre, String direccion, String telefono) {
        this.id_sucursal = id_sucursal;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Integer getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(Integer id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
}
