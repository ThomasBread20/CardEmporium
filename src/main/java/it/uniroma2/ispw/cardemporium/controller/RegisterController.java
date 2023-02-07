package it.uniroma2.ispw.cardemporium.controller;


import it.uniroma2.ispw.cardemporium.bean.RegisterBean;
import it.uniroma2.ispw.cardemporium.dao.RegisterDAO;
import it.uniroma2.ispw.cardemporium.exception.ExceptionUserAlreadyExist;

import java.sql.SQLException;

public class RegisterController {


    public static Boolean insertUserDao(RegisterBean credential) throws SQLException, ExceptionUserAlreadyExist {
        RegisterDAO register = new RegisterDAO();


        return register.addUser(credential);
    }
}

