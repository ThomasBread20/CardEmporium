package it.uniroma2.ispw.cardemporium.controller;



import it.uniroma2.ispw.cardemporium.dao.DatabaseLoReFacade;
import it.uniroma2.ispw.cardemporium.dao.RegisterDAO;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.ExceptionUserAlreadyExist;
import it.uniroma2.ispw.cardemporium.exception.IllegalStateException;

import java.sql.SQLException;

public class RegisterController {

    private RegisterController() throws IllegalStateException {
        throw new IllegalStateException("Utility class");
    }


    public static void insertUserDao(String username, String passw, String name, java.sql.Date date, String surname ) throws SQLException, ExceptionUserAlreadyExist, ExceptionDBerror {

        DatabaseLoReFacade register = new DatabaseLoReFacade();


        register.Register(username, passw, name, date, surname);
    }
}

