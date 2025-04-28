public class Empleado extends Persona{
    private Departamento departamento;
    private String cargo;

    public Empleado(String id, String nombre, String telefono, String direccion, Departamento departamento, String cargo) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.departamento = departamento;
        this.cargo = cargo;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return nombre + " (" + id + ") - " + cargo + " en " + departamento.getNombre();
    }
}


