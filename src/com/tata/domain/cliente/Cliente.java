package com.tata.domain.cliente;

import com.tata.domain.productos.Producto;
import com.tata.util.Mensaje;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cliente extends Persona {
    private String tipoDocumento;
    private int numeroDocumento;
    private Map<Integer, Producto> productos;

    public Cliente(String tipoDocumento, int numeroDocumento, String nombreCompleto, int telefono, int edad, String ciudad) {
        super(nombreCompleto, telefono, edad, ciudad);
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        productos = new HashMap<>();
    }

    public void agregarProductos(Map<Integer, Producto> productosSistema) {
        Scanner sc = new Scanner(System.in);
        String agregarProducto = "";
        Integer idProducto;
        Producto productoActual = null;

        do {
            System.out.println("Ingrese codigo del producto para agregar: ");
            idProducto = sc.nextInt();
            sc.nextLine();

            productoActual = productosSistema.get(idProducto);

            if (productoActual == null) {
                System.out.println("No existe algun producto con el id" + idProducto);
            } else {
                productos.put(idProducto, productoActual);
            }

            Mensaje.separacionSeccionConsola();
            System.out.println("Desea agregar otro producto (S/N): ");
            agregarProducto = sc.nextLine();
            System.out.println();
            Mensaje.separacionSeccionConsola();
        } while (agregarProducto.equals("S"));
    }

    public void editar() {
        Scanner sc = new Scanner(System.in);
        Mensaje.separacionSeccionConsola();

        System.out.println("Digite su nombre completo");
        this.setNombreCompleto(sc.nextLine());

        System.out.println("Digite su numero telefonico");
        this.setTelefono(sc.nextInt());
        sc.nextLine();

        System.out.println("Digite su edad");
        this.setEdad(sc.nextInt());
        sc.nextLine();

        System.out.println("Digite la ciudad donde vive");
        this.setCiudad(sc.nextLine());

        Mensaje.separacionSeccionConsola();
        System.out.println("Informacion del cliente actualizado");
    }

    public void agregarProducto(Producto producto, int idProducto) {
        this.productos.put(idProducto, producto);
    }

    public void eliminarProducto(int idProducto) {
        if (productos.containsKey(idProducto)) {
            productos.remove(idProducto);

            Mensaje.separacionSeccionConsola();
            System.out.println("Producto eliminado de la lista de cliente");
            Mensaje.separacionSeccionConsola();
        } else {
            Mensaje.separacionSeccionConsola();
            System.out.println("Producto no existe");
        }
    }

    @Override
    public void imprimirDatos() {
        Mensaje.separacionSeccionConsola();
        Mensaje.encabezadoConsola("DATOS DEL CLIENTE");

        System.out.println();
        System.out.println("DATOS PERSONALES:");
        System.out.println("Numero del documento: " +  this.numeroDocumento);
        System.out.println("Tipo de documento: " +  this.tipoDocumento);
        System.out.println("Tipo de documento: " +  this.getNombreCompleto());
        System.out.println("Tipo de documento: " +  this.getTelefono());
        System.out.println("Tipo de documento: " +  this.getEdad());
        System.out.println("Tipo de documento: " +  this.getCiudad());

        System.out.println();
        System.out.println("LISTA DE PRODUCTOS DEL CLIENTE");
        for (Map.Entry<Integer, Producto> producto: this.productos.entrySet()) {
            System.out.println();
            System.out.println("Clave producto: " + producto.getKey());
            System.out.println("Nombre del producto: " + producto.getValue().getNombre());
            System.out.println("Valor del producto: " + producto.getValue().getPrecio());
        }

        System.out.println();
        Mensaje.separacionSeccionConsola();
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Map<Integer, Producto> getProductos() {
        return productos;
    }

    public void setProductos(Map<Integer, Producto> productos) {
        this.productos = productos;
    }
}
