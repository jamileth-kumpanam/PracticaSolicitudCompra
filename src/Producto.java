public class Producto implements Estadoable {
    private int id;
    private String nombre;
    private double precio;
    private UnidadMedida unidad;
    private Proveedor proveedor;

    public Producto(int id, String nombre, double precio, UnidadMedida unidad, Proveedor proveedor) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.unidad = unidad;
        this.proveedor = proveedor;
    }

    @Override
    public double calcularCosto() {
        return precio;
    }

    public boolean validar() {
        return nombre != null && !nombre.isEmpty() && precio > 0 && proveedor != null;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public UnidadMedida getUnidad() {
        return unidad;
    }

    public void setUnidad(UnidadMedida unidad) {
        this.unidad = unidad;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}

