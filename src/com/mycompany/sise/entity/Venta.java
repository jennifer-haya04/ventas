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
public class Venta {
    
    private Integer id_venta;
    private Integer id_persona;
    private int id_tipo_doc;
    private int id_tipo_pago;
    private int id_sucursal;
    private LocalDate fecha;
    private double total_Desc;
    private double total_Venta;
    private String nombre;
    private String apellidos;
    private String doc_venta;
    private String tipo_pago;
    private String sucursal;

    public Venta() {
    }

    public Venta(Integer id_venta, Integer id_persona, int id_tipo_doc, int id_tipo_pago, int id_sucursal, LocalDate fecha, double total_Desc, double total_Venta) {
        this.id_venta = id_venta;
        this.id_persona = id_persona;
        this.id_tipo_doc = id_tipo_doc;
        this.id_tipo_pago = id_tipo_pago;
        this.id_sucursal = id_sucursal;
        this.fecha = fecha;
        this.total_Desc = total_Desc;
        this.total_Venta = total_Venta;
    }

    public Venta(Integer id_venta, Integer id_persona, int id_tipo_doc, int id_tipo_pago, int id_sucursal, LocalDate fecha, double total_Desc, double total_Venta, String nombre, String apellidos, String doc_venta, String tipo_pago, String sucursal) {
        this.id_venta = id_venta;
        this.id_persona = id_persona;
        this.id_tipo_doc = id_tipo_doc;
        this.id_tipo_pago = id_tipo_pago;
        this.id_sucursal = id_sucursal;
        this.fecha = fecha;
        this.total_Desc = total_Desc;
        this.total_Venta = total_Venta;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.doc_venta = doc_venta;
        this.tipo_pago = tipo_pago;
        this.sucursal = sucursal;
    }
    
    

    public Integer getId_venta() {
        return id_venta;
    }

    public void setId_venta(Integer id_venta) {
        this.id_venta = id_venta;
    }

    public Integer getId_persona() {
        return id_persona;
    }

    public void setId_persona(Integer id_persona) {
        this.id_persona = id_persona;
    }

    public int getId_tipo_doc() {
        return id_tipo_doc;
    }

    public void setId_tipo_doc(int id_tipo_doc) {
        this.id_tipo_doc = id_tipo_doc;
    }

    public int getId_tipo_pago() {
        return id_tipo_pago;
    }

    public void setId_tipo_pago(int id_tipo_pago) {
        this.id_tipo_pago = id_tipo_pago;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getTotal_Desc() {
        return total_Desc;
    }

    public void setTotal_Desc(double total_Desc) {
        this.total_Desc = total_Desc;
    }

    public double getTotal_Venta() {
        return total_Venta;
    }

    public void setTotal_Venta(double total_Venta) {
        this.total_Venta = total_Venta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDoc_venta() {
        return doc_venta;
    }

    public void setDoc_venta(String doc_venta) {
        this.doc_venta = doc_venta;
    }

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }
    
    
    
    
    
}
