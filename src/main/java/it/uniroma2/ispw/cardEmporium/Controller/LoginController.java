package it.uniroma2.ispw.cardEmporium.Controller;

import it.uniroma2.ispw.cardEmporium.Bean.LoginBean;
import it.uniroma2.ispw.cardEmporium.Dao.LoginDAO;
import it.uniroma2.ispw.cardEmporium.Users.Users;
import it.uniroma2.ispw.cardEmporium.business.DataSingleton;
import it.uniroma2.ispw.cardEmporium.exception.ExceptionBannedUser;
import it.uniroma2.ispw.cardEmporium.exception.ExceptionUserNotExist;
import javafx.event.ActionEvent;

import java.sql.SQLException;
import java.util.Date;

public class LoginController
{

    ActionEvent event;

    public void setEvent(ActionEvent evento){
        event = evento;
    }

    public static Users checkUserDao(LoginBean ciao) throws ExceptionBannedUser, ExceptionUserNotExist {
        LoginDAO Login = new LoginDAO();

        return Login.getUser(ciao);
    }


    public static void DataFuller(String pwd, String username, String name, String surname, Date data, boolean isBanned, String role){
        DataSingleton info = DataSingleton.getInstance();
        info.Users(pwd, username, name, surname, data, isBanned);
        info.setRole(role);

    }

}
