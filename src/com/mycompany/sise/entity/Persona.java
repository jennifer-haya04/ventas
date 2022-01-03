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
public class Persona {
    
    private Integer id_persona;
    private String nombre;
    private String apellidos;
    private String doc_identidad;
    private String direccion;
    private int edad;  

    public Persona() {
    }

    public Persona(Integer id_persona, String nombre, String apellidos, String doc_identidad, String direccion, int edad) {
        this.id_persona = id_persona;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.doc_identidad = doc_identidad;
        this.direccion = direccion;
        this.edad = edad;
    }

    public Integer getId_persona() {
        return id_persona;
    }

    public void setId_persona(Integer id_persona) {
        this.id_persona = id_persona;
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

    public String getDoc_identidad() {
        return doc_identidad;
    }

    public void setDoc_identidad(String doc_identidad) {
        this.doc_identidad = doc_identidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return nombre + " " + apellidos + "(" + doc_identidad + ")";
    }
    
    
}
