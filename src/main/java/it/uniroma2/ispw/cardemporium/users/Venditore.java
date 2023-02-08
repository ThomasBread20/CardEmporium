package it.uniroma2.ispw.cardemporium.users;

import java.util.Date;

public class Venditore extends Users {

    public Venditore(String pwd, String username, String name, String surname, Date data, boolean isBanned) {
        super(pwd, username, name, surname, data, isBanned);
        this.setRole("Venditore");
    }

    @Override
    public String getHomePage() {
        return "schermata_home_registrato";
    }



}
