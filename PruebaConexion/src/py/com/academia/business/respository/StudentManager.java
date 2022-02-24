/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.academia.business.respository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import py.com.academia.business.entities.Alumno;
import py.com.academia.utils.ConnectionManager;

/**
 *
 * @author takashi
 */
public class StudentManager {

    private static final String SQL_INSERT = "INSERT INTO alumno (idalumno, nombre, apellido) VALUES (?, ?, ?)";
    private static final String SQL = "SELECT * FROM alumno";
    private static final String SQL_DELETE = "DELETE FROM alumno WHERE idalumno=?";
    private static final String SQL_MODIFY = "UPDATE alumno SET nombre=?, apellido=? WHERE idalumno=?";

    public List<Alumno> getAllStudents() {

        try (Connection conn = ConnectionManager.getConnection();
                Statement statement = conn.createStatement()) {
            List<Alumno> listaAlumnos = new ArrayList();
            
            ResultSet resultSet = statement.executeQuery(SQL);
            
            while (resultSet.next()) {
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(resultSet.getInt("idalumno")); 
                alumno.setApellido(resultSet.getString("apellido"));
                alumno.setNombre(resultSet.getString("nombre"));
                
                listaAlumnos.add(alumno);
            }
            resultSet.close();
            return listaAlumnos;
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        
        return Collections.EMPTY_LIST; 
    }

    public void add(String nombre, String apellido) {

        try (Connection conn = ConnectionManager.getConnection();
                PreparedStatement preparestatement = conn.prepareStatement(SQL_INSERT)) {
            StudentManager studentManager = new StudentManager(); 
            preparestatement.setInt(1, studentManager.generarCodigo());
            preparestatement.setString(2, nombre);
            preparestatement.setString(3, apellido);

            preparestatement.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

    }

    public void delete(int idAlumno) {

        try (Connection conn = ConnectionManager.getConnection();
                PreparedStatement preparestatement = conn.prepareStatement(SQL_DELETE)) {

            preparestatement.setInt(1, idAlumno);

            preparestatement.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

    }
    
    public void modify(int idAlumno, String nombre, String apellido){
        try(Connection conn = ConnectionManager.getConnection();
                PreparedStatement preparestatement = conn.prepareStatement(SQL_MODIFY)){
            
            preparestatement.setString(1, nombre);
            preparestatement.setString(2, apellido);
            preparestatement.setInt(3, idAlumno); 
            
            preparestatement.executeUpdate(); 
            
            
        }catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }

    public Alumno getByid(int idAlumno) {

        try (Connection conn = ConnectionManager.getConnection();
                Statement statement = conn.createStatement()) {
            
            ResultSet resultSet = statement.executeQuery(SQL);
            
            while (resultSet.next()) {
                              
                if (resultSet.getInt("idalumno")==idAlumno){
                    Alumno student = new Alumno();
                    student.setIdAlumno(resultSet.getInt("idalumno"));
                    student.setNombre(resultSet.getString("nombre"));
                    student.setApellido(resultSet.getString("apellido"));
                    resultSet.close();
                    return student; 
                }
           
            }
            

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return null; 
    }
    public int generarCodigo(){
        UUID uuid = UUID.randomUUID();
        int codigo = uuid.hashCode();
        return codigo; 
    }
    
    


    /*public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        List<Alumno> allStudents = studentManager.getAllStudents();
        allStudents.stream().forEach(i -> System.out.println(i));
        
    }*/
    //getAll
        //select * from Students
    //add
        //insert into alumnos
    //modify
        //update alumnos set ....
    //delete
        // delete alumnos where id_alumno=...
    //getById
        // select * from alumnos where id_alumno=...

    public void delete(String idEliminar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
