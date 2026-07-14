package org.example.dao;

import org.example.config.conexion;
import org.example.modelo.Alumno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlumnoDAO {
    public Alumno buscarAlumno(int expediente) {
        Alumno alumno = null;
        String sql = "SELECT * FROM alumnos WHERE numExpediente = ?";

        try (Connection con = conexion.conectar();
             PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setInt(1, expediente);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    alumno = new Alumno();
                    alumno.setExpediente(rs.getInt("numExpediente"));
                    alumno.setNombre(rs.getString("nombre"));
                    alumno.setCurp(rs.getString("curp"));
                    alumno.setGrupo(rs.getString("grupo"));
                    alumno.setPromedio(rs.getDouble("promedio"));
                }
            }
        } catch (SQLException err) {
            System.out.println("Error al buscar el alumno: " + err.getMessage());
        }
        return alumno;
    }
    public void eliminarAlumno(int expediente) {
        String sql = "DELETE FROM alumnos WHERE numexpediente = ?";
        try (Connection con = conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, expediente);

            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Alumno eliminado con éxito.");
            } else {
                System.out.println("No se encontró ningún alumno");
            }

        } catch (SQLException err) {
            System.out.println("Error al dar de baja en MYSQL: " + err.getMessage());
        }
    }

    public boolean inscribirAlumno(Alumno alumno) {
        boolean inscrito = false;

        String sql = "INSERT INTO alumnos (numExpediente, nombre, curp, promedio, grupo) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = conexion.conectar();
             PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setInt(1, alumno.getExpediente());
            stm.setString(2, alumno.getNombre());
            stm.setString(3, alumno.getCurp());
            stm.setDouble(4, alumno.getPromedio());
            stm.setString(5, alumno.getGrupo());

            int filas = stm.executeUpdate();
            if (filas > 0) {
                inscrito = true;
                System.out.println("El alumno se ha guardado correctamente");
            }

        } catch (SQLException err) {
            System.out.println("Error al inscribir el alumno: " + err.getMessage());
        }

        return inscrito;
    }

    public ArrayList<Alumno> extraerAlumnos() {
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
        String sql = "SELECT * FROM alumnos";

        try (Connection con = conexion.conectar();
             PreparedStatement stm = con.prepareStatement(sql);
             ResultSet rs = stm.executeQuery()) {

            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setExpediente(rs.getInt("numExpediente"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setCurp(rs.getString("curp"));
                alumno.setGrupo(rs.getString("grupo"));
                alumno.setPromedio(rs.getDouble("promedio"));
                alumnos.add(alumno);
            }
        } catch (SQLException err) {
            System.out.println("Error al llamar a los alumnos: " + err.getMessage());
        }
        return alumnos;
    }

    public boolean actualizar(Alumno alumno) {
        boolean actualizado = false;
        String sql = "UPDATE alumnos SET nombre = ?, curp = ?, grupo = ?, promedio = ? WHERE numExpediente = ?";

        try (Connection con = conexion.conectar();
             PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setString(1, alumno.getNombre());
            stm.setString(2, alumno.getCurp());
            stm.setString(3, alumno.getGrupo());
            stm.setDouble(4, alumno.getPromedio());
            stm.setInt(5, alumno.getExpediente());

            int registrosAfectados = stm.executeUpdate();
            if (registrosAfectados > 0) {
                System.out.println("El alumno se ha actualizado con éxito,");
                actualizado = true;
            } else {
                System.out.println("El número de expediente no fue encontrado con éxito");
            }
        } catch (SQLException err) {
            System.out.println("Error al actualizar el alumno: " + err.getMessage());
        }

        return actualizado;
    }
}