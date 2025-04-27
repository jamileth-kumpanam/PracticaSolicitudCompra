import java.util.ArrayList;
import java.util.List;

public class Proveedor extends Persona {
    private List<Producto> productos;

    public Proveedor(String nombre, String apellido, String telefono, String direccion) {
        super(nombre, apellido, telefono, direccion);
        this.productos = new ArrayList<>();
    }

    @Override
    public boolean validar() {
        return nombre != null && !nombre.isEmpty() && productos != null;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    // Getters y Setters
    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
