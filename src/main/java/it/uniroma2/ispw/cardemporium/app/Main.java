package it.uniroma2.ispw.cardemporium.app;

import it.uniroma2.ispw.cardemporium.ui.HomeNonRegistrati;

import javafx.application.Application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {



    public static void main(String[] args) throws IOException {
        Logger logger=Logger.getLogger(Main.class.getName());

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        logger.log(Level.INFO,"Welcome to CardEmporium."+"\n"+"Please press 1 to get the CLI or 2 to get the JavaFX interface:");
        int choose = Integer.parseInt(reader.readLine());
        if(choose==2) Application.launch(HomeNonRegistrati.class, args);

    }

}
