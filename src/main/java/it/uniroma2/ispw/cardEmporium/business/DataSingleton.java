package it.uniroma2.ispw.cardEmporium.business;

import java.util.Date;

public class DataSingleton {

    private String pwd;
    private String username;
    private String name;
    private String surname;
    private Date data;
    private boolean isBanned;
    private String role;

    private static final DataSingleton instance = new DataSingleton();

    public static DataSingleton getInstance(){
        return instance;
    }

    public void Users(String pwd, String username, String name, String surname, Date data, boolean isBanned) {
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


    public Date getData() {

        return data;
    }


    public String getName() {
        return name;

    }
    public String getSurname() {
        return surname;
    }

    public void setRole(String ruolo) {
        this.role = ruolo;
    }

    public String getRole(){
        return role;
    }


}
