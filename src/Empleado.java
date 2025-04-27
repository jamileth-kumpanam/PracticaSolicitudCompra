public class Empleado extends Persona {
    private Departamento departamento;
    private String cargo;

    public Empleado(String nombre, String apellido, String telefono, String direccion, Departamento departamento, String cargo) {
        super(nombre, apellido, telefono, direccion);
        this.departamento = departamento;
        this.cargo = cargo;
    }

    @Override
    public boolean validar() {
        return nombre != null && !nombre.isEmpty() && departamento != null;
    }

    // Getters y Setters
    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}

