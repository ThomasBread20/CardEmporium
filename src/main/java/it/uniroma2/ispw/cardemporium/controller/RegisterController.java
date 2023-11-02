package it.uniroma2.ispw.cardemporium.controller;



import it.uniroma2.ispw.cardemporium.FileSystemDB.RegisterFS;
import it.uniroma2.ispw.cardemporium.dao.DatabaseLoReFacade;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.ExceptionUserAlreadyExist;
import it.uniroma2.ispw.cardemporium.exception.IllegalStateException;

import java.sql.SQLException;
import java.util.Random;

public class RegisterController {

    private RegisterController() throws IllegalStateException {
        throw new IllegalStateException("Utility class");
    }


    public static void insertUserDao(String username, String passw, String name, java.sql.Date date, String surname ) throws SQLException, ExceptionUserAlreadyExist, ExceptionDBerror {
        Random random = new Random();

        int rand = random.nextInt();

        DatabaseLoReFacade register = new DatabaseLoReFacade();

        //  DatabaseLoReFacade register = new DatabaseLoReFacade();

        if (rand % 2 == 0) {

            register.Register(username, passw, name, date, surname);
        } else {
            register.Registerfs(username, passw, name, date, surname);

        }

        //register.Register(username, passw, name, date, surname);
    }
}

