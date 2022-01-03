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
public class Descuento {
    
    private Integer id_descuento;
    private String nombre;
    private Double porcentaje;

    public Descuento() {
    }

    public Descuento(Integer id_descuento, String nombre, Double porcentaje) {
        this.id_descuento = id_descuento;
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

    public Integer getId_descuento() {
        return id_descuento;
    }

    public void setId_descuento(Integer id_descuento) {
        this.id_descuento = id_descuento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public String toString() {
        return  nombre + " (" + porcentaje + ")";
    }
    
    
    
}
