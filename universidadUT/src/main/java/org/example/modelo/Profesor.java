package org.example.modelo;
public class Profesor extends personaUT implements Ensenador, Evaluador {
    private int numEmpleado;
    private String puesto;
    private double sueldo;

    public Profesor() {}

    @Override
    public String mostrarTipoPersona() {
        return "------PROFESOR------";
    }

    public Profesor(int numEmpleado, String nombre, String curp, String puesto, double sueldo) {
        super(nombre, curp);
        setNumEmpleado(numEmpleado);
        setPuesto(puesto);
        setSueldo(sueldo);
    }
    @Override
    public void ensenar() {
        System.out.println("El profesor está enseñando.");
    }

    @Override
    public void evaluar() {
        System.out.println("El profesor está evaluando.");
    }

    public int getNumEmpleado() {
        return numEmpleado;
    }


    public void setNumEmpleado(int numEmpleado) {
        if (numEmpleado > 0) {
            this.numEmpleado = numEmpleado;
        } else {
            System.out.println("Error detectado, el número del empleado debe ser mayor a 0.");
        }
    }


    public String getPuesto() {
        if (puesto == null || puesto.isBlank()) {
            System.out.println("Es necesario el puesto.");
            return "";
        }
        return puesto;
    }


    public void setPuesto(String puesto) {
        if (puesto == null || puesto.isBlank()) {
            System.out.println("Error detectado, no puede estar vacío el puesto.");
        } else {
            this.puesto = puesto;
        }
    }


    public double getSueldo() {
        String sueldoFormato = String.format(java.util.Locale.US, "%.2f", this.sueldo);
        return Double.parseDouble(sueldoFormato);
    }



    public void setSueldo(double sueldo) {
        if (sueldo >= 0) {
            this.sueldo = sueldo;
        } else {
            System.out.println("Error detectado, el sueldo no debe ser negativo.");
        }
    }



    @Override
    public String toString() {
        return "Número de Empleado: " + getNumEmpleado() + "\n" +
                super.toString() +
                "Puesto: " + getPuesto() + "\n" +
                "Sueldo: $" + getSueldo() + "\n";
    }
}