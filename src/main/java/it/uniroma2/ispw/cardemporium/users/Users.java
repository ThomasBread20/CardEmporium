package it.uniroma2.ispw.cardemporium.users;

import java.util.Date;

public abstract class Users {

    private String pwd;
    private String username;
    private String name;
    private String surname;
    private Date data;

    private boolean isBanned;
    private String role;


    public Users(String pwd, String username, String name, String surname, Date data, boolean isBanned) {
        this.pwd = pwd;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.data = data;
        this.isBanned = isBanned;
    }

    public String getPwd() {
        return pwd;
    }


    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;

    }
    public String getSurname() {
        return surname;
    }
    public Date getData() {
        return data;
    }
    public Boolean getIsBanned() {
        return isBanned;
    }


    public void setRole(String ruolo) {
        this.role = ruolo;
    }

    public abstract String getHomePage();

    public abstract String getRole();


}
