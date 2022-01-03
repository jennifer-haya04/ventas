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
public class DetalleVenta {
    
    private Integer id_venta;
    private Integer id_producto;
    private int cantidad;
    private double total;
    private String modelo;
    private double precio;
    private double descuento;
    

    public DetalleVenta() {
    }

    public DetalleVenta(Integer id_venta, Integer id_producto, int cantidad, double total) {
        this.id_venta = id_venta;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.total = total;
    }

    public DetalleVenta(Integer id_venta, Integer id_producto, int cantidad, double total, String modelo, double precio) {
        this.id_venta = id_venta;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.total = total;
        this.modelo = modelo;
        this.precio = precio;
    }
    
    

    public DetalleVenta(Integer id_venta, Integer id_producto, int cantidad, double total, String modelo, double precio, double descuento) {
        this.id_venta = id_venta;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.total = total;
        this.modelo = modelo;
        this.precio = precio;
        this.descuento = descuento;
    }


    public Integer getId_venta() {
        return id_venta;
    }

    public void setId_venta(Integer id_venta) {
        this.id_venta = id_venta;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
    
    
    
}
