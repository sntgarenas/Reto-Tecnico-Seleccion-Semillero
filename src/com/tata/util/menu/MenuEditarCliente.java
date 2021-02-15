package com.tata.util.menu;

import com.tata.domain.cliente.Cliente;
import com.tata.domain.productos.Producto;
import com.tata.util.Mensaje;

import java.util.Map;
import java.util.Scanner;

public class MenuEditarCliente implements IMenu {

    private int opcionMenu;
    private Cliente clienteEditar;
    Map<Integer, Producto> productosSistema;
    Scanner sc;

    public MenuEditarCliente(Scanner sc, Cliente clienteEditar, Map<Integer, Producto> productosSistema) {
        this.sc = sc;
        this.opcionMenu = 0;
        this.clienteEditar = clienteEditar;
        this.productosSistema = productosSistema;
    }

    @Override
    public void mostrarMenu() {
        Mensaje.encabezadoConsola("¡editar cliente!");
        System.out.println("MENU:");
        Mensaje.separacionSeccionConsola();
        System.out.println("1. EDITAR INFORMACION");
        System.out.println("2. AGREGAR PRODUCTO:");
        System.out.println("3. ELIMINAR PRODUCTO");

        this.escogerOpcion();
        Mensaje.separacionSeccionConsola();
        System.out.println();
    }

    @Override
    public void escogerOpcion() {
        System.out.println("Escoge una opcion: ");
        opcionMenu = sc.nextInt();
        this.sc.nextLine();

        switch (opcionMenu) {
            case 1:
                clienteEditar.editar();
                break;
            case 2:
                int idProducto = this.escogerProducto();

                if (this.productosSistema.containsKey(idProducto)) {
                    clienteEditar.agregarProducto(this.productosSistema.get(idProducto), idProducto);
                    Mensaje.separacionSeccionConsola();
                    System.out.println("Producto agregado");
                } else {
                    Mensaje.separacionSeccionConsola();
                    System.out.println("Producto no existe");
                }
                break;
            case 3:
                clienteEditar.eliminarProducto(this.escogerProducto());
                break;
            default:
                System.out.println("opcion invalida");
                break;
        }
    }

    public int escogerProducto() {
        int idProducto;

        Mensaje.separacionSeccionConsola();
        System.out.println("Digita el id del producto");
        idProducto = sc.nextInt();
        sc.nextLine();
        Mensaje.separacionSeccionConsola();

        return idProducto;
    }
}
