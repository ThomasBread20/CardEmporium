package it.uniroma2.ispw.cardemporium.dao;

import it.uniroma2.ispw.cardemporium.business.DBconnection;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;

import java.sql.Connection;



public class Connection1Singelton {

    Connection conn = null;

    private static Connection1Singelton instance;

    public static Connection1Singelton getInstance() throws ExceptionDBerror {
        if(instance != null){
            return instance;
        }
        try{
            instance = new Connection1Singelton();
            return instance;
        } catch (ExceptionDBerror e) {
            throw new ExceptionDBerror("errore login db");
        }

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
