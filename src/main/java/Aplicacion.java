import java.time.LocalDate;
import java.util.Scanner;

public class Aplicacion {
    static void main() {
        Scanner sc= new Scanner(System.in);

        Empresa empresa= new Empresa("ModaStyle", "98765", "Carrea 19 Armenia");

        int opcion;

        do {
            System.out.println("\n========== MODASTYLE ==========");
            System.out.println("1. Agregar sucursal");
            System.out.println("2. Consultar sucursal");
            System.out.println("3. Registrar prenda");
            System.out.println("4. Consultar prenda");
            System.out.println("5. Registrar inventario");
            System.out.println("6. Consultar inventario");
            System.out.println("7. Consultar inventario agotado");
            System.out.println("8. Registrar cliente");
            System.out.println("9. Consultar cliente");
            System.out.println("10. Registrar vendedor");
            System.out.println("11. Consultar vendedor");
            System.out.println("12. Registrar venta");
            System.out.println("13. Consultar venta");
            System.out.println("14. Consultar ventas por vendedor");
            System.out.println("15. Consultar compras por cliente");
            System.out.println("16. Consultar ingresos por sucursal");
            System.out.println("17. Consultar prenda más vendida");
            System.out.println("0. Salir");

            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.println("\n---- Agregar sucursal ----");

                    System.out.println("Código: ");
                    String codigo= sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Dirección: ");
                    String direccion = sc.nextLine();

                    System.out.print("Ciudad: ");
                    String ciudad = sc.nextLine();

                    Sucursal sucursal= new Sucursal(codigo, nombre, direccion, ciudad);

                    if (empresa.agregarSucursal(sucursal)) {
                        System.out.println("La sucursal ha sido agregada correctamente.");
                    } else {
                        System.out.println("La sucursal ya existe.");
                    }
                    break;

                case 2:
                    System.out.println("\n---- Consultar sucursal ----");

                    System.out.print("Ingrese el código de la sucursal: ");
                    String codigoBuscar = sc.nextLine();

                    empresa.buscarSucursal(codigoBuscar);
                    break;

                case 3:
                    System.out.println("\n---- Registrar prenda ----");

                    System.out.print("Código: ");
                    String codigoPrenda = sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombrePrenda = sc.nextLine();

                    System.out.print("Marca: ");
                    String marca = sc.nextLine();

                    System.out.print("Precio unitario: ");
                    double precio = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("\nSeleccione la categoría:");
                    System.out.println("1. Camiseta");
                    System.out.println("2. Pantalón");
                    System.out.println("3. Vestido");
                    System.out.println("4. Chaqueta");
                    System.out.println("5. Calzado");
                    System.out.print("Opción: ");

                    int opcionCategoria = sc.nextInt();
                    sc.nextLine();

                    boolean categoriaValida = true;
                    CategoriaPrenda categoria = CategoriaPrenda.CAMISETA;

                    switch (opcionCategoria) {
                        case 1:
                            categoria = CategoriaPrenda.CAMISETA;
                            break;

                        case 2:
                            categoria = CategoriaPrenda.PANTALON;
                            break;

                        case 3:
                            categoria = CategoriaPrenda.VESTIDO;
                            break;

                        case 4:
                            categoria = CategoriaPrenda.CHAQUETA;
                            break;

                        case 5:
                            categoria = CategoriaPrenda.CALZADO;
                            break;

                        default:
                            categoriaValida = false;
                            System.out.println("Categoría no válida.");
                            break;
                    }

                    if (categoriaValida == true) {
                        Prenda prenda = new Prenda(codigoPrenda, nombrePrenda, marca,precio, categoria);

                        if (empresa.agregarPrenda(prenda)) {
                            System.out.println("La prenda ha sido agregada correctamente.");
                        } else {
                            System.out.println("La prenda ya existe.");
                        }
                    }

                    break;

                case 4:
                    System.out.println("\n---- Consultar prenda ----");

                    System.out.print("Ingrese el código de la prenda: ");
                    String codigoBuscarPrenda = sc.nextLine();

                    empresa.buscarPrenda(codigoBuscarPrenda);

                    break;

                case 5:
                    System.out.println("\n---- Registrar inventario ----");

                    System.out.print("Código de la sucursal: ");
                    String codigoSucursalInv = sc.nextLine();

                    System.out.print("Código de la prenda: ");
                    String codigoPrendaInv = sc.nextLine();

                    boolean sucursalEncontrada = false;
                    boolean prendaEncontrada = false;

                    for (Sucursal sucursalActual : empresa.getListaSucursales()) {
                        if (sucursalActual.getCodigo().equalsIgnoreCase(codigoSucursalInv)) {
                            sucursalEncontrada = true;

                            for (Prenda prendaActual : empresa.getListaPrendas()) {
                                if (prendaActual.getCodigo().equalsIgnoreCase(codigoPrendaInv)) {
                                    prendaEncontrada = true;

                                    System.out.println("1. Talla de ropa");
                                    System.out.println("2. Talla de calzado");
                                    System.out.print("Seleccione el tipo de talla: ");
                                    int opcionTalla = sc.nextInt();
                                    sc.nextLine();

                                    System.out.print("Color: ");
                                    String color = sc.nextLine();

                                    System.out.print("Cantidad: ");
                                    int cantidad = sc.nextInt();
                                    sc.nextLine();

                                    if (cantidad > 0) {
                                        if (opcionTalla == 1) {
                                            System.out.print("Ingrese la talla (XS, S, M, L, XL): ");
                                            String medida = sc.nextLine();

                                            TallaRopa talla = new TallaRopa(medida);
                                            Inventario inventario = new Inventario(color, cantidad, prendaActual, talla);

                                            if (sucursalActual.agregarInventario(inventario)) {
                                                System.out.println("Inventario registrado o actualizado correctamente.");
                                            }
                                        } else if (opcionTalla == 2) {
                                            System.out.print("Ingrese el número de calzado: ");
                                            int numero = sc.nextInt();
                                            sc.nextLine();

                                            TallaCalzado talla = new TallaCalzado(numero);
                                            Inventario inventario = new Inventario(color, cantidad, prendaActual, talla);

                                            if (sucursalActual.agregarInventario(inventario)) {
                                                System.out.println("Inventario registrado o actualizado correctamente.");
                                            }
                                        } else {
                                            System.out.println("Opción de talla inválida.");
                                        }
                                    } else {
                                        System.out.println("La cantidad debe ser mayor que cero.");
                                    }

                                    break;
                                }
                            }

                            break;
                        }
                    }

                    if (sucursalEncontrada == false) {
                        System.out.println("La sucursal no existe.");
                    } else if (prendaEncontrada == false) {
                        System.out.println("La prenda no existe.");
                    }
                    break;

                case 6:
                    System.out.println("\n---- Consultar inventario ----");

                    System.out.print("Ingrese el código de la sucursal: ");
                    String codigoSucursalConsulta = sc.nextLine();

                    boolean sucursalEncontradaConsulta = false;

                    for (Sucursal sucursalActual : empresa.getListaSucursales()) {
                        if (sucursalActual.getCodigo().equalsIgnoreCase(codigoSucursalConsulta)) {
                            sucursalEncontradaConsulta = true;

                            boolean inventarioEncontrado = false;

                            for (Inventario inventario : sucursalActual.getListaInventarios()) {
                                System.out.println(inventario);
                                inventarioEncontrado = true;
                            }

                            if (inventarioEncontrado == false) {
                                System.out.println("La sucursal no tiene inventario registrado.");
                            }

                            break;
                        }
                    }

                    if (sucursalEncontradaConsulta == false) {
                        System.out.println("La sucursal no existe.");
                    }

                    break;

                case 7:
                    System.out.println("\n---- Consultar inventario agotado ----");

                    System.out.print("Ingrese el código de la sucursal: ");
                    String codigoSucursalAgotado = sc.nextLine();

                    boolean sucursalEncontradaAgotado = false;
                    boolean inventarioAgotado = false;

                    for (Sucursal sucursalActual : empresa.getListaSucursales()) {
                        if (sucursalActual.getCodigo().equalsIgnoreCase(codigoSucursalAgotado)) {
                            sucursalEncontradaAgotado = true;

                            for (Inventario inventario : sucursalActual.getListaInventarios()) {
                                if (inventario.estaAgotado()) {
                                    System.out.println(inventario);
                                    System.out.println("No hay cantidad disponible.");
                                    inventarioAgotado = true;
                                }
                            }

                            if (inventarioAgotado == false) {
                                System.out.println("No hay inventarios agotados en esta sucursal.");
                            }

                            break;
                        }
                    }

                    if (sucursalEncontradaAgotado == false) {
                        System.out.println("La sucursal no existe.");
                    }

                    break;

                case 8:
                    System.out.println("\n---- Registrar cliente ----");

                    System.out.print("Documento: ");
                    int documentoCliente = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombreCliente = sc.nextLine();

                    System.out.print("Correo: ");
                    String correoCliente = sc.nextLine();

                    System.out.print("Teléfono: ");
                    int telefonoCliente = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Código de afiliación: ");
                    String codigoAfiliacion = sc.nextLine();

                    System.out.println("Seleccione la categoría del cliente:");
                    System.out.println("1. BRONCE - 5% de descuento");
                    System.out.println("2. PLATA - 10% de descuento");
                    System.out.println("3. ORO - 15% de descuento");
                    System.out.print("Opción: ");
                    int opcionCategoriaCliente = sc.nextInt();
                    sc.nextLine();

                    boolean clienteRegistrado = false;

                    if (empresa.verificarCliente(documentoCliente) == false) {
                        if (opcionCategoriaCliente >= 1 && opcionCategoriaCliente <= 3) {
                            CategoriaCliente categoriaCliente = CategoriaCliente.BRONCE;

                            if (opcionCategoriaCliente == 1) {
                                categoriaCliente = CategoriaCliente.BRONCE;
                            } else if (opcionCategoriaCliente == 2) {
                                categoriaCliente = CategoriaCliente.PLATA;
                            } else if (opcionCategoriaCliente == 3) {
                                categoriaCliente = CategoriaCliente.ORO;
                            }

                            Cliente cliente = new Cliente(documentoCliente, nombreCliente, correoCliente, telefonoCliente, codigoAfiliacion, categoriaCliente);

                            clienteRegistrado = empresa.agregarCliente(cliente);

                            if (clienteRegistrado == true) {
                                System.out.println("Cliente registrado correctamente.");
                            }
                        } else {
                            System.out.println("Categoría inválida.");
                        }
                    } else {
                        System.out.println("Ya existe un cliente con ese documento.");
                    }

                    break;

                case 9:
                    System.out.println("\n---- Consultar cliente ----");

                    System.out.print("Ingrese el documento del cliente: ");
                    int documentoBuscarCliente = sc.nextInt();
                    sc.nextLine();

                    if (empresa.buscarCliente(documentoBuscarCliente) == false) {
                        System.out.println("El cliente no existe.");
                    }

                    break;

                case 10:
                    System.out.println("\n---- Registrar vendedor ----");

                    System.out.print("Documento: ");
                    int documentoVendedor = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombreVendedor = sc.nextLine();

                    System.out.print("Correo: ");
                    String correoVendedor = sc.nextLine();

                    System.out.print("Teléfono: ");
                    int telefonoVendedor = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Código de empleado: ");
                    String codigoEmpleado = sc.nextLine();

                    System.out.print("Fecha de contrato (AAAA-MM-DD): ");
                    LocalDate fechaContrato = LocalDate.parse(sc.nextLine());

                    System.out.print("Salario: ");
                    double salarioVendedor = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Código de la sucursal: ");
                    String codigoSucursalVendedor = sc.nextLine();

                    boolean sucursalEncontradaVendedor = false;
                    boolean vendedorRegistrado = false;

                    for (Sucursal sucursalActual : empresa.getListaSucursales()) {
                        if (sucursalActual.getCodigo().equalsIgnoreCase(codigoSucursalVendedor)) {
                            sucursalEncontradaVendedor = true;

                            if (sucursalActual.verificarVendedor(documentoVendedor) == false) {
                                Vendedor vendedor = new Vendedor(documentoVendedor, nombreVendedor, correoVendedor, telefonoVendedor, codigoEmpleado, fechaContrato, salarioVendedor);

                                vendedor.setSucursal(sucursalActual);

                                vendedorRegistrado = sucursalActual.agregarVendedor(vendedor);

                                if (vendedorRegistrado == true) {
                                    System.out.println("Vendedor registrado correctamente.");
                                }
                            } else {
                                System.out.println("Ya existe un vendedor con ese documento en esta sucursal.");
                            }

                            break;
                        }
                    }

                    if (sucursalEncontradaVendedor == false) {
                        System.out.println("La sucursal no existe.");
                    }

                    break;

                case 11:
                    System.out.println("\n---- Consultar vendedor ----");

                    System.out.print("Ingrese el código de la sucursal: ");
                    String codigoSucursalConsultaVendedor = sc.nextLine();

                    boolean sucursalEncontradaConsultaVendedor = false;

                    for (Sucursal sucursalActual : empresa.getListaSucursales()) {
                        if (sucursalActual.getCodigo().equalsIgnoreCase(codigoSucursalConsultaVendedor)) {
                            sucursalEncontradaConsultaVendedor = true;

                            System.out.print("Ingrese el documento del vendedor: ");
                            int documentoBuscarVendedor = sc.nextInt();
                            sc.nextLine();

                            if (sucursalActual.buscarVendedor(documentoBuscarVendedor) == false) {
                                System.out.println("El vendedor no existe en esta sucursal.");
                            }

                            break;
                        }
                    }

                    if (sucursalEncontradaConsultaVendedor == false) {
                        System.out.println("La sucursal no existe.");
                    }

                    break;

                case 12:
                    System.out.println("\n---- Registrar venta ----");
                    System.out.print("Código de la sucursal: ");
                    String codigoSucursalVenta = sc.nextLine();

                    Sucursal sucursalVenta = null;

                    for (Sucursal sucursalActual : empresa.getListaSucursales()) {
                        if (sucursalActual.getCodigo().equalsIgnoreCase(codigoSucursalVenta)) {
                            sucursalVenta = sucursalActual;
                            break;
                        }
                    }

                    if (sucursalVenta != null) {
                        System.out.print("Código de la venta: ");
                        String codigoVentaNueva = sc.nextLine();

                        System.out.print("Documento del cliente: ");
                        int documentoClienteVenta = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Documento del vendedor: ");
                        int documentoVendedorVenta = sc.nextInt();
                        sc.nextLine();

                        Venta ventaNueva = new Venta(codigoVentaNueva, LocalDate.now());

                        if (sucursalVenta.registrarVenta(ventaNueva, documentoClienteVenta, documentoVendedorVenta, empresa.getListaClientes())) {

                            int continuarDetalleVenta = 1;

                            while (continuarDetalleVenta == 1) {
                                System.out.print("Código de la prenda: ");
                                String codigoPrendaVenta = sc.nextLine();

                                Prenda prendaVenta = null;

                                for (Prenda prendaActual : empresa.getListaPrendas()) {
                                    if (prendaActual.getCodigo().equalsIgnoreCase(codigoPrendaVenta)) {
                                        prendaVenta = prendaActual;
                                        break;
                                    }
                                }

                                if (prendaVenta != null) {
                                    System.out.println("Tipo de talla:");
                                    System.out.println("1. Ropa");
                                    System.out.println("2. Calzado");
                                    System.out.print("Seleccione una opción: ");
                                    int tipoTallaVenta = sc.nextInt();
                                    sc.nextLine();

                                    Talla tallaVenta;

                                    if (tipoTallaVenta == 1) {
                                        System.out.print("Talla (S, M, L, etc.): ");
                                        String medidaVenta = sc.nextLine();
                                        tallaVenta = new TallaRopa(medidaVenta);
                                    } else {
                                        System.out.print("Número de calzado: ");
                                        int numeroTallaVenta = sc.nextInt();
                                        sc.nextLine();
                                        tallaVenta = new TallaCalzado(numeroTallaVenta);
                                    }

                                    System.out.print("Color: ");
                                    String colorVenta = sc.nextLine();

                                    System.out.print("Cantidad: ");
                                    int cantidadVenta = sc.nextInt();
                                    sc.nextLine();

                                    if (cantidadVenta > 0) {
                                        if (sucursalVenta.registrarDetalleVenta(ventaNueva,
                                                prendaVenta, tallaVenta, colorVenta, cantidadVenta)) {
                                            System.out.println("Detalle de venta registrado.");
                                        } else {
                                            System.out.println("No se pudo registrar el detalle. "
                                                    + "Verifique el inventario y las existencias.");
                                        }
                                    } else {
                                        System.out.println("La cantidad debe ser mayor que cero.");
                                    }
                                } else {
                                    System.out.println("La prenda no existe.");
                                }

                                System.out.print("¿Desea agregar otro producto? (1. Sí / 2. No): ");
                                continuarDetalleVenta = sc.nextInt();
                                sc.nextLine();
                            }

                            System.out.println("\nVenta registrada.");
                            System.out.println(ventaNueva);
                            System.out.println("Total de la venta: $" + ventaNueva.calcularTotal());

                        } else {
                            System.out.println("No se pudo registrar la venta. "
                                    + "Verifique el código de la venta, el cliente y el vendedor.");
                        }
                    } else {
                        System.out.println("La sucursal no existe.");
                    }

                    break;

                case 13:
                    System.out.println("\n---- Consultar venta ----");

                    System.out.print("Código de la sucursal: ");
                    String codigoSucursalConsultaVenta = sc.nextLine();

                    boolean sucursalEncontradaConsultaVenta = false;

                    for (Sucursal sucursalActual : empresa.getListaSucursales()) {
                        if (sucursalActual.getCodigo().equalsIgnoreCase(codigoSucursalConsultaVenta)) {
                            sucursalEncontradaConsultaVenta = true;

                            System.out.print("Código de la venta: ");
                            String codigoVentaConsulta = sc.nextLine();

                            sucursalActual.buscarVenta(codigoVentaConsulta);

                            break;
                        }
                    }

                    if (sucursalEncontradaConsultaVenta == false) {
                        System.out.println("La sucursal no existe.");
                    }
                    break;

                case 14:
                    System.out.println("\n---- Consultar ventas por vendedor ----");

                    System.out.print("Código de la sucursal: ");
                    String codigoSucursalVentasVendedor = sc.nextLine();

                    boolean sucursalEncontradaVentasVendedor = false;

                    for (Sucursal sucursalActual : empresa.getListaSucursales()) {
                        if (sucursalActual.getCodigo().equalsIgnoreCase(codigoSucursalVentasVendedor)) {
                            sucursalEncontradaVentasVendedor = true;

                            System.out.print("Documento del vendedor: ");
                            int documentoVendedorConsulta = sc.nextInt();
                            sc.nextLine();

                            boolean vendedorEncontradoVentas = false;

                            for (Vendedor vendedorActual : sucursalActual.getListaVendedores()) {
                                if (vendedorActual.getDocumento() == documentoVendedorConsulta) {
                                    vendedorEncontradoVentas = true;

                                    if (vendedorActual.getListaVentas().isEmpty()) {
                                        System.out.println("El vendedor no tiene ventas registradas.");
                                    } else {
                                        for (Venta ventaActual : vendedorActual.getListaVentas()) {
                                            System.out.println(ventaActual);
                                        }
                                    }

                                    break;
                                }
                            }

                            if (vendedorEncontradoVentas == false) {
                                System.out.println("El vendedor no existe en esta sucursal.");
                            }

                            break;
                        }
                    }

                    if (sucursalEncontradaVentasVendedor == false) {
                        System.out.println("La sucursal no existe.");
                    }
                    break;

                case 15:
                    System.out.println("\n---- Consultar compras por cliente ----");

                    System.out.print("Documento del cliente: ");
                    int documentoClienteCompras = sc.nextInt();
                    sc.nextLine();

                    boolean clienteEncontradoCompras = false;

                    for (Cliente clienteActual : empresa.getListaClientes()) {
                        if (clienteActual.getDocumento() == documentoClienteCompras) {
                            clienteEncontradoCompras = true;

                            if (clienteActual.getListaVentas().isEmpty()) {
                                System.out.println("El cliente no tiene compras registradas.");
                            } else {
                                for (Venta ventaActual : clienteActual.getListaVentas()) {
                                    System.out.println(ventaActual);
                                }
                            }

                            break;
                        }
                    }

                    if (clienteEncontradoCompras == false) {
                        System.out.println("El cliente no existe.");
                    }
                    break;

                case 16:
                    System.out.println("\n---- Consultar ingresos por sucursal ----");

                    System.out.print("Código de la sucursal: ");
                    String codigoSucursalIngresos = sc.nextLine();

                    boolean sucursalEncontradaIngresos = false;

                    for (Sucursal sucursalActual : empresa.getListaSucursales()) {
                        if (sucursalActual.getCodigo().equalsIgnoreCase(codigoSucursalIngresos)) {
                            sucursalEncontradaIngresos = true;
                            double ingresos = 0;

                            for (Venta ventaActual : sucursalActual.getListaVentas()) {
                                ingresos += ventaActual.calcularTotal();
                            }

                            System.out.println("Sucursal: " + sucursalActual.getNombre());
                            System.out.println("Ingresos totales: $" + ingresos);

                            break;
                        }
                    }

                    if (sucursalEncontradaIngresos == false) {
                        System.out.println("La sucursal no existe.");
                    }
                    break;

                case 17:
                    System.out.println("\n---- Consultar prenda más vendida ----");

                    String nombrePrendaMasVendida = "";
                    String codigoPrendaMasVendida = "";
                    int mayorCantidadVendida = 0;

                    for (Prenda prendaActual : empresa.getListaPrendas()) {
                        int cantidadVendida = 0;

                        for (Sucursal sucursalActual : empresa.getListaSucursales()) {
                            for (Venta ventaActual : sucursalActual.getListaVentas()) {
                                for (DetalleVenta detalleActual : ventaActual.getListaDetalleVentas()) {
                                    if (detalleActual.getInventario().getPrenda().getCodigo().equalsIgnoreCase(prendaActual.getCodigo())) {
                                        cantidadVendida += detalleActual.getCantidad();
                                    }
                                }
                            }
                        }

                        if (cantidadVendida > mayorCantidadVendida) {
                            mayorCantidadVendida = cantidadVendida;
                            nombrePrendaMasVendida = prendaActual.getNombre();
                            codigoPrendaMasVendida = prendaActual.getCodigo();
                        }
                    }

                    if (mayorCantidadVendida > 0) {
                        System.out.println("Prenda más vendida: " + nombrePrendaMasVendida);
                        System.out.println("Código: " + codigoPrendaMasVendida);
                        System.out.println("Unidades vendidas: " + mayorCantidadVendida);
                    } else {
                        System.out.println("Todavía no se han registrado ventas de prendas.");
                    }
                    break;

                case 18:
                    System.out.println("Adiós......");
                    break;

                default:
                    System.out.println("Opción no válida... Intente de nuevo.");
                    break;
            }

        } while (opcion != 18);

        sc.close();
    }
}
