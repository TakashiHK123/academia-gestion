/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.academia.business.service.impl;

import java.util.List;
import py.com.academia.business.entities.Alumno;
import py.com.academia.business.respository.StudentManager;
import java.util.Scanner;
import py.com.academia.business.entities.Curso;
import py.com.academia.business.entities.Materia;
import py.com.academia.business.entities.Profesor;
import py.com.academia.business.respository.CourseManager;
import py.com.academia.business.respository.MateriaManager;
import py.com.academia.business.respository.ProfessorManager;

/**
 *
 * @author takashi
 */
public class Service {

    public void seleccionClase(String OpcionClase, String OpcionMetodo) {
        Service service = new Service();
        switch (OpcionClase) {
            case "1":
                service.seleccionMetodoAlumno(OpcionMetodo);
                break;
            case "2":
                service.seleccionMetodoCurso(OpcionMetodo);
                break;
            case "3":
                service.seleccionMetodoMateria(OpcionMetodo);
                break;
            case "4":
                service.seleccionMetodoProfesor(OpcionMetodo);
                break;
        }
    }

    public void seleccionMetodoAlumno(String OpcionMetodo) {
        StudentManager studentManager = new StudentManager();
        Scanner lectura2 = new Scanner(System.in);
        switch (OpcionMetodo) {
            case "1": //all listar Alumno
                List<Alumno> allStudents = studentManager.getAllStudents();
                System.out.println(allStudents.toString());
                break;

            case "2": //Add Alumno
                System.out.println("Ingrese el:\nNombre: \n");
                String nombreA = lectura2.next();
                System.out.println("Apellido: \n");
                String apellidoA = lectura2.next();
                studentManager.add(nombreA, apellidoA);
                break;
            case "3": //Eliminar Alumno
                System.out.println("Ingrese el ID a eliminar: \n");
                int idEliminar = lectura2.nextInt();
                studentManager.delete(idEliminar);
                break;
            case "4":
                System.out.println("Ingrese el ID a modificar: \n");
                int idModify = lectura2.nextInt();
                System.out.println("Nombre: \n");
                String nombreA4 = lectura2.next();
                System.out.println("Apellido: \n");
                String apellidoA4 = lectura2.next();
                studentManager.modify(idModify, nombreA4, apellidoA4);
                break;
            case "5":
                System.out.println("Ingrese el ID a buscar: \n");
                int idbuscar = lectura2.nextInt();
                Alumno alu = new Alumno();
                alu = studentManager.getByid(idbuscar);
                System.out.println(alu.toString());
                break;
        }
    }

    public void seleccionMetodoProfesor(String OpcionMetodo) {
        ProfessorManager professorManager = new ProfessorManager();
        Scanner lectura2 = new Scanner(System.in);
        switch (OpcionMetodo) {
            case "1": //all lista Professor
                List<Profesor> allProfessor = professorManager.getAllProfessor();
                System.out.println(allProfessor.toString());
                break;

            case "2": //Add Professor
                System.out.println("Ingrese el:\nNombre: \n");
                String nombreA = lectura2.next();
                System.out.println("Apellido: \n");
                String apellidoA = lectura2.next();
                professorManager.add(nombreA, apellidoA);
                break;
            case "3": //Eliminar Profesor
                System.out.println("Ingrese el ID a eliminar: \n");
                int idEliminar = lectura2.nextInt();
                professorManager.delete(idEliminar);
                break;
            case "4": //Modificar
                System.out.println("Ingrese el ID a modificar: \n");
                int idModify = lectura2.nextInt();
                System.out.println("Nombre: \n");
                String nombreA4 = lectura2.next();
                System.out.println("Apellido: \n");
                String apellidoA4 = lectura2.next();
                professorManager.modify(idModify, nombreA4, apellidoA4);
                break;
            case "5": // buscar
                System.out.println("Ingrese el ID a buscar: \n");
                int idbuscar = lectura2.nextInt();
                Profesor profe = new Profesor();
                profe = professorManager.getByid(idbuscar);
                System.out.println(profe.toString());
                break;
        }
    }

    public void seleccionMetodoMateria(String OpcionMetodo) {
        MateriaManager materiaManager = new MateriaManager();
        Scanner lectura2 = new Scanner(System.in);
        switch (OpcionMetodo) {
            case "1": //all lista Materia
                List<Materia> allmateria = materiaManager.getAllMateria();
                System.out.println(allmateria.toString());
                break;

            case "2": //Add Materia
                System.out.println("Ingrese la descripcion de la materia: \n");
                String descricpcion = lectura2.next();
                materiaManager.add(descricpcion);
                break;
            case "3": //Eliminar Materia
                System.out.println("Ingrese el ID a eliminar: \n");
                int idEliminar = lectura2.nextInt();
                materiaManager.delete(idEliminar);
                break;
            case "4": //Modificar
                System.out.println("Ingrese el ID a modificar: \n");
                int idModify = lectura2.nextInt();
                System.out.println("Descripcion: \n");
                String descripcion = lectura2.next();
                materiaManager.modify(idModify, descripcion);
                break;
            case "5": //Buscar
                System.out.println("Ingrese el ID a buscar: \n");
                int idbuscar = lectura2.nextInt();
                Materia materia = new Materia();
                materia = materiaManager.getByid(idbuscar);
                System.out.println(materia.toString());
                break;
        }
    }

    public void seleccionMetodoCurso(String OpcionMetodo) {
        CourseManager courseManager = new CourseManager();
        Scanner lectura2 = new Scanner(System.in);
        switch (OpcionMetodo) {
            case "1": //all lista Curso
                List<Curso> allcurso = courseManager.getAllCurso();
                System.out.println(allcurso.toString());
                break;

            case "2": //Add Curso
                System.out.println("Ingrese la descripcion de la curso: \n");
                String descricpcion = lectura2.next();
                courseManager.add(descricpcion);
                break;
            case "3": //Eliminar Curso
                System.out.println("Ingrese el ID a eliminar: \n");
                int idEliminar = lectura2.nextInt();
                courseManager.delete(idEliminar);
                break;
            case "4": //Modificar
                System.out.println("Ingrese el ID a modificar: \n");
                int idModify = lectura2.nextInt();
                System.out.println("Descripcion: \n");
                String descripcion = lectura2.next();
                courseManager.modify(idModify, descripcion);
                break;
            case "5": //Buscar
                System.out.println("Ingrese el ID a buscar: \n");
                int idbuscar = lectura2.nextInt();
                Curso curso = new Curso();
                curso = courseManager.getByid(idbuscar);
                System.out.println(curso.toString());
                break;
        }
    }

    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        int bucle = 1;
        while (0 != bucle) {
            System.out.println("Ingrese la clase por teclado el numero correspondiente: \n1. Alumno\n2. Curso\n3. Materia\n4. Profesor\n");
            String opcionClase = lectura.next();
            System.out.println("A elegido la opcion: " + opcionClase + "\nIngrese el metodo a utilizar: \n1. Ver lista\n2. Agregar\n3. Eliminar\n4. Modificar\n5. Buscar por id");
            String opcionmetodo = lectura.next();
            Service servicio = new Service();
            servicio.seleccionClase(opcionClase, opcionmetodo);
            System.out.println("Si desea terminar ingrese 0 y si desea continuar cualquier numero distinto de 0");
            bucle = lectura.nextInt();
        }

    }

}
