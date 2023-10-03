package it.uniroma2.ispw.cardemporium.users;

import java.util.Date;

public class UtenteRegistrato extends Users{

    public UtenteRegistrato(String pwd, String username, String name, String surname, Date data, boolean isBanned, int id) {
        super(pwd, username, name, surname, data, isBanned, id);
        this.setRole("Utente");
    }

    @Override
    public String getHomePage() {
        return "Schermata_home_registrato";
    }



}
