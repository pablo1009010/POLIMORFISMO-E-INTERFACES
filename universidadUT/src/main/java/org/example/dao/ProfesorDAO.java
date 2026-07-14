package org.example.dao;

import org.example.config.conexion;
import org.example.modelo.Profesor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProfesorDAO {
    public Profesor buscarProfesor(int numEmpleado) {
        Profesor profesor = null;
        String sql = "SELECT * FROM maestros WHERE numEmpleado = ?";

        try (Connection con = conexion.conectar();
             PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setInt(1, numEmpleado);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    profesor = new Profesor();
                    profesor.setNumEmpleado(rs.getInt("numEmpleado"));
                    profesor.setNombre(rs.getString("nombre"));
                    profesor.setCurp(rs.getString("curp"));
                    profesor.setPuesto(rs.getString("puesto"));
                    profesor.setSueldo(rs.getDouble("sueldo"));
                }
            }
        } catch (SQLException err) {
            System.out.println("Error al buscar al profesor: " + err.getMessage());
        }
        return profesor;
    }

    public void actualizarProfesor(Profesor profesor) {
        String sql = "UPDATE maestros SET nombre = ?, curp = ?, puesto = ?, sueldo = ? WHERE numEmpleado = ?";
        try (Connection con = conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, profesor.getNombre());
            ps.setString(2, profesor.getCurp());
            ps.setString(3, profesor.getPuesto());
            ps.setDouble(4, profesor.getSueldo());
            ps.setInt(5, profesor.getNumEmpleado());

            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Profesor modificado con exito.");
            } else {
                System.out.println("No se encontró ningún profesor con ese número de empleado.");
            }

        } catch (SQLException err) {
            System.out.println("Error al modificar en MYSQL: " + err.getMessage());
        }
    }

    public boolean agregarProfesor(Profesor profesor) {
        boolean insertado = false;
        String sql = "INSERT INTO maestros (numEmpleado, nombre, curp, puesto, sueldo) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = conexion.conectar();
             PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setInt(1, profesor.getNumEmpleado());
            stm.setString(2, profesor.getNombre());
            stm.setString(3, profesor.getCurp());
            stm.setString(4, profesor.getPuesto());
            stm.setDouble(5, profesor.getSueldo());

            int filas = stm.executeUpdate();
            if (filas > 0) {
                insertado = true;
                System.out.println("El nuevo profesor se ha agregado con éxito");
            }

        } catch (SQLException err) {
            System.out.println("Error al agregar el profesor: " + err.getMessage());
        }

        return insertado;
    }

    public ArrayList<Profesor> extraerProfesores() {
        ArrayList<Profesor> profesores = new ArrayList<Profesor>();
        String sql = "SELECT * FROM maestros";

        try (Connection con = conexion.conectar();
             PreparedStatement stm = con.prepareStatement(sql);
             ResultSet rs = stm.executeQuery()) {

            while (rs.next()) {
                Profesor profesor = new Profesor();
                profesor.setNumEmpleado(rs.getInt("numEmpleado"));
                profesor.setNombre(rs.getString("nombre"));
                profesor.setCurp(rs.getString("curp"));
                profesor.setPuesto(rs.getString("puesto"));
                profesor.setSueldo(rs.getDouble("sueldo"));
                profesores.add(profesor);
            }
        } catch (SQLException err) {
            System.out.println("Error al extraer a los profesores: " + err.getMessage());
        }
        return profesores;
    }
    public void eliminarProfesor(int numEmpleado) {
        String sql = "DELETE FROM maestros WHERE numEmpleado = ?";
        try (Connection con = conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, numEmpleado);

            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Profesor eliminado con éxito.");
            } else {
                System.out.println("No se encontró ningún profesor");
            }

        } catch (SQLException err) {
            System.out.println("Error al dar de baja en MYSQL: " + err.getMessage());
        }
    }
}