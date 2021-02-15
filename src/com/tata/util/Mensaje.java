package com.tata.util;

import java.text.CollationElementIterator;
import java.util.Collections;

public class Mensaje {
    public static void encabezadoConsola(String encabezado) {
        String marco = String.join("", Collections.nCopies((encabezado.length()+30), "*"));

        System.out.println();
        System.out.println("\t\t" + marco);
        System.out.println("\t\t************** " + encabezado.toUpperCase() + " **************");
        System.out.println("\t\t" + marco);
    }

    public static void separacionSeccionConsola() {
        System.out.println("-------------------------------------------------------------");
    }
}
