import java.util.List;
import java.util.ArrayList;

public class Proveedor extends Persona{
    private List<Producto> productos;

    public Proveedor(String id, String nombre, String telefono, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
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

    public List<Producto> getProductos() {
        return productos;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Teléfono: " + telefono + ", Dirección: " + direccion;
    }
}


