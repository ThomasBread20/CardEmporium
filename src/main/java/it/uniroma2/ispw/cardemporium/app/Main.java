package it.uniroma2.ispw.cardemporium.app;

import it.uniroma2.ispw.cardemporium.ui.HomeNonRegistrati;

import javafx.application.Application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {



    public static void main(String[] args) throws IOException {
        //vediamo se funziona
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to CardEmporium."+"\n"+"Please press 1 to get the CLI or 2 to get the JavaFX interface:");
        int choose = Integer.parseInt(reader.readLine());
        if(choose==2) Application.launch(HomeNonRegistrati.class, args);
        //da fare una seconda interfaccia con una casella per prendere i dati e basta 

    }

}
