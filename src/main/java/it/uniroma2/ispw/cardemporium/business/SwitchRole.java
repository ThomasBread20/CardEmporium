package it.uniroma2.ispw.cardemporium.business;

import it.uniroma2.ispw.cardemporium.exception.ExceptionBannedUser;

public class SwitchRole {

    public static String switchRole(int value) throws ExceptionBannedUser {

        switch (value){
            case 1:
                return "Utente";

            case 2:
                return "Venditore";

            case 3:
                return "Amministratore";

            default:
                throw new ExceptionBannedUser("invalid Role");

        }
    }
}
