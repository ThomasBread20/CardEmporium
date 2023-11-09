package it.uniroma2.ispw.cardemporium.dao;

import it.uniroma2.ispw.cardemporium.filesystemdb.RegisterFS;
import it.uniroma2.ispw.cardemporium.exception.ExceptionBannedUser;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.ExceptionUserAlreadyExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionUserNotExist;
import it.uniroma2.ispw.cardemporium.users.Users;


public class DatabaseLoReFacade {
    LoginDAO login;
    RegisterDAODB register;
    RegisterFS registerFS;

    public void register(String user, String password, String name1, java.sql.Date date1, String surname1) throws  ExceptionUserAlreadyExist {
        register = new RegisterDAODB();

        register.addUser(user , password ,name1, date1, surname1);
    }
    public Users login(String user, String pwd) throws ExceptionUserNotExist, ExceptionDBerror, ExceptionBannedUser {
        login = new LoginDAO();

        return login.getUser(user, pwd);
    }
    public void registerfs(String user, String password, String name1, java.sql.Date date1, String surname1){
        registerFS=new RegisterFS();
        try {
            registerFS.addUser(user , password ,name1, date1, surname1);
        } catch (Exception e) {
            e.getCause();
        }
    }
}
