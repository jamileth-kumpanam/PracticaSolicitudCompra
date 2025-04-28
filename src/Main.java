import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Proveedor> proveedores = new ArrayList<>();
    private static List<Producto> productos = new ArrayList<>();
    private static List<SolicitudCompra> solicitudes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int nextSolicitudId = 1;

    public static void main(String[] args) {

        while (true) {
            mostrarMenuPrincipal();
            int opcion = leerEntero("Seleccione una opción: ");

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
                {
                    String id = leerCadena("Ingrese el ID del proveedor: ");
                        buscarProveedorPorId(id);
                    }
                case 8:
                {
                    String nombre = leerCadena("Ingrese el nombre del producto: ");
                    buscarProductoPorNombre(nombre);
                }
               case 9:
               {
                    String numero = leerCadena("Ingrese el número de solicitud: ");
                    buscarSolicitudPorNumero(numero);
                    }
                case 10:
                    cambiarEstadoSolicitud();
                    break;
                case 11:
                    calcularTotalSolicitud();
                    break;
                case 12:
                    salir();
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private static SolicitudCompra buscarSolicitud(String numero) {
        for (SolicitudCompra solicitud : solicitudes) {
            if (solicitud.getNumero().equalsIgnoreCase(numero)) {
                return solicitud;
            }
        }
        return null;
    }

    private static Producto buscarProductoPorNombre(String id) {
        for (Producto producto : productos) {
            if (producto.getId().equalsIgnoreCase(id)) {
                return producto;
            }
        }
        return null;
    }

    private static Proveedor buscarProveedorPorId(String id) {
        for (Proveedor proveedor : proveedores) {
            if (proveedor.getId().equalsIgnoreCase(id)) {
                return proveedor;
            }
        }
        return null;
    }


    private static void mostrarMenuPrincipal() {
        System.out.println("*****SISTEMA DE GESTIÓN DE COMPRAS ERP ****");
        System.out.println("1. Registrar proveedor");
        System.out.println("2. Registrar producto");
        System.out.println("3. Registrar solicitud de compra");
        System.out.println("4. Listar proveedores");
        System.out.println("5. Listar productos");
        System.out.println("6. Listar solicitudes de compra");
        System.out.println("7. Buscar proveedor por ID");
        System.out.println("8. Buscar producto por nombre");
        System.out.println("9. Buscar solicitud por número");
        System.out.println("10. Aprobar / Rechazar solicitud de compra");
        System.out.println("11. Calcular total de una solicitud");
        System.out.println("12. Salir");
    }
    public static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada inválida. Ingrese un número entero: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static String leerCadena(String mensaje) {
        System.out.print(mensaje);
        scanner.nextLine();
        return scanner.nextLine();
    }



    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    private static double leerDecimal(String mensaje) {
        double numero = -1;
        while (numero == -1) {
            try {
                System.out.print(mensaje);
                numero = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un número decimal válido.");
            }
        }
        return numero;
    }

    private static void registrarProveedor() {
        System.out.println("\n=== REGISTRAR PROVEEDOR ===");
        String id = leerTexto("ID: ");
        String nombre = leerTexto("Nombre: ");
        String telefono = leerTexto("Teléfono: ");
        String direccion = leerTexto("Dirección: ");

        Proveedor proveedor = new Proveedor(id, nombre, telefono, direccion);
        proveedores.add(proveedor);
        System.out.println("Proveedor registrado exitosamente!");
    }

    private static void registrarProducto() {
        System.out.println("=== REGISTRAR PRODUCTO ===");
        if (proveedores.size() == 0) {
            System.out.println("No hay proveedores registrados");
            return;
        }

        String id = leerTexto("ID: ");
        String nombre = leerTexto("Nombre: ");
        double precio = leerDecimal("Precio: ");

        System.out.println("Unidades de medida disponibles:");
        for (UnidadMedida um : UnidadMedida.values()) {
            System.out.println("- " + um);
        }

        String unidadStr = leerTexto("Unidad de medida: ");
        UnidadMedida unidad = UnidadMedida.valueOf(unidadStr.toUpperCase());

        listarProveedores();
        String idProv = leerTexto("ID del proveedor: ");
        Proveedor proveedor = buscarProveedor(idProv);

        if (proveedor == null) {
            System.out.println("Proveedor no encontrado");
            return;
        }

        Producto producto = new Producto(id, nombre, precio, unidad, proveedor);
        productos.add(producto);
        proveedor.agregarProducto(producto);

        System.out.println("Producto registrado exitosamente!");
    }

    private static void registrarSolicitudCompra() {
        System.out.println("=== REGISTRAR SOLICITUD DE COMPRA ===");
        if (proveedores.size() == 0 || productos.size() == 0) {
            System.out.println("Se requiere tener proveedores y productos registrados");
            return;
        }

        listarProveedores();
        String idProv = leerTexto("ID del proveedor: ");
        Proveedor proveedor = buscarProveedor(idProv);

        if (proveedor == null) {
            System.out.println("Proveedor no encontrado");
            return;
        }

        String numSolicitud = "SOLICITUD-" + String.format("%04d", nextSolicitudId++);
        SolicitudCompra solicitud = new SolicitudCompra(numSolicitud, proveedor);

        int cantidadProductos = leerEntero("Cantidad de productos a solicitar: ");
        for (int i = 0; i < cantidadProductos; i++) {
            listarProductos();
            String idProd = leerTexto("ID del producto: ");
            Producto producto = buscarProducto(idProd);

            if (producto == null) {
                System.out.println("Producto no encontrado");
                i--;
                continue;
            }

            int cantidad = leerEntero("Cantidad: ");
            solicitud.agregarDetalle(producto, cantidad);
        }

        solicitudes.add(solicitud);
        System.out.println("Solicitud registrada exitosamente!");
    }

    private static void listarProveedores() {
        if (proveedores.size() == 0) {
            System.out.println("No hay proveedores registrados");
            return;
        }
        for (Proveedor prov : proveedores) {
            System.out.println("- " + prov);
        }
    }

    private static void listarProductos() {
        if (productos.size() == 0) {
            System.out.println("No hay productos registrados");
            return;
        }
        for (Producto prod : productos) {
            System.out.println("- " + prod);
        }
    }

    private static void listarSolicitudes() {
        if (solicitudes.size() == 0) {
            System.out.println("No hay solicitudes registradas");
            return;
        }
        for (SolicitudCompra solicitud : solicitudes) {
            System.out.println(solicitud);
        }
    }

    private static Proveedor buscarProveedor(String id) {
        for (Proveedor proveedor : proveedores) {
            if (proveedor.getId().equals(id)) {
                return proveedor;
            }
        }
        return null;
    }

    private static Producto buscarProducto(String id) {
        for (Producto producto : productos) {
            if (producto.getId().equals(id)) {
                return producto;
            }
        }
        return null;
    }

    private static SolicitudCompra buscarSolicitudPorNumero(String numero) {
        for (SolicitudCompra solicitud : solicitudes) {
            if (solicitud.getNumero().equals(numero)) {
                return solicitud;
            }
        }
        return null;
    }

    private static void cambiarEstadoSolicitud() {
        String numero = leerTexto("Ingrese el número de la solicitud: ");
        SolicitudCompra solicitud = buscarSolicitudPorNumero(numero);
        if (solicitud == null) {
            System.out.println("Solicitud no encontrada.");
            return;
        }

        System.out.println("Estado actual: " + solicitud.getEstado());
        System.out.println("Seleccione el nuevo estado:");
        System.out.println("1. PENDIENTE");
        System.out.println("2. APROBADA");
        System.out.println("3. RECHAZADA");

        int opcion = leerEntero("Opción: ");
        switch (opcion) {
            case 1:
                solicitud.cambiarEstado(EstadoSolicitud.PENDIENTE);
                break;
            case 2:
                solicitud.cambiarEstado(EstadoSolicitud.APROBADA);
                break;
            case 3:
                solicitud.cambiarEstado(EstadoSolicitud.RECHAZADA);
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    private static void calcularTotalSolicitud() {
        String numero = leerTexto("Ingrese el número de la solicitud: ");
        SolicitudCompra solicitud = buscarSolicitudPorNumero(numero);
        if (solicitud == null) {
            System.out.println("Solicitud no encontrada.");
            return;
        }

        double total = solicitud.calcularTotal();
        System.out.println("El total de la solicitud es: " + total);
    }

    private static void salir() {
        System.out.println("Saliendo del sistema...");
        System.exit(0);
    }
}




