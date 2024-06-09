package it.uniroma2.ispw.cardemporium.controller;


import it.uniroma2.ispw.cardemporium.controller.thomas.ShoppingController;
import it.uniroma2.ispw.cardemporium.dao.DatabaseLoReFacade;

import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;

import it.uniroma2.ispw.cardemporium.users.Users;
import it.uniroma2.ispw.cardemporium.utility.DataSingleton;
import it.uniroma2.ispw.cardemporium.exception.ExceptionBannedUser;
import it.uniroma2.ispw.cardemporium.exception.ExceptionUserNotExist;
import javafx.event.ActionEvent;

import java.sql.SQLException;


public class LoginController
{

    public LoginController() {
        //constructor
    }
    ActionEvent event;

    public void setEvent(ActionEvent evento){
        event = evento;
    }

    public Users checkUser(String username, String passw) throws ExceptionBannedUser, ExceptionUserNotExist, ExceptionDBerror {
        DatabaseLoReFacade login = new DatabaseLoReFacade();

        try{
            return login.login(username, passw);
        }catch (ExceptionDBerror e){
            throw new ExceptionDBerror("ERRORE");
        }
    }


    private void dataFuller(Users user, String role){
        DataSingleton info = DataSingleton.getInstance();
        info.users(user.getPwd(), user.getUsername(), user.getName(), user.getSurname(), user.getData(), user.getIsBanned(), user.getID());
        info.setRole(role);

    }

    private void createShoppingCart() throws ExceptionCardNotExist, SQLException, ExceptionDBerror {

        ShoppingController shoppingController = new ShoppingController();
        shoppingController.initShoppingCart();
    }

    public Users login(String username, String pwd) throws ExceptionBannedUser, ExceptionUserNotExist, ExceptionDBerror, ExceptionCardNotExist, SQLException {
        Users user = checkUser(username, pwd);
        dataFuller(user, user.getRole());
        createShoppingCart();
        return user;
    }



}
