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
public class TipoPago {
    
    private Integer id_tipo_pago;
    private String nombre;

    public TipoPago() {
    }

    public TipoPago(Integer id_tipo_pago, String nombre) {
        this.id_tipo_pago = id_tipo_pago;
        this.nombre = nombre;
    }

    public Integer getId_tipo_pago() {
        return id_tipo_pago;
    }

    public void setId_tipo_pago(Integer id_tipo_pago) {
        this.id_tipo_pago = id_tipo_pago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
    
}
