public class Departamento {
    private int id;
    private String nombre;
    private double presupuesto;
    private String responsable;

    public Departamento(int id, String nombre, double presupuesto, String responsable) {
        this.id = id;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.responsable = responsable;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }
}


