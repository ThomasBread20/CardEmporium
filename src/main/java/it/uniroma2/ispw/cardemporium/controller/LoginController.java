package it.uniroma2.ispw.cardemporium.controller;


import it.uniroma2.ispw.cardemporium.dao.LoginDAO;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;

import it.uniroma2.ispw.cardemporium.ui.Carrelloview;
import it.uniroma2.ispw.cardemporium.users.Users;
import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.exception.ExceptionBannedUser;
import it.uniroma2.ispw.cardemporium.exception.ExceptionUserNotExist;
import javafx.event.ActionEvent;


import java.util.Date;

public class LoginController
{

    ActionEvent event;

    public void setEvent(ActionEvent evento){
        event = evento;
    }

    public static Users checkUserDao(String username, String passw) throws ExceptionBannedUser, ExceptionUserNotExist, ExceptionDBerror {
        LoginDAO login = new LoginDAO();

        try{
            return login.getUser(username, passw);
        }catch (ExceptionDBerror e){
            throw new ExceptionDBerror("ERRORE");
        }
    }


    public static void dataFuller(String pwd, String username, String name, String surname, Date data, boolean isBanned, String role){
        DataSingleton info = DataSingleton.getInstance();
        info.users(pwd, username, name, surname, data, isBanned);
        info.setRole(role);

    }

    public static void createShoppingCart(){
        Carrelloview Carrell = new Carrelloview();
    }




}
