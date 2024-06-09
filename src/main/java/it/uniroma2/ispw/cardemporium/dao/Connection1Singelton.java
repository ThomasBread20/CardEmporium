package it.uniroma2.ispw.cardemporium.dao;

import it.uniroma2.ispw.cardemporium.utility.DBconnection;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;

import java.sql.Connection;



public class Connection1Singelton {

    Connection conn;

    private static Connection1Singelton instance=null;

    static {
        try {
            instance = new Connection1Singelton();
        } catch (ExceptionDBerror e) {
            e.getMessage();
        }


    }


    public static Connection1Singelton getInstance()  {

            return instance;


    }


    private Connection1Singelton() throws ExceptionDBerror {
        try {
            conn = DBconnection.getDBInstance().getConnection();
        }catch (Exception e){
            throw new ExceptionDBerror("ERRORE LOGIN SERVER DB");
        }
    }
    public Connection getConn() {
        return conn;
    }
}
