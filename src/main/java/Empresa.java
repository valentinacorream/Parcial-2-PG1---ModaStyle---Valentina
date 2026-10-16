import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nombre;
    private String nit;
    private String direccion;

    //Listas
    private List<Sucursal> listaSucursales;
    private List<Cliente> listaClientes;
    private List<Prenda> listaPrendas;

    public Empresa(String nombre, String nit, String direccion) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;

        listaSucursales = new ArrayList<>();
        listaClientes= new ArrayList<>();
        listaPrendas= new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Sucursal> getListaSucursales() {
        return listaSucursales;
    }

    public void setListaSucursales(List<Sucursal> listaSucursales) {
        this.listaSucursales = listaSucursales;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Prenda> getListaPrendas() {
        return listaPrendas;
    }

    public void setListaPrendas(List<Prenda> listaPrendas) {
        this.listaPrendas = listaPrendas;
    }

    @Override
    public String toString() {
        return "Empresa" +
                "\nNombre: " + nombre +
                ", NIT: " + nit +
                ", Dirección: " + direccion+
                ", Lista Sucursales: "+listaSucursales+
                ", Lista Clientes: "+listaClientes+
                ", Lista Prendas: "+listaPrendas;
    }

    //Verificar Sucursal
    public boolean verificarSucursales(String codigo){
        boolean existe= false;
        for (Sucursal sucursal: listaSucursales){
            if (sucursal.getCodigo().equalsIgnoreCase(codigo)){
                existe= true;
                break;
            }
        }
        return existe;
    }

    //Agregar Sucursal
    public boolean agregarSucursal(Sucursal sucursal){
        boolean agregado= false;
        boolean existe= verificarSucursales(sucursal.getCodigo());
        if (existe==false){
            listaSucursales.add(sucursal);
            agregado= true;
        }
        return agregado;
    }

    //Consultar Sucursal
    public boolean buscarSucursal(String codigo){
        boolean encontrado= false;
        for (Sucursal sucursal: listaSucursales){
            if (sucursal.getCodigo().equalsIgnoreCase(codigo)){
                System.out.println(sucursal);
                encontrado= true;
                break;
            }
        }
        if (encontrado== false){
            System.out.println("La sucursal no existe");
        }
        return encontrado;
    }

    //Verificar Prenda
    public boolean verificarPrenda(String codigo) {
        boolean existe = false;
        for (Prenda prenda : listaPrendas) {
            if (prenda.getCodigo().equalsIgnoreCase(codigo)) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    //Agregar prenda
    public boolean agregarPrenda(Prenda prenda) {
        boolean agregado = false;
        boolean existe = verificarPrenda(prenda.getCodigo());
        if (existe == false) {
            listaPrendas.add(prenda);
            agregado = true;
        }
        return agregado;
    }

    //Buscar Prenda
    public boolean buscarPrenda(String codigo) {
        boolean encontrado = false;
        for (Prenda prenda : listaPrendas) {
            if (prenda.getCodigo().equalsIgnoreCase(codigo)) {
                System.out.println(prenda);
                encontrado = true;
                break;
            }
        }
        if (encontrado == false) {
            System.out.println("La prenda no existe");
        }
        return encontrado;
    }

    //Verificar Cliente
    public boolean verificarCliente(int documento) {
        boolean existe = false;
        for (Cliente cliente : listaClientes) {
            if (cliente.getDocumento() == documento) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    //Agregar Cliente
    public boolean agregarCliente(Cliente cliente) {
        boolean agregado = false;
        boolean existe = verificarCliente(cliente.getDocumento());
        if (existe == false) {
            listaClientes.add(cliente);
            agregado = true;
        }
        return agregado;
    }

    // Buscar Cliente
    public boolean buscarCliente(int documento) {
        boolean encontrado = false;
        for (Cliente cliente : listaClientes) {
            if (cliente.getDocumento() == documento) {
                System.out.println(cliente.mostrarDatos());
                encontrado = true;
                break;
            }
        }
        if (encontrado == false) {
            System.out.println("El cliente no existe.");
        }
        return encontrado;
    }

}

