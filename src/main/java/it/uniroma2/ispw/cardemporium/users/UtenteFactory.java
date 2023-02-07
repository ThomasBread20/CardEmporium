package it.uniroma2.ispw.cardemporium.users;

import it.uniroma2.ispw.cardemporium.exception.ExceptionBannedUser;

import java.util.Date;

public class UtenteFactory {


    public static Users getUser(String pwd, String username, String name, String surname, Date data, boolean isBanned, String role ) throws ExceptionBannedUser {

        switch (role){
            case "Utente":

                return new UtenteRegistrato(pwd, username, name, surname, data,isBanned);

            case "Venditore":

                return new Venditore(pwd, username, name, surname, data,isBanned);

            case "Amministratore":

                return  new Amministratore(pwd, username, name, surname, data,isBanned);


            default:

                throw new ExceptionBannedUser("invalid type: " +  role);
        }


    }
}
