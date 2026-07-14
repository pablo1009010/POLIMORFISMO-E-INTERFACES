package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/universidadut";
    private static final String user = "root";
    private static final String password = "Futbol09";

    public static Connection conectar() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión realizada correctamente");
        } catch (SQLException err) {
            System.out.println("Error al conectar con MYSQL: " + err.getMessage());
        }
        return con;
    }
}