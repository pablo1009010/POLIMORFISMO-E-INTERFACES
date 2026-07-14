package org.example.modelo;

public class Alumno extends personaUT implements Ensenable, Evaluable {
    private String grupo;
    private double promedio;
    private int expediente;

    public Alumno(){}

    @Override
    public String mostrarTipoPersona() {
        return "---- ALUMNO -----";
    }

    public Alumno(int expediente, String nombre, String curp, double promedio, String grupo) {
        super(nombre, curp);
        setExpediente(expediente);
        setPromedio(promedio);
        setGrupo(grupo);
    }
    @Override
    public void aprender() {
        System.out.println("El alumno está aprendiendo.");
    }

    @Override
    public void recibirEvaluacion() {
        System.out.println("El alumno está recibiendo su evaluación.");
    }

    public String getGrupo() {
        if (grupo == null || grupo.isEmpty() || grupo.isBlank()) {
            System.out.println("Error detectado, el grupo es necesario");
            return "";
        } else {
            return grupo;
        }
    }

    public void setGrupo(String grupo) {
        if (grupo == null || grupo.isEmpty() || grupo.isBlank()) {
            System.out.println("El grupo es requerido");
        } else {
            this.grupo = grupo;
        }
    }

    public double getPromedio() {
        String promedioFormato = String.format(java.util.Locale.US, "%.1f", this.promedio);
        return Double.parseDouble(promedioFormato);
    }

    public void setPromedio(double promedio) {
        if (promedio >= 0 && promedio <= 10) {
            this.promedio = promedio;
        } else {
            System.out.println("Error detectado, el promedio debe ser entre 0 y 10");
        }
    }

    public int getExpediente() {
        return expediente;
    }

    public void setExpediente(int expediente) {
        if (expediente > 2000000000 && expediente < 2140000000) {
            this.expediente = expediente;
        } else {
            System.out.println("Error, Número de expediente no válido");
        }
    }

    @Override
    public String toString(){
        return "Número de expediente: " + getExpediente() + "\n" +
                super.toString() +
                "Grupo: " + getGrupo() + "\n" +
                "Promedio: " + getPromedio() + "\n" +
                "---------------------------------------------\n";
    }
}