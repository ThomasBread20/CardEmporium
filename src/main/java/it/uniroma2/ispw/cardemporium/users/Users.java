package it.uniroma2.ispw.cardemporium.users;

import java.util.Date;

public abstract class Users {

    private String pwd;
    private String username;



    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }




    private int id;
    private String name;
    private String surname;
    private Date data;

    private boolean isBanned;

    private String ruolo;





    protected Users(String pwd, String username, String name, String surname, Date data, int iD) {
        this.pwd = pwd;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.data = data;
        this.isBanned = true;
        this.id = iD;
    }

    public int getID() {
        return id;
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


    public void setRole(String value) {
        this.ruolo = value;
    }
    public String getRole(){ return ruolo;}

    public abstract String getHomePage();




}
