package it.uniroma2.ispw.cardemporium.controller;



import it.uniroma2.ispw.cardemporium.bean.RegisterBean;
import it.uniroma2.ispw.cardemporium.dao.DatabaseLoReFacade;
import it.uniroma2.ispw.cardemporium.exception.ExceptionUserAlreadyExist;


public class RegisterController {


    public RegisterController() {
        //constructor
    }




    public void insertUserDao(RegisterBean registerValue) throws  ExceptionUserAlreadyExist {


        String username = registerValue.getUsernameBean();
        String passw = registerValue.getPasswdBean();
        String name = registerValue.getNameBean();
        java.sql.Date date = registerValue.getDateBean();
        String surname= registerValue.getCognomeBean();


        DatabaseLoReFacade register = new DatabaseLoReFacade();

        register.register(username, passw, name, date, surname);
        register.registerfs(username, passw, name, date, surname);



    }
}

