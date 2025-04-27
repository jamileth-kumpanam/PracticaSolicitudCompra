import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarProveedor();
                    break;
                case 2:
                    registrarProducto();
                    break;
                case 3:
                    registrarSolicitudCompra();
                    break;
                case 4:
                    listarProveedores();
                    break;
                case 5:
                    listarProductos();
                    break;
                case 6:
                    listarSolicitudes();
                    break;
                case 7:
                    buscarProveedorPorID();
                    break;
                case 8:
                    buscarProductoPorNombre();
                    break;
                case 9:
                    buscarSolicitudPorNumero();
                    break;
                case 10:
                    aprobarRechazarSolicitud();
                    break;
                case 11:
                    calcularTotalSolicitud();
                    break;
                case 12:
                    System.out.println("-------Sistema Finalizado-------");
                    break;
                default:
                    System.out.println("Opción inválida...");
            }

        } while (opcion != 12);

        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("===== SISTEMA DE GESTIÓN DE COMPRAS ERP =====");
        System.out.println("1. Registrar proveedor");
        System.out.println("2. Registrar producto");
        System.out.println("3. Registrar solicitud de compra");
        System.out.println("4. Listar proveedores");
        System.out.println("5. Listar productos");
        System.out.println("6. Listar solicitudes de compra");
        System.out.println("7. Buscar proveedor por ID");
        System.out.println("8. Buscar producto por nombre");
        System.out.println("9. Buscar solicitud por número");
        System.out.println("11. Aprobar / Rechazar solicitud de compra");
        System.out.println("12. Calcular total de una solicitud");
        System.out.println("13. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static void registrarProveedor() {
        System.out.println("Registrar proveedor - en construcción.");
    }

    public static void registrarProducto() {
        System.out.println("Registrar producto - en construcción.");
    }

    public static void registrarSolicitudCompra() {
        System.out.println("Registrar solicitud de compra - en construcción.");
    }

    public static void listarProveedores() {
        System.out.println("Listar proveedores - en construcción.");
    }

    public static void listarProductos() {
        System.out.println("Listar productos - en construcción.");
    }

    public static void listarSolicitudes() {
        System.out.println("Listar solicitudes de compra - en construcción.");
    }

    public static void buscarProveedorPorID( {
        System.out.println("Buscar proveedor por ID - en construcción.");
    }

    public static void buscarProductoPorNombre() {
        System.out.println("Buscar producto por nombre - en construcción.");
    }

    public static void buscarSolicitudPorNumero() {
        System.out.println("Buscar solicitud por número - en construcción.");
    }

    public static void aprobarRechazarSolicitud() {
        System.out.println("Aprobar/Rechazar solicitud de compra - en construcción.");
    }

    public static void calcularTotalSolicitud() {
        System.out.println("Calcular total de una solicitud - en construcción.");
    }

}
