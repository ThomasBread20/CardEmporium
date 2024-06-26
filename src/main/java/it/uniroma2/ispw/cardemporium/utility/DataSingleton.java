package it.uniroma2.ispw.cardemporium.utility;

import java.util.Date;

public class DataSingleton {

    private String pwd;
    private String username;
    private String name;
    private String surname;
    private Date data;
    private boolean isBanned;
    private String role;

    private int userID;

    private static  DataSingleton  instance =null;




    public static DataSingleton getInstance(){
        if(instance==null){
            instance=new DataSingleton();
        }
        return instance;
    }
    private DataSingleton(){}

    public void users(String pwd, String username, String name, String surname, Date data, boolean isBanned, int userID) {
        this.pwd = pwd;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.data = data;
        this.isBanned = isBanned;
        this.userID = userID;
    }


    public Integer getID() {
        return userID;
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
