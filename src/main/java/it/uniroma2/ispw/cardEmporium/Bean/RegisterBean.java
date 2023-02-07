package it.uniroma2.ispw.cardEmporium.Bean;

import java.time.LocalDate;
import java.util.Date;

public class RegisterBean {
    private String UsernameBean;

    private String Email;
    private String PasswdBean;
    public Boolean result;
    public Boolean validate;
    private String nameBean;
    private String cognomeBean;
    private java.sql.Date dateBean;
    private String seconda_password;

    private String Role;

    public String GetEmail(){
        return Email;
    }

    public void setEmail(String Email)
    {
        //inserire e-mail;
    }

    public String getPasswdBean() {

        return PasswdBean;
    }

    public void setPasswdBean(String passwdBean) {

        PasswdBean = passwdBean;
    }

    public String getUsernameBean() {
        return UsernameBean;
    }

    public void setUsernameBean(String usernameBean) {
        UsernameBean = usernameBean;
    }
    public boolean checkUsernameSyntax(String UsernameBean){

        return result;
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
    public Boolean check_Date(Date dateBean){
        return validate;
    }


    public String getSeconda_password() {

        return seconda_password;
    }

    public void setSeconda_password(String seconda_password) {

        this.seconda_password = seconda_password;
    }

    public void setRole(String ruolo){
        this.Role = ruolo;
    }

    public String getRole(){
        return Role;
    }
}
