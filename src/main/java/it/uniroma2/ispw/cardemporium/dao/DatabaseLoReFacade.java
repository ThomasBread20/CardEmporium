package it.uniroma2.ispw.cardemporium.dao;

import it.uniroma2.ispw.cardemporium.exception.ExceptionBannedUser;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.ExceptionUserAlreadyExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionUserNotExist;
import it.uniroma2.ispw.cardemporium.users.Users;

import java.sql.SQLException;

public class DatabaseLoReFacade {
    LoginDAO login;
    RegisterDAO register;

    public void Register(String user, String password, String name1, java.sql.Date date1, String surname1) throws SQLException, ExceptionUserAlreadyExist, ExceptionDBerror {
        register = new RegisterDAO();

        register.addUser(user , password ,name1, date1, surname1);
    }
    public Users Login(String user, String pwd) throws ExceptionUserNotExist, ExceptionDBerror, ExceptionBannedUser {
        login = new LoginDAO();

        return login.getUser(user, pwd);
    }
}
