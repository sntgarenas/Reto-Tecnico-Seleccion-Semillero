package com.tata.domain.sistema;

import com.tata.domain.cliente.Cliente;
import com.tata.domain.productos.Producto;
import com.tata.util.Mensaje;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sistema {
    private Map<Integer, Producto> productos;
    private Map<Integer, Cliente> clientes;

    public Sistema() {
        productos = new HashMap<>();
        clientes = new HashMap<>();
    }

    public void agregarClientes(int numeroClientes) {
        Scanner sc = new Scanner(System.in);
        String tipoDocumentoCliente;
        int documentoCliente;
        String nombreCliente;
        int telefonoCliente;
        int edadCliente;
        String ciudadCliente;

        for (int i = 0; i < numeroClientes; i++) {
            Mensaje.separacionSeccionConsola();
            System.out.println("Datos personales cliente(" + (i+1) + "): " );
            Mensaje.separacionSeccionConsola();
            Mensaje.separacionSeccionConsola();

            System.out.println("Digite el numero del documento");
            documentoCliente = sc.nextInt();
            sc.nextLine();

            System.out.println("Digite el tipo de documento");
            tipoDocumentoCliente = sc.nextLine();

            System.out.println("Digite su nombre completo");
            nombreCliente = sc.nextLine();

            System.out.println("Digite su numero telefonico");
            telefonoCliente = sc.nextInt();
            sc.nextLine();

            System.out.println("Digite su edad");
            edadCliente = sc.nextInt();
            sc.nextLine();

            System.out.println("Digite la ciudad donde vive");
            ciudadCliente = sc.nextLine();

            Cliente cliente = new Cliente(  tipoDocumentoCliente,
                                            documentoCliente,
                                            nombreCliente,
                                            telefonoCliente,
                                            edadCliente,
                                            ciudadCliente);

            this.imprimirListaProductos();
            cliente.agregarProductos(this.getProductos());
            clientes.put(documentoCliente, cliente);
        }

        Mensaje.separacionSeccionConsola();
        System.out.println("Cliente(s) agregado(s) al sistema");
        Mensaje.separacionSeccionConsola();
    }

    public void agregarProductosSistema(int numeroProductos) {
        Scanner sc = new Scanner(System.in);
        String nombreProducto;
        float precioProducto;

        for (int i = 0; i < numeroProductos; i++) {
            Mensaje.separacionSeccionConsola();
            System.out.println("Digite el nombre del producto");
            nombreProducto = sc.nextLine();
            System.out.println("Digite el precio del producto");
            precioProducto = (float) sc.nextInt();
            sc.nextLine();

            Producto producto = new Producto(nombreProducto, precioProducto);
            productos.put(Producto.id, producto);
        }

        Mensaje.separacionSeccionConsola();
        System.out.println("Productos agregados al sistema");
        Mensaje.separacionSeccionConsola();
    }

    public Cliente buscarCliente(Integer documento, String tipoDocumento) {
        Cliente clienteActual = clientes.get(documento);

        Mensaje.separacionSeccionConsola();

        if (clienteActual == null) {
            System.out.println("Cliente no existe, ingrese un documento y tipo de documento valido");
            return null;
        } else {
            if (!clienteActual.getTipoDocumento().equals(tipoDocumento)) {
                System.out.println("Cliente no existe, ingrese un documento y tipo de documento valido");
                return null;
            }
        }
        return clienteActual;
    }

    public boolean eliminarCliente(Cliente cliente) {
        if (clientes.containsKey(cliente.getNumeroDocumento())) {
            clientes.remove(cliente.getNumeroDocumento());
            return true;
        }

        return false;
    }

    public void imprimirListaProductos() {
        Mensaje.separacionSeccionConsola();
        System.out.println("Lista de productos:");
        Mensaje.separacionSeccionConsola();
        System.out.println("ID" + "\tNombre" + "\tPrecio");

        for (Map.Entry<Integer, Producto> producto: this.productos.entrySet()) {
            producto.getValue().imprimirDatos(producto.getKey());
        }

        Mensaje.separacionSeccionConsola();
    }

    public Map<Integer, Producto> getProductos() {
        return productos;
    }

    public void setProductos(Map<Integer, Producto> productos) {
        this.productos = productos;
    }

    public Map<Integer, Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Map<Integer, Cliente> clientes) {
        this.clientes = clientes;
    }
}
