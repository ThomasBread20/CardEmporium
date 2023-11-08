package it.uniroma2.ispw.cardemporium.users;

import it.uniroma2.ispw.cardemporium.exception.ExceptionBannedUser;
import it.uniroma2.ispw.cardemporium.exception.IllegalStateException;

import java.util.Date;


public class UtenteFactory {

    private UtenteFactory() throws IllegalStateException {
        throw new IllegalStateException("Utility class");
    }


    public static Users getUser(String pass, String user, String name, String surname, Date datan, String role, int iD) throws ExceptionBannedUser {

        switch (role){
            case "Utente":

                  return new UtenteRegistrato(pass,user, name,  surname, datan, iD);


            case "Venditore":

                return new Venditore(pass,user, name,  surname, datan, iD);

            case "Amministratore":

                return   new Amministratore(pass,user, name,  surname, datan, iD);


            default:

                throw new ExceptionBannedUser("invalid type: " +  role);
        }


    }
}
