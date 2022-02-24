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
public class Materia implements Serializable{
    
    private int idMateria; 
    private String descripcion; 

    public Materia() {
    }

    public Materia(int idMateria, String descripcion) {
        this.idMateria = idMateria;
        this.descripcion = descripcion;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Materia{" + "idMateria=" + idMateria + ", descripcion=" + descripcion + "}\n";
    }
    
    
            
}
