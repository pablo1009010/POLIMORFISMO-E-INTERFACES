package org.example.modelo;

public abstract class personaUT {
    private String nombre;
    private String curp;

    public personaUT() {
    }

    public personaUT(String nombre, String curp) {
        setNombre(nombre);
        setCurp(curp);
    }

    public String getNombre() {
        return nombre != null ? nombre.toUpperCase() : "";
    }

    public String getCurp() {
        return curp != null ? curp.toUpperCase() : "";
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty() || nombre.isBlank()) {
            System.out.println("Error: el nombre es requerido");
        } else {
            this.nombre = nombre;
        }
    }

    public void setCurp(String curp) {
        if (curp == null || curp.isEmpty() || curp.isBlank()) {
            System.out.println("Error: el CURP es requerido");
        } else {
            this.curp = curp;
        }
    }
    public abstract String mostrarTipoPersona();

    @Override
    public String toString(){
        return "Nombre: " + getNombre() + "\n" +
                "Curp: " + getCurp() + "\n";
    }

}