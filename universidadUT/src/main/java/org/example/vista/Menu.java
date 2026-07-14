package org.example.vista;

import org.example.dao.AlumnoDAO;
import org.example.dao.ProfesorDAO;
import org.example.modelo.Alumno;
import org.example.modelo.Profesor;
import org.example.modelo.personaUT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Menu {
    static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

    static AlumnoDAO alumnoDAO = new AlumnoDAO();
    static ProfesorDAO profesorDAO = new ProfesorDAO();

    public static void inscribir() throws IOException {
        System.out.println("Inscribir alumno");
        Alumno alumno = new Alumno();

        System.out.println("Número de expediente:");
        alumno.setExpediente(Integer.parseInt(leer.readLine()));

        System.out.println("Nombre:");
        alumno.setNombre(leer.readLine());

        System.out.println("Curp:");
        alumno.setCurp(leer.readLine());

        System.out.println("Grupo:");
        alumno.setGrupo(leer.readLine());

        System.out.println("Promedio:");
        alumno.setPromedio(Double.parseDouble(leer.readLine()));

        alumnoDAO.inscribirAlumno(alumno);
    }

    public static void mostrar() {
        ArrayList<Alumno> alumnos = alumnoDAO.extraerAlumnos();
        System.out.println("---------------- Lista de Alumnos-------------");
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }
    }

    public static void actualizar() throws IOException {
        System.out.println("Actualizar alumno");
        Alumno alumno = new Alumno();

        System.out.println("Numero de expediente:");
        alumno.setExpediente(Integer.parseInt(leer.readLine()));

        System.out.println("Nombre:");
        alumno.setNombre(leer.readLine());

        System.out.println("CURP:");
        alumno.setCurp(leer.readLine());

        System.out.println("Grupo:");
        alumno.setGrupo(leer.readLine());

        System.out.println("Promedio:");
        alumno.setPromedio(Double.parseDouble(leer.readLine()));

        alumnoDAO.actualizar(alumno);
    }

    public static void agregarProfesor() throws IOException {
        System.out.println("Agregar un nuevo profesor");
        Profesor profesor = new Profesor();

        System.out.println("Número de empleado:");
        profesor.setNumEmpleado(Integer.parseInt(leer.readLine()));

        System.out.println("Nombre:");
        profesor.setNombre(leer.readLine());

        System.out.println("CURP:");
        profesor.setCurp(leer.readLine());

        System.out.println("Puesto:");
        profesor.setPuesto(leer.readLine());

        System.out.println("Sueldo:");
        profesor.setSueldo(Double.parseDouble(leer.readLine()));

        profesorDAO.agregarProfesor(profesor);
    }

    public static void mostrarProfesores() {
        ArrayList<Profesor> profesores = profesorDAO.extraerProfesores();
        System.out.println("---------------- Lista de Profesores-------------");
        for (Profesor profesor : profesores) {
            System.out.print(profesor);
        }
    }

    public static void darBaja() throws IOException {
        System.out.println("Ingresa el número de expediente del alumno:");
        int expediente = Integer.parseInt(leer.readLine());
        alumnoDAO.eliminarAlumno(expediente);
    }

    public static void buscar() throws IOException {
        System.out.println("Ingresa el número de expediente del alumno :");
        int expediente = Integer.parseInt(leer.readLine());
        Alumno alumno = alumnoDAO.buscarAlumno(expediente);
        if (alumno != null) {
            System.out.println(alumno);
        } else {
            System.out.println("No se encontró ningún alumno");
        }
    }

    public static void actualizarProfesor() throws IOException {
        System.out.println("Actualizar profesor");
        Profesor profesor = new Profesor();

        System.out.println("Número de empleado:");
        profesor.setNumEmpleado(Integer.parseInt(leer.readLine()));

        System.out.println("Nombre:");
        profesor.setNombre(leer.readLine());

        System.out.println("CURP:");
        profesor.setCurp(leer.readLine());

        System.out.println("Puesto:");
        profesor.setPuesto(leer.readLine());

        System.out.println("Sueldo:");
        profesor.setSueldo(Double.parseDouble(leer.readLine()));

        profesorDAO.actualizarProfesor(profesor);
    }

    public static void eliminarProfesor() throws IOException {
        System.out.println("Ingresa el número de empleado del profesor:");
        int numEmpleado = Integer.parseInt(leer.readLine());
        profesorDAO.eliminarProfesor(numEmpleado);
    }

    public static void buscarProfesor() throws IOException {
        System.out.println("Ingresa el numero de empleado del profesor:");
        int numEmpleado = Integer.parseInt(leer.readLine());
        Profesor profesor = profesorDAO.buscarProfesor(numEmpleado);
        if (profesor != null) {
            System.out.print(profesor);
        } else {
            System.out.println("No se encontró ningún profesor");
        }
    }

    public static void mostrarComunidadUniversitaria() {
        ArrayList<personaUT> comunidad = new ArrayList<>();
        comunidad.addAll(alumnoDAO.extraerAlumnos());
        comunidad.addAll(profesorDAO.extraerProfesores());

        System.out.println("------ Comunidad Universitaria ----------");
        for (personaUT persona : comunidad) {
            System.out.println(persona);
        }
    }

    public static void menu() throws IOException {
        int salir = 0;
        while (salir != 12) {
            System.out.println("\n-------- MENÚ MYSQL -------");
            System.out.println("1. Inscribir alumno");
            System.out.println("2. Mostrar a todos los alumnos");
            System.out.println("3. Actualizar un alumno");
            System.out.println("4. Dar de baja un alumno");
            System.out.println("5. Buscar un alumno");
            System.out.println("6. Agregar un nuevo profesor");
            System.out.println("7. Mostrar todos los profesores");
            System.out.println("8. Modificar un profesor");
            System.out.println("9. Dar de baja un profesor");
            System.out.println("10. Buscar un profesor");
            System.out.println("11. Mostrar comunidad universitaria");
            System.out.println("12. Salir");
            System.out.println("Elige una opción:");

            try {
                salir = Integer.parseInt(leer.readLine());
                switch (salir) {
                    case 1: inscribir(); break;
                    case 2: mostrar(); break;
                    case 3: actualizar(); break;
                    case 4: darBaja(); break;
                    case 5: buscar(); break;
                    case 6: agregarProfesor(); break;
                    case 7: mostrarProfesores(); break;
                    case 8: actualizarProfesor(); break;
                    case 9: eliminarProfesor(); break;
                    case 10: buscarProfesor(); break;
                    case 11: mostrarComunidadUniversitaria(); break;
                    case 12:
                        System.out.println("Has salido del menú.");
                        break;
                    default:
                        System.out.println("Opción incorrecta. Intenta de nuevo.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Introduce un número válido.");
                salir = 0;
            }
        }
    }
}