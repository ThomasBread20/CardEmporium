package it.uniroma2.ispw.cardemporium.bean;

import it.uniroma2.ispw.cardemporium.controller.ExposeController;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import javafx.event.ActionEvent;

public class CardInfoBean {
    private int id;
    private String nome;
    private Integer versione;
    private String gioco;
    private String set;
    private String condition;
    private Float price;
    private Integer quantity;

    public CardInfoBean(int id, String nome, Integer versione, String gioco, String set, String condition, Float price, Integer quantity, String language) {
        this.id = id;
        this.nome = nome;
        this.versione = versione;
        this.gioco = gioco;
        this.set = set;
        this.condition = condition;
        this.price = price;
        this.quantity = quantity;
        this.language = language;
    }

    private String language;
    public void getInfo(){}//QUI CI METTO QUELLO CHE NON ENTRA DI SOTTO E LO PASSO AL CONTROLLER


    public CardInfoBean(String condition, Float price, Integer quantity, String language) {
        this.condition = condition;
        this.price = price;
        this.quantity = quantity;
        this.language = language;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    public Boolean InsertCard(ActionEvent actionEvent) throws ExceptionDBerror {

        ExposeController.ExposeOnMarket(getPrice(),getQuantity(),getLanguage(),getCondition(),getId(),getNome(),getVersione(),getGioco(),getSet());
        return true;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVersione() {
        return versione;
    }

    public void setVersione(Integer versione) {
        this.versione = versione;
    }

    public String getGioco() {
        return gioco;
    }

    public void setGioco(String gioco) {
        this.gioco = gioco;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }
}
