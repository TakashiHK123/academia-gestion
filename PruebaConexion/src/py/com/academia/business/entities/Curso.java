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
public class Curso implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private int idCurso;
    private String descripcion; 

    public Curso() {
    }

    public Curso(int idCurso, String descripcion) {
        this.idCurso = idCurso;
        this.descripcion = descripcion;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Curso{" + "idCurso=" + idCurso + ", descripcion=" + descripcion + "}\n";
    }
    
    
    
    
}
