package it.uniroma2.ispw.cardemporium.filesystemdb;



import it.uniroma2.ispw.cardemporium.model.CardEntity;
import it.uniroma2.ispw.cardemporium.model.CarrelloEntity;

import java.io.*;
import java.util.List;


public class ShopcardFS {





    BufferedReader br;

    static String fileName ="src/main/java/it/uniroma2/ispw/cardemporium/filesystemdb/Shop";

    static BufferedWriter fileWriter;



    static  {
        try {
            fileWriter = new BufferedWriter(new FileWriter(fileName,true));


        } catch (IOException e) {
            e.getMessage();
        }
    }

    public void addcard(String name, String sellername, Double prize, int id){


        try {
            fileWriter.write(id +" ");
            fileWriter.write(name+" ");
            fileWriter.write( sellername+" ");
            fileWriter.write(prize +" ");
            fileWriter.newLine();
            fileWriter.close();


        } catch (IOException e) {
            e.getCause();
        }

    }
}
