package it.uniroma2.ispw.cardemporium.business;

import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static it.uniroma2.ispw.cardemporium.business.DBconstants.*;

public class DBconnection {

    //this is a SINGLETON
    private Connection conn;
    private static DBconnection instance;
    public Connection dbconnection() throws ExceptionDBerror {
        try {
            Class.forName(DRIVER_CLASS_NAME);
            this.conn = DriverManager.getConnection(DBURL,USER,PASSWD);

        }catch(ClassNotFoundException | SQLException e){
            throw new ExceptionDBerror("");

        }

        return null;
    }
    public Connection getConnection(){
        return conn;

    }
    public static DBconnection getDBInstance(){
        try{
            if((instance==null) || instance.getConnection().isClosed()){
                instance=new DBconnection();
                instance.dbconnection();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return instance;
    }
}
