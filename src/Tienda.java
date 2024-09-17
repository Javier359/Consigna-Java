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
}
