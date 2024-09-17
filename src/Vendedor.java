import java.util.ArrayList;
import java.util.List;

public class Vendedor {
    private String codigo;
    private String nombre;
    private double sueldo;
    private List<Venta> ventas;

    public Vendedor(String codigo, String nombre, double sueldo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.ventas = new ArrayList<>();
    }

    //metodos propios del vendedor
    public void agregarVenta(Venta venta){
        ventas.add(venta);
    }

    public double calcularComision() {
        double totalVentas = 0;
        //calculamos el total de ventas
        for (Venta venta : ventas) {
            totalVentas = +venta.getProducto().getPrecio();
        }
        //verificamos que se hicieron mas de 2 ventas
        if(ventas.size() <=2){
            return totalVentas = totalVentas * 0.05;
        }else{
            return totalVentas = totalVentas * 0.10;
        }
    }
    public void mostrarVentas() {
        System.out.println("Ventas del vendedor " + nombre + " (Código: " + codigo + "):");
        for (Venta venta : ventas) {
            Producto producto = venta.getProducto();
            System.out.println("Código del producto: " + producto.getCodigo() + ", Nombre: " + producto.getNombre() + ", Categoría: " + producto.getCategoria() + ", Precio: " + producto.getPrecio());
        }
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
}
