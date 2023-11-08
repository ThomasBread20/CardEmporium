package it.uniroma2.ispw.cardemporium.users;

import it.uniroma2.ispw.cardemporium.exception.ExceptionBannedUser;
import it.uniroma2.ispw.cardemporium.exception.IllegalStateException;


public class UtenteFactory {

    private UtenteFactory() throws IllegalStateException {
        throw new IllegalStateException("Utility class");
    }


    public static Users getUser(Users user ) throws ExceptionBannedUser {

        switch (user.getRole()){
            case "Utente":

                  return new UtenteRegistrato(user.getPwd(), user.getUsername(), user.getName(), user.getSurname(),user.getData(), user.getIsBanned(), user.getID());


            case "Venditore":

                return new Venditore(user.getPwd(), user.getUsername(), user.getName(), user.getSurname(),user.getData(), user.getIsBanned(), user.getID());

            case "Amministratore":

                return   new Amministratore(user.getPwd(), user.getUsername(), user.getName(), user.getSurname(),user.getData(), user.getIsBanned(), user.getID());


            default:

                throw new ExceptionBannedUser("invalid type: " +  user.getRole());
        }


    }
}
