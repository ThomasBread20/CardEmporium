package it.uniroma2.ispw.cardemporium.users;

import java.util.Date;

public class Amministratore extends Users{


    public Amministratore(String pwd, String username, String name, String surname, Date data, boolean isBanned) {
        super(pwd, username, name, surname, data,isBanned);
        this.setRole("Amministratore");
    }

    @Override
    public String getHomePage() {
        return "Schermata_home_admin";
    }



}
