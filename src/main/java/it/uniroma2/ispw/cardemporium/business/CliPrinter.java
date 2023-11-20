package it.uniroma2.ispw.cardemporium.business;

import java.util.logging.Logger;

public class CliPrinter {
    private CliPrinter() {
        throw new IllegalStateException("Utility class");
    }

    public static void printMessage(String s){
        System.out.println(s);


    }
}
