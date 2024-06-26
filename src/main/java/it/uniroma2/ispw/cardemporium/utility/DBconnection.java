package it.uniroma2.ispw.cardemporium.utility;

import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


import static it.uniroma2.ispw.cardemporium.utility.DBconstants.*;


public class DBconnection {

    //this is a SINGLETON
    private Connection conn;
    private static DBconnection bconnection=null;


    public Connection dbconnection() throws ExceptionDBerror {


        try (InputStream input = new FileInputStream("src/main/resources/DBProp.properties")){

            Properties properties = new Properties();

            properties.load(input);

            String dburl = properties.getProperty("DBURL");
            String user = properties.getProperty("USER");
            String passwd = properties.getProperty("PASSWD");


            Class.forName(DRIVER_CLASS_NAME);
            this.conn = DriverManager.getConnection(dburl,user,passwd);



        }catch(SQLException | IOException e){
            throw new ExceptionDBerror("");

        } catch (ClassNotFoundException e) {
            e.getMessage();
        }

        return null;
    }
    public Connection getConnection(){
        return conn;

    }
    public static DBconnection getDBInstance(){
        try{
            if((bconnection ==null) || bconnection.getConnection().isClosed()){
                bconnection =new DBconnection();
                bconnection.dbconnection();
            }
        }catch (Exception e){
            e.getCause();
        }
        return bconnection;
    }
}