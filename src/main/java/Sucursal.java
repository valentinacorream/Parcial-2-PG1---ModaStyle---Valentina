import java.util.ArrayList;
import java.util.List;

public class Sucursal {
    private String codigo;
    private String nombre;
    private String direccion;
    private String ciudad;

    //Listas
    private List<Inventario> listaInventarios;
    private List<Vendedor> listaVendedores;
    private List<Venta> listaVentas;

    public Sucursal(String codigo, String nombre, String direccion, String ciudad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;

        listaInventarios= new ArrayList<>();
        listaVendedores= new ArrayList<>();
        listaVentas= new ArrayList<>();
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<Inventario> getListaInventarios() {
        return listaInventarios;
    }

    public void setListaInventarios(List<Inventario> listaInventarios) {
        this.listaInventarios = listaInventarios;
    }

    public List<Vendedor> getListaVendedores() {
        return listaVendedores;
    }

    public void setListaVendedores(List<Vendedor> listaVendedores) {
        this.listaVendedores = listaVendedores;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    @Override
    public String toString() {
        return "Sucursal" +
                "\nCódigo: " + codigo+
                ", Nombre: " + nombre +
                ", Dirección: " + direccion +
                ", Ciudad: " + ciudad+
                ", Lista inventarios: "+listaInventarios+
                ", Lista vendedores: "+listaVendedores+
                ", Lista ventas: "+listaVentas;
    }

    //Verificar inventario
    public boolean verificarInventario(Inventario inventario) {
        boolean existe = false;
        for (Inventario inv : listaInventarios) {
            if (inv.getPrenda().getCodigo().equalsIgnoreCase(inventario.getPrenda().getCodigo()) && inv.getTalla().mostrarTalla().equalsIgnoreCase(inventario.getTalla().mostrarTalla()) && inv.getColor().equalsIgnoreCase(inventario.getColor())) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    //Agregar inventario
    public boolean agregarInventario(Inventario inventario) {
        boolean agregado = false;
        for (Inventario inv : listaInventarios) {
            if (inv.getPrenda().getCodigo().equalsIgnoreCase(inventario.getPrenda().getCodigo()) && inv.getTalla().mostrarTalla().equalsIgnoreCase(inventario.getTalla().mostrarTalla()) && inv.getColor().equalsIgnoreCase(inventario.getColor())) {
                inv.agregarExistencias(inventario.getCantidadDisponible());
                agregado = true;
                break;
            }
        }
        if (agregado == false) {
            listaInventarios.add(inventario);
            agregado = true;
        }
        return agregado;
    }

    //Buscar inventario
    public boolean buscarInventario(Prenda prendaBuscada, Talla tallaBuscada, String colorBuscado) {
        boolean encontrado = false;
        for (Inventario inventario : listaInventarios) {
            if (inventario.getPrenda().getCodigo().equalsIgnoreCase(prendaBuscada.getCodigo()) && inventario.getTalla().mostrarTalla().equalsIgnoreCase(tallaBuscada.mostrarTalla()) && inventario.getColor().equalsIgnoreCase(colorBuscado)) {
                System.out.println(inventario);
                encontrado = true;
                break;
            }
        }
        if (encontrado == false) {
            System.out.println("El inventario no existe");
        }
        return encontrado;
    }

    //Verificar stock
    public boolean verificarStock(Prenda prendaBuscada, Talla tallaBuscada, String colorBuscado, int cantidad) {
        boolean disponible = false;
        for (Inventario inventario : listaInventarios) {
            if (inventario.getPrenda().getCodigo().equalsIgnoreCase(prendaBuscada.getCodigo()) && inventario.getTalla().mostrarTalla().equalsIgnoreCase(tallaBuscada.mostrarTalla()) && inventario.getColor().equalsIgnoreCase(colorBuscado)) {
                disponible = inventario.verificarExistencias(cantidad);
                break;
            }
        }

        return disponible;
    }

    //Descontar stock
    public boolean descontarStock(Prenda prendaBuscada, Talla tallaBuscada, String colorBuscado, int cantidad) {
        boolean descontado = false;
        for (Inventario inventario : listaInventarios) {
            if (inventario.getPrenda().getCodigo().equalsIgnoreCase(prendaBuscada.getCodigo()) && inventario.getTalla().mostrarTalla().equalsIgnoreCase(tallaBuscada.mostrarTalla()) && inventario.getColor().equalsIgnoreCase(colorBuscado)) {
                descontado = inventario.descontarExistencias(cantidad);
                break;
            }
        }

        return descontado;
    }

    //Verificar Venta
    public boolean verificarVenta(String codigo) {
        boolean existe = false;
        for (Venta venta : listaVentas) {
            if (venta.getCodigo().equalsIgnoreCase(codigo)) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    //Agregar Venta
    public boolean agregarVenta(Venta venta) {
        boolean agregado = false;
        boolean existe = verificarVenta(venta.getCodigo());
        if (existe== false){
            listaVentas.add(venta);
            agregado= true;
        }
        return agregado;
    }

    //Registrar venta
    public boolean registrarVenta(Venta venta, int documentoCliente, int documentoVendedor, List<Cliente> listaClientes) {
        boolean registrada = false;
        for (Cliente cliente : listaClientes) {
            if (cliente.getDocumento() == documentoCliente) {
                for (Vendedor vendedor : listaVendedores) {
                    if (vendedor.getDocumento() == documentoVendedor) {
                        venta.setCliente(cliente);
                        venta.setVendedor(vendedor);
                        venta.setSucursal(this);
                        if (agregarVenta(venta)) {
                            cliente.getListaVentas().add(venta);
                            vendedor.getListaVentas().add(venta);
                            registrada = true;
                        }
                        break;
                    }
                }
                break;
            }
        }
        return registrada;
    }

    //Registrar detalleventa
    public boolean registrarDetalleVenta(Venta venta, Prenda prendaBuscada, Talla tallaBuscada, String colorBuscado, int cantidad) {
        boolean registrado = false;
        for (Inventario inventario : listaInventarios) {
            if (inventario.getPrenda().getCodigo().equalsIgnoreCase(prendaBuscada.getCodigo()) && inventario.getTalla().mostrarTalla().equalsIgnoreCase(tallaBuscada.mostrarTalla()) && inventario.getColor().equalsIgnoreCase(colorBuscado)) {
                if (verificarStock(prendaBuscada, tallaBuscada, colorBuscado, cantidad)) {
                    DetalleVenta detalle = new DetalleVenta(cantidad, 0, 0, inventario);
                    detalle.calcularPrecioFinal(prendaBuscada, venta.getCliente());
                    detalle.calcularSubtotal();
                    if (venta.agregarDetalleVenta(detalle)) {
                        descontarStock(prendaBuscada, tallaBuscada, colorBuscado, cantidad);
                        registrado = true;
                    }
                }
                break;
            }
        }
        return registrado;
    }

    //Buscar venta
    public boolean buscarVenta(String codigo) {
        boolean encontrado = false;
        for (Venta venta : listaVentas) {
            if (venta.getCodigo().equalsIgnoreCase(codigo)) {
                System.out.println(venta);
                encontrado = true;
                break;
            }
        }
        if (encontrado == false) {
            System.out.println("La venta no existe");
        }
        return encontrado;
    }

    // Verificar Vendedor
    public boolean verificarVendedor(int documento) {
        boolean existe = false;
        for (Vendedor vendedor : listaVendedores) {
            if (vendedor.getDocumento() == documento) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    // Agregar Vendedor
    public boolean agregarVendedor(Vendedor vendedor) {
        boolean agregado = false;
        boolean existe = verificarVendedor(vendedor.getDocumento());
        if (existe == false) {
            listaVendedores.add(vendedor);
            vendedor.setSucursal(this);
            agregado = true;
        }
        return agregado;
    }

    // Buscar Vendedor
    public boolean buscarVendedor(int documento) {
        boolean encontrado = false;
        for (Vendedor vendedor : listaVendedores) {
            if (vendedor.getDocumento() == documento) {
                System.out.println(vendedor.mostrarDatos());
                encontrado = true;
                break;
            }
        }
        if (encontrado == false) {
            System.out.println("El vendedor no existe.");
        }
        return encontrado;
    }
}
