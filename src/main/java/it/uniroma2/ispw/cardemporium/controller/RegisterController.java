package it.uniroma2.ispw.cardemporium.controller;



import it.uniroma2.ispw.cardemporium.dao.DatabaseLoReFacade;
import it.uniroma2.ispw.cardemporium.exception.ExceptionUserAlreadyExist;
import it.uniroma2.ispw.cardemporium.exception.IllegalStateException;

import java.security.SecureRandom;

public class RegisterController {


    private RegisterController() throws IllegalStateException {
        throw new IllegalStateException("Utility class");
    }
    private static SecureRandom random = new SecureRandom();



    public static void insertUserDao(String username, String passw, String name, java.sql.Date date, String surname) throws  ExceptionUserAlreadyExist {




        DatabaseLoReFacade register = new DatabaseLoReFacade();
        int rand=random.nextInt();

        if (rand % 2 == 0) {

            register.register(username, passw, name, date, surname);
        } else {
            register.registerfs(username, passw, name, date, surname);

        }


    }
}

