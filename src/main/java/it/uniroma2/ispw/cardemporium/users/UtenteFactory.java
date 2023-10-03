package it.uniroma2.ispw.cardemporium.users;

import it.uniroma2.ispw.cardemporium.exception.ExceptionBannedUser;
import it.uniroma2.ispw.cardemporium.exception.IllegalStateException;

import java.util.Date;

public class UtenteFactory {

    private UtenteFactory() throws IllegalStateException {
        throw new IllegalStateException("Utility class");
    }


    public static Users getUser(String pwd, String username, String name, String surname, Date data, boolean isBanned, String role, int id ) throws ExceptionBannedUser {

        switch (role){
            case "Utente":

                return new UtenteRegistrato(pwd, username, name, surname, data,isBanned, id);

            case "Venditore":

                return new Venditore(pwd, username, name, surname, data,isBanned, id);

            case "Amministratore":

                return  new Amministratore(pwd, username, name, surname, data,isBanned, id);


            default:

                throw new ExceptionBannedUser("invalid type: " +  role);
        }


    }
}
