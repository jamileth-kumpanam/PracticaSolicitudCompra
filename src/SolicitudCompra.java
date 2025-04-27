import java.util.ArrayList;
import java.util.List;

public class SolicitudCompra {
    private String numero;
    private Proveedor proveedor;
    private List<DetalleCompra> detalles;
    private EstadoSolicitud estado;

    public SolicitudCompra(String numero, Proveedor proveedor) {
        this.numero = numero;
        this.proveedor = proveedor;
        this.detalles = new ArrayList<>();
        this.estado = EstadoSolicitud.PENDIENTE;
    }

    public void agregarDetalle(Producto producto, int cantidad) {
        DetalleCompra detalle = new DetalleCompra(producto, cantidad);
        detalles.add(detalle);
    }

    public String getNumero() {
        return numero;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public List<DetalleCompra> getDetalles() {
        return detalles;
    }

    public EstadoSolicitud getEstado() {
        return estado;
    }

    public void cambiarEstado(EstadoSolicitud nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public double calcularTotal() {
        double total = 0;
        for (DetalleCompra detalle : detalles) {
            total += detalle.getProducto().getPrecio() * detalle.getCantidad();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Número: " + numero + ", Proveedor: " + proveedor.getNombre() + ", Estado: " + estado;
    }
}


