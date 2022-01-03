/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sise.entity;

import java.time.LocalDate;

/**
 *
 * @author jennifer
 */
public class ProductoDescuento {
    
    private Integer id_producto;
    private Integer id_descuento;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private String modelo_Producto;
    private String Descuento;

    public ProductoDescuento() {
    }

    public ProductoDescuento(Integer id_producto, Integer id_descuento, LocalDate fecha_inicio, LocalDate fecha_fin) {
        this.id_producto = id_producto;
        this.id_descuento = id_descuento;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public ProductoDescuento(Integer id_producto, Integer id_descuento, LocalDate fecha_inicio, LocalDate fecha_fin, String modelo_Producto, String Descuento) {
        this.id_producto = id_producto;
        this.id_descuento = id_descuento;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.modelo_Producto = modelo_Producto;
        this.Descuento = Descuento;
    }
    
    

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public Integer getId_descuento() {
        return id_descuento;
    }

    public void setId_descuento(Integer id_descuento) {
        this.id_descuento = id_descuento;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getModelo_Producto() {
        return modelo_Producto;
    }

    public void setModelo_Producto(String modelo_Producto) {
        this.modelo_Producto = modelo_Producto;
    }

    public String getDescuento() {
        return Descuento;
    }

    public void setDescuento(String Descuento) {
        this.Descuento = Descuento;
    }
    
    
}
