package it.uniroma2.ispw.cardemporium.business;


public class CliPrinter {
    private CliPrinter() {
        throw new IllegalStateException("Utility class");
    }

    public static void printMessage(String s){
        System.out.println(s);


    }
}
