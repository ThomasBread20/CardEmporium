package it.uniroma2.ispw.cardemporium;

import it.uniroma2.ispw.cardemporium.business.DBconnection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import static it.uniroma2.ispw.cardemporium.business.DBconstants.*;

public class Main1 {


    public static void main(String[] args) {
        DBconnection instance;


        try (InputStream input = new FileInputStream("src/main/resources/DBProp.properties")) {


            Properties properties = new Properties();

            properties.load(input);

            String DBURLs = properties.getProperty("DBURL");
            String USERs = properties.getProperty("USER");
            String PASSWDs = properties.getProperty("PASSWD");


            Class.forName(DRIVER_CLASS_NAME);
            Connection conn = DriverManager.getConnection(DBURLs, USERs, PASSWDs);
            Logger.getLogger("Run").log(Level.INFO, "Database connesso");


        } catch (SQLException e) {

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}



