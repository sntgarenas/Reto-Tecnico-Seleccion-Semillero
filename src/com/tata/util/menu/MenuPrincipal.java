package com.tata.util.menu;

import com.tata.domain.cliente.Cliente;
import com.tata.domain.sistema.Sistema;
import com.tata.util.Mensaje;

import java.util.Scanner;

public class MenuPrincipal implements IMenu {

    private int opcionMenu;
    private boolean salirMenu;
    private Cliente clienteBusqueda;
    private final Sistema sistema;
    private final Scanner sc;

    public MenuPrincipal(Sistema sistema, Scanner sc ) {
        this.opcionMenu = 0;
        this.salirMenu = false;
        this.sistema = sistema;
        this.sc = sc;
    }

    @Override
    public void mostrarMenu() {
        Mensaje.encabezadoConsola("¡bienvenido al sistema!");
        System.out.println("MENU:");
        Mensaje.separacionSeccionConsola();
        System.out.println("1. AGREGAR PRODUCTOS AL SISTEMA");
        System.out.println("2. AGREGAR CLIENTES:");
        System.out.println("3. EDITAR CLIENTE");
        System.out.println("4. ELIMINAR CLIENTE");
        System.out.println("5. CONSULTAR CLIENTE:");
        System.out.println("6. SALIR DEL SISTEMA:");

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
                sistema.agregarProductosSistema(numeroObjetosCrear("productos"));
                break;
            case 2:
                sistema.agregarClientes(numeroObjetosCrear("clientes"));
                break;
            case 3:
                clienteBusqueda = buscarCliente();

                if (clienteBusqueda != null) {
                    MenuEditarCliente menuCliente = new MenuEditarCliente(sc, clienteBusqueda, this.sistema.getProductos());
                    menuCliente.mostrarMenu();
                }
                break;
            case 4:
                clienteBusqueda = buscarCliente();
                boolean clienteEliminado = sistema.eliminarCliente(clienteBusqueda);

                if (clienteEliminado) {
                    Mensaje.separacionSeccionConsola();
                    System.out.println("Cliente eliminado");
                }
                break;
            case 5:
                clienteBusqueda = buscarCliente();

                if ( clienteBusqueda != null  ) {
                    clienteBusqueda.imprimirDatos();
                }
                break;
            case 6:
                this.salirMenu = true;
                break;
            default:
                System.out.println("opcion invalida");
                break;
        }
    }

    public int numeroObjetosCrear (String tipoObjeto) {
        int numeroElementos = 0;

        Mensaje.encabezadoConsola("agregar " + tipoObjeto);
        Mensaje.separacionSeccionConsola();
        System.out.println("Digite el numero de " + tipoObjeto + " a crear: ");
        numeroElementos = sc.nextInt();
        this.sc.nextLine();
        System.out.println();
        Mensaje.separacionSeccionConsola();

        return numeroElementos;
    }

    public Cliente buscarCliente() {
        int documentoCliente;
        String tipoDocumentoCliente;

        System.out.println();
        System.out.println("Ingrese el documento del cliente a buscar");
        documentoCliente = this.sc.nextInt();
        this.sc.nextLine();
        System.out.println("Ingrese el tipo de documento del cliente a buscar");
        tipoDocumentoCliente = this.sc.nextLine();

        return this.sistema.buscarCliente(documentoCliente, tipoDocumentoCliente);
    }

    public boolean getSalirMenu() {
        return salirMenu;
    }

    public void setSalirMenu(boolean opcionSalir) {
        this.salirMenu = opcionSalir;
    }

    public int getOpcionMenu() {
        return opcionMenu;
    }

    public void setOpcionMenu(int opcionMenu) {
        this.opcionMenu = opcionMenu;
    }

    public Cliente getClienteBusqueda() {
        return clienteBusqueda;
    }

    public void setClienteBusqueda(Cliente clienteBusqueda) {
        this.clienteBusqueda = clienteBusqueda;
    }

    public Sistema getSistema() {
        return sistema;
    }

    public Scanner getSc() {
        return sc;
    }
}
