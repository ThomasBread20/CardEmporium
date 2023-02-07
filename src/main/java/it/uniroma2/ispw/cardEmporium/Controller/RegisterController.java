package it.uniroma2.ispw.cardEmporium.Controller;


import it.uniroma2.ispw.cardEmporium.Bean.RegisterBean;
import it.uniroma2.ispw.cardEmporium.Dao.LoginDAO;
import it.uniroma2.ispw.cardEmporium.Dao.RegisterDAO;
import it.uniroma2.ispw.cardEmporium.exception.ExceptionUserAlreadyExist;

import java.sql.SQLException;

public class RegisterController {


    public static Boolean insertUserDao(RegisterBean credential) throws SQLException, ExceptionUserAlreadyExist {
        RegisterDAO register = new RegisterDAO();


        return register.addUser(credential);
    }
}

