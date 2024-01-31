package it.uniroma2.ispw.cardemporium.filesystemdb;



import it.uniroma2.ispw.cardemporium.model.CopiaCardCarrello;

import java.io.*;
import java.util.logging.Logger;

public class ShopcardFS {

    Logger logger=Logger.getLogger(ShopcardFS.class.getName());
    File shop=new File("shop");

    String line;

    String []shopping;

    static FileWriter fileWriterU;

    static {
        try {
            fileWriterU = new FileWriter("shop", true);
        } catch (IOException e) {
            e.getCause();
        }
    }

    public void addcard(CopiaCardCarrello value, int id){



        line=null;

        try {
            System.out.println(id + " "+  value.getCartaSingolaID() + " " + value.getNomeCarta()+" " + value.getUtenteVenditore()+" " + value.getPrezzo() +" " +"\n" );
            fileWriterU.write(id +" ");
            fileWriterU.write(value.getCartaSingolaID());
            fileWriterU.write(value.getNomeCarta()+" ");
            fileWriterU.write( value.getUtenteVenditore()+" ");
            fileWriterU.write(value.getPrezzo() +" ");
            fileWriterU.write("\n");


        } catch (IOException e) {
            e.getCause();
        }

    }
}
