package it.uniroma2.ispw.cardemporium.filesystemdb;



import it.uniroma2.ispw.cardemporium.model.CopiaCardCarrello;

import java.io.*;


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

    public void addcard(CopiaCardCarrello value, int id){



        try {
            fileWriter.write(id +" ");
            fileWriter.write(value.getNomeCarta()+" ");
            fileWriter.write( value.getUtenteVenditore()+" ");
            fileWriter.write(value.getPrezzo() +" ");
            fileWriter.newLine();
            fileWriter.close();


        } catch (IOException e) {
            e.getCause();
        }

    }
}
