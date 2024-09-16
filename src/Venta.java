public class Venta {
    private Producto producto;
    private Vendedor vendedor;

    public Venta(Producto producto, Vendedor vendedor) {
        this.producto = producto;
        this.vendedor = vendedor;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
}
