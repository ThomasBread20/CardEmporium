package it.uniroma2.ispw.cardEmporium;

import it.uniroma2.ispw.cardEmporium.business.DBconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static it.uniroma2.ispw.cardEmporium.business.DBconstants.*;

public class Main1 {


    public static void main(String[] args){
        DBconnection instance;
        try {
            Class.forName(DRIVER_CLASS_NAME);
            Connection conn = DriverManager.getConnection(BD_URL,USER,PASSWD);
            Logger.getLogger("Run").log(Level.INFO, "Database connesso");
            System.out.println("conn value: " + conn);
        }catch(ClassNotFoundException | SQLException e){
            //Logger.getLogger("Run").log(Level.INFO, "Impossibile connettersi al database");
            System.out.println("Exception Thrown: " + e);
        }
    }
}


