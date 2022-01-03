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
public class Inventario {
    
    private Integer id_sucursal;
    private Integer id_producto;
    private Integer stock;
    private String nombre_sucursal;
    private String modelo_Producto;
    private String color;
    private String talla;

    public Inventario() {
    }

    public Inventario(Integer id_sucursal, Integer id_producto, Integer stock) {
        this.id_sucursal = id_sucursal;
        this.id_producto = id_producto;
        this.stock = stock;
    }

    public Inventario(Integer id_sucursal, Integer id_producto, Integer stock, String nombre_sucursal, String modelo_Producto, String color, String talla) {
        this.id_sucursal = id_sucursal;
        this.id_producto = id_producto;
        this.stock = stock;
        this.nombre_sucursal = nombre_sucursal;
        this.modelo_Producto = modelo_Producto;
        this.color = color;
        this.talla = talla;
    }
    
    public Integer getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(Integer id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getNombre_sucursal() {
        return nombre_sucursal;
    }

    public void setNombre_sucursal(String nombre_sucursal) {
        this.nombre_sucursal = nombre_sucursal;
    }

    public String getModelo_Producto() {
        return modelo_Producto;
    }

    public void setModelo_Producto(String modelo_Producto) {
        this.modelo_Producto = modelo_Producto;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    
}
