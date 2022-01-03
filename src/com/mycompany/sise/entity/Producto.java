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
public class Producto {
    
    private Integer id_producto;
    private Integer id_Cat;
    private String modelo;
    private String talla;
    private String color;
    private Double precio;
    private String imagen;
    private String des_categoria;

    public Producto() {
    }

    public Producto(Integer id_producto, Integer id_Cat,String modelo, String talla, String color, Double precio, String imagen) {
        this.id_producto = id_producto;
        this.id_Cat = id_Cat;
        this.modelo = modelo;
        this.talla = talla;
        this.color = color;
        this.precio = precio;
        this.imagen = imagen;
    }

    public Producto(Integer id_producto, Integer id_Cat, String modelo, String talla, String color, Double precio, String imagen, String des_categoria) {
        this.id_producto = id_producto;
        this.id_Cat = id_Cat;
        this.modelo = modelo;
        this.talla = talla;
        this.color = color;
        this.precio = precio;
        this.imagen = imagen;
        this.des_categoria = des_categoria;
    }


    
    
    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public Integer getId_Cat() {
        return id_Cat;
    }

    public void setId_Cat(Integer id_Cat) {
        this.id_Cat = id_Cat;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDes_categoria() {
        return des_categoria;
    }

    public void setDes_categoria(String des_categoria) {
        this.des_categoria = des_categoria;
    }

    @Override
    public String toString() {
        return  modelo + ". T:" + talla + "(" + color + ")";
    }
    
}
