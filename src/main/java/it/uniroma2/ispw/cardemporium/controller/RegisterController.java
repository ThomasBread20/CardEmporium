package it.uniroma2.ispw.cardemporium.controller;



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
    private static Random random = new Random();



    public static void insertUserDao(String username, String passw, String name, java.sql.Date date, String surname) throws SQLException, ExceptionUserAlreadyExist, ExceptionDBerror {




        DatabaseLoReFacade register = new DatabaseLoReFacade();
        int rand=random.nextInt();

        if (rand % 2 == 0) {

            register.register(username, passw, name, date, surname);
        } else {
            register.registerfs(username, passw, name, date, surname);

        }


    }
}

