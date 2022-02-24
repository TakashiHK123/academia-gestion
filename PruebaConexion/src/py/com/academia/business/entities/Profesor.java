/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.academia.business.entities;

import java.io.Serializable;

/**
 *
 * @author takashi
 */
public class Profesor implements Serializable {

    private static final long serialVersionUID = 1L;
    private int idProfesor;
    private String nombre;
    private String apellido;

    public Profesor() {
    }

    public Profesor(int idProfesor, String nombre, String apellido) {
        this.idProfesor = idProfesor;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Profesor{" + "idProfesor=" + idProfesor + ", nombre=" + nombre + ", apellido=" + apellido + "}\n";
    }

}
