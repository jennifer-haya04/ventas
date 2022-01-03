/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sise.util;

/**
 *
 * @author jennifer
 */
public class Helper {
    
    Boolean error;
    Exception exception;
    String mensajeUsuario;

    public Helper() {
    }

    public Helper(Boolean error, String mensajeUsuario) {
        this.error = error;
        this.mensajeUsuario = mensajeUsuario;
    }


    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public String getMensajeUsuario() {
        return mensajeUsuario;
    }

    public void setMensajeUsuario(String mensajeUsuario) {
        this.mensajeUsuario = mensajeUsuario;
    }

    public void setValues(Boolean error, String mensajeUsuario) {
        this.error = error;
        this.mensajeUsuario = mensajeUsuario;
    }
}
