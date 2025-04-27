import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SolicitudCompra implements Calculable {
    private String numeroSolicitud;
    private Date fechaSolicitud;
    private EstadoSolicitud estado;
    private List<DetalleCompra> detalles;
    private Empleado solicitante;
    private Proveedor proveedor;

    public SolicitudCompra() {
        this.detalles = new ArrayList<>();
        this.estado = EstadoSolicitud.SOLICITADA;
    }

    public double calcularTotal() {
        double total = 0;
        for (DetalleCompra detalle : detalles) {
            total += detalle.calcularSubtotal();
        }
        return total;
    }

    @Override
    public void aprobar() {
        this.estado = EstadoSolicitud.APROBADA;
    }

    @Override
    public void rechazar() {
        this.estado = EstadoSolicitud.RECHAZADA;
    }

    @Override
    public void enviarRevision() {
        this.estado = EstadoSolicitud.EN_REVISION;
    }

    public void agregarDetalle(DetalleCompra detalle) {
        detalles.add(detalle);
    }

    public String getNumeroSolicitud() {
        return numeroSolicitud;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public EstadoSolicitud getEstado() {
        return estado;
    }

    public List<DetalleCompra> getDetalles() {
        return detalles;
    }

    public Empleado getSolicitante() {
        return solicitante;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    @Override
    public String toString() {
        return "Solicitud #" + numeroSolicitud + "Estado: " + estado + "Total: $" + calcularTotal();
    }
}
