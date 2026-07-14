package org.example;

import org.example.vista.Menu;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Menu.menu();
        } catch (IOException e) {
            System.out.println("Error en la ejecución del menú: " + e.getMessage());
        }
    }
}