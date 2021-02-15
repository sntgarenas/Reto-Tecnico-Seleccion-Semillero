package com.tata;

import com.tata.domain.sistema.Sistema;
import com.tata.util.menu.MenuPrincipal;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MenuPrincipal menuPrincipal = new MenuPrincipal(new Sistema(), new Scanner(System.in));

        do {
            menuPrincipal.mostrarMenu();
        } while (!menuPrincipal.getSalirMenu());
    }
}
