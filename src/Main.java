import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Tienda tienda = new Tienda();
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\n1. Agregar producto");
            System.out.println("2. Agregar vendedor");
            System.out.println("3. Registrar venta");
            System.out.println("4. Buscar productos por categoría");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine();

            try{
                switch(opcion){
                        case 1:
                        agregarProducto(tienda, sc);
                        break;

                        case 2:
                            agregarVendedor(tienda, sc);
                            break;

                }




            }catch (Exception e){
                System.out.println("ocurrio un error ianesperado " + e.getMessage());
            }

        }
    }
    //funciones a usar
    public static void agregarProducto(Tienda tienda, Scanner scanner){
        System.out.println("Ingrese el codigo del producto: ");
        String codigoProducto = scanner.nextLine();
        System.out.println("Ingrese el nombre del producto: ");
        String nombreProducto = scanner.nextLine();
        System.out.println("Ingrese la categoria del producto: ");
        String categoria = scanner.nextLine();

        Producto producto = new Producto(codigoProducto, nombreProducto, categoria);
        tienda.agregarProducto(producto);
        System.out.println("Producto agregado con exito");
    }

    public static void agregarVendedor(Tienda tienda, Scanner scanner){
        System.out.println("Ingrese el codigo del vendedor: ");
        String codigoVendedor = scanner.nextLine();
        System.out.println("Ingrese el nombre del vendedor: ");
        String nombreVendedor = scanner.nextLine();
        System.out.println("Ingrese sueldo del vendedor: ");
        double sueldoVendedor = Double.parseDouble(scanner.nextLine());

        Vendedor vendedor = new Vendedor(codigoVendedor,nombreVendedor,sueldoVendedor);
        tienda.agregarVendedor(vendedor);
        System.out.println("Vendedor agregado con exito");
    }

}