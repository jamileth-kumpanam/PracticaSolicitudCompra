// SolicitudCompra.java
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

    // Getters y Setters
    public String getNumeroSolicitud() {
        return numeroSolicitud;
    }

    public void setNumeroSolicitud(String numeroSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public EstadoSolicitud getEstado() {
        return estado;
    }

    public void setEstado(EstadoSolicitud estado) {
        this.estado = estado;
    }

    public List<DetalleCompra> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleCompra> detalles) {
        this.detalles = detalles;
    }

    public Empleado getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Empleado solicitante) {
        this.solicitante = solicitante;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
