package it.uniroma2.ispw.cardemporium.controller;


import it.uniroma2.ispw.cardemporium.dao.DatabaseLoReFacade;

import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;

import it.uniroma2.ispw.cardemporium.ui.Carrelloview;
import it.uniroma2.ispw.cardemporium.users.Users;
import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.exception.ExceptionBannedUser;
import it.uniroma2.ispw.cardemporium.exception.ExceptionUserNotExist;
import javafx.event.ActionEvent;



public class LoginController
{

    ActionEvent event;

    public void setEvent(ActionEvent evento){
        event = evento;
    }

    public Users checkUserDao(String username, String passw) throws ExceptionBannedUser, ExceptionUserNotExist, ExceptionDBerror {
        DatabaseLoReFacade login = new DatabaseLoReFacade();

        try{
            return login.login(username, passw);
        }catch (ExceptionDBerror e){
            throw new ExceptionDBerror("ERRORE");
        }
    }


    public void dataFuller(Users user, String role){
        DataSingleton info = DataSingleton.getInstance();
        info.users(user.getPwd(), user.getUsername(), user.getName(), user.getSurname(), user.getData(), user.getIsBanned(), user.getID());
        info.setRole(role);

    }

    public void createShoppingCart(){

        new Carrelloview();
    }




}
