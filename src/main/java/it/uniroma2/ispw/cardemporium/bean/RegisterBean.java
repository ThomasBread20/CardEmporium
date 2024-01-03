package it.uniroma2.ispw.cardemporium.bean;

import it.uniroma2.ispw.cardemporium.controller.RegisterController;
import it.uniroma2.ispw.cardemporium.exception.ExceptionUserAlreadyExist;

import java.time.LocalDate;

public class RegisterBean {
    private String usernameBean;


    private String passwdBean;

    private String nameBean;
    private String cognomeBean;
    private java.sql.Date dateBean;
    private String secondaPassword;

    private String role;


    public String getPasswdBean() {

        return passwdBean;
    }

    public void setPasswdBean(String passwdBean) {

        this.passwdBean = passwdBean;
    }

    public  String getUsernameBean() {
        return usernameBean;
    }

    public void setUsernameBean(String usernameBean) {
        this.usernameBean = usernameBean;
    }


    public String getNameBean() {

        return nameBean;
    }

    public void setNameBean(String nameBean) {

        this.nameBean = nameBean;
    }

    public String getCognomeBean() {

        return cognomeBean;
    }

    public void setCognomeBean(String cognomeBean) {

        this.cognomeBean = cognomeBean;
    }

    public java.sql.Date getDateBean() {

        return dateBean;
    }

    public void setDateBean(LocalDate dateBean) {

        java.sql.Date d = java.sql.Date.valueOf(dateBean);

        this.dateBean = d;
    }



    public String getSecondaPassword() {

        return secondaPassword;
    }

    public void setSecondaPassword(String secondaPassword) {

        this.secondaPassword = secondaPassword;
    }

    public void setRole(String ruolo){
        this.role = ruolo;
    }

    public String getRole(){
        return role;
    }


    public void beaninsertuserdao() throws  ExceptionUserAlreadyExist {

        RegisterController.insertUserDao(getUsernameBean(), getPasswdBean(), getNameBean(), getDateBean(), getCognomeBean());

    }
}
