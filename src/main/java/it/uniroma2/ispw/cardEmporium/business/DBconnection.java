package it.uniroma2.ispw.cardEmporium.business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static it.uniroma2.ispw.cardEmporium.business.DBconstants.*;

public class DBconnection {

    //this is a SINGLETON
    private Connection conn;
    private static DBconnection instance;
    public Connection DBconnection1(){
        try {
            Class.forName(DRIVER_CLASS_NAME);
            this.conn = DriverManager.getConnection(BD_URL,USER,PASSWD);
            //Logger.getLogger("Run").log(Level.INFO, "Database connesso");
            System.out.println("conn value: " + conn);

        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Exception Thrown: " + e);

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
                instance.DBconnection1();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return instance;
    }
}
