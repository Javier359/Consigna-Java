import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private List<Producto> productos;
    private List<Vendedor> vendedores;

    public Tienda() {
        productos = new ArrayList<>();
        vendedores = new ArrayList<>();
    }

    //metodos propios de logica de relacion de productos con vendedores
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }
    public void agregarVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
    }

    public void registrarVenta(String codigoProducto, String codigoVendedor) throws Exception {

        Producto producto = null;
        Vendedor vendedor = null;
        //buscamos producto
        for(Producto p : productos) {
            if(p.getCodigo().equals(codigoProducto)) {
                producto = p;
                break;
            }
        }
        //buscamos vendedor
        for(Vendedor v : vendedores){
            if(v.getCodigo().equals(codigoVendedor)){
                vendedor = v;
                break;
            }
        }
        if(producto == null || vendedor == null){
            throw new Exception("No existe un producto o vendedor con dicho codigo");
        }
        Venta venta = new Venta(producto, vendedor);
        vendedor.agregarVenta(venta);
    }

    //filtrar por categoria
    public List<Producto> buscarProductosCategoria(String categoria) {
        List<Producto> productosEncontrados = new ArrayList<>();
        for(Producto producto : productos) {
            if(producto.getCategoria() != null && producto.getCategoria().equalsIgnoreCase(categoria)){
                productosEncontrados.add(producto);
            }
        }
        return productosEncontrados;
    }
    //filtrar por nombre
    public List<Producto> buscarProductosNombre(String nombreProducto){
        List<Producto> productosEncontrados = new ArrayList<>();
        for(Producto producto : productos){
            if(producto.getNombre() !=null && producto.getNombre().equalsIgnoreCase(nombreProducto)){
                productosEncontrados.add(producto);
            }
        }
        return productosEncontrados;
    }

    //buscamos al vendedor
    public Vendedor buscarVendedor(String codigo) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getCodigo() != null && vendedor.getCodigo().equals(codigo)) {
                return vendedor;
            }
        }
        return null;
    }

    public void mostrarComisionVendedor(String codigoVendedor) {
        Vendedor vendedor = buscarVendedor(codigoVendedor);

        if (vendedor == null) {
            System.out.println("Vendedor no encontrado.");
            return;
        }

        // Mostrar ventas y comisión
        vendedor.mostrarVentas();
        double comision = vendedor.calcularComision();
        System.out.println("Comisión ganada por el vendedor: " + comision);
    }
}
