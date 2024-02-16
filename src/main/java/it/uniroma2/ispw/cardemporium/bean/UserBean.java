package it.uniroma2.ispw.cardemporium.bean;

import java.sql.Date;

public class UserBean {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private Integer id;
    private String name;
    private String surname;
    private Date date;
    public UserBean (Integer i){
        this.id=i;
    }


}
