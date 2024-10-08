import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Agregar producto");
            System.out.println("2. Agregar vendedor");
            System.out.println("3. Registrar venta");
            System.out.println("4. Buscar productos por categoría");
            System.out.println("5. Buscar productos por nombre");
            System.out.println("6. Calcular comisión de vendedor");
            System.out.println("7. Salir");
            System.out.print("Elija una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcion) {
                    case 1:
                        agregarProducto(tienda, sc);
                        break;

                    case 2:
                        agregarVendedor(tienda, sc);
                        break;
                    case 3:
                        registrarVenta(tienda, sc);
                        break;

                    case 4:
                        buscarProductosCategoria(tienda, sc);
                        break;
                    case 5:
                        buscarProductosNombre(tienda, sc);
                        break;
                    case 6:
                        calcularComisionVendedor(tienda,sc);
                        break;
                    case 7:
                        System.out.println("Gracias por usar la aplicacion! vuela pronto :)");
                        return;
                    default:
                        System.out.println("Opción no valida! Intentelo nuevamente.");
                }


            } catch (Exception e) {
                System.out.println("ocurrio un error ianesperado " + e.getMessage());
            }

        }
    }

    //funciones a usar
    private static void agregarProducto(Tienda tienda, Scanner scanner) {
        System.out.println("Ingrese el codigo del producto: ");
        String codigoProducto = scanner.nextLine();
        System.out.println("Ingrese el nombre del producto: ");
        String nombreProducto = scanner.nextLine();
        System.out.println("Ingrese la categoria del producto: ");
        String categoria = scanner.nextLine();
        System.out.println("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();

        Producto producto = new Producto(codigoProducto, nombreProducto, categoria, precio);
        tienda.agregarProducto(producto);
        System.out.println("Producto agregado con exito");
    }

    private static void agregarVendedor(Tienda tienda, Scanner scanner) {
        System.out.println("Ingrese el codigo del vendedor: ");
        String codigoVendedor = scanner.nextLine();
        System.out.println("Ingrese el nombre del vendedor: ");
        String nombreVendedor = scanner.nextLine();
        System.out.println("Ingrese sueldo del vendedor: ");
        double sueldoVendedor = Double.parseDouble(scanner.nextLine());

        Vendedor vendedor = new Vendedor(codigoVendedor, nombreVendedor, sueldoVendedor);
        tienda.agregarVendedor(vendedor);
        System.out.println("Vendedor agregado con exito");
    }

    private static void registrarVenta(Tienda tienda, Scanner scanner) {
        try {
            System.out.println("Porfavor ingresar el codigo del producto: ");
            String codigoProducto = scanner.nextLine();
            System.out.println("Porfavor ingresar el codigo del vendedor: ");
            String codigoVendedor = scanner.nextLine();

            tienda.registrarVenta(codigoProducto, codigoVendedor);
            System.out.println("Venta registrada con exito");
        } catch (Exception e) {
            System.out.println("ocurrio un error ianesperado " + e.getMessage());
        }
    }

    private static void buscarProductosCategoria(Tienda tienda, Scanner scanner) {
        System.out.print("Ingrese la categoría del producto: ");
        String categoria = scanner.nextLine();

        List<Producto> productos = tienda.buscarProductosCategoria(categoria);

        if (productos.isEmpty()) {
            System.out.println("No se encontraron productos en la categoría: " + categoria);
        } else {
            System.out.println("Productos encontrados en la categoría " + categoria + ":");
            for (Producto p : productos) {
                System.out.println("Código: " + p.getCodigo() + ", Nombre: " + p.getNombre() + ", Categoría: " + p.getCategoria());
            }
        }
    }

    private static void buscarProductosNombre(Tienda tienda, Scanner scanner) {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();

        List<Producto> productos = tienda.buscarProductosNombre(nombre);

        if (productos.isEmpty()) {
            System.out.println("No se encontraron productos con el nombre: " + nombre);
        } else {
            System.out.println("Productos encontrados con el nombre " + nombre + ":");
            for (Producto p : productos) {
                System.out.println("Código: " + p.getCodigo() + ", Nombre: " + p.getNombre() + ", Categoría: " + p.getCategoria());
            }
        }

    }
    private static void calcularComisionVendedor(Tienda tienda, Scanner scanner) {
        System.out.print("Ingrese el código del vendedor: ");
        String codigoVendedor = scanner.nextLine();
        tienda.mostrarComisionVendedor(codigoVendedor);
    }

}