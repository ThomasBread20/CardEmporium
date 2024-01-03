package it.uniroma2.ispw.cardemporium.bean;

import it.uniroma2.ispw.cardemporium.controller.ExposeController;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
import it.uniroma2.ispw.cardemporium.model.Card;
import it.uniroma2.ispw.cardemporium.ui.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;


import java.sql.SQLException;

public class CardBean {
    private String namebean;
    private String setcardbean;


    public CardBean(String namebean, int versionbean, String gamebean, String setcardbean) {
        this.namebean = namebean;
        this.setcardbean = setcardbean;
        this.versionbean = versionbean;
        this.gamebean = gamebean;
    }

    private int versionbean;
    private String gamebean;

    public String getName() {
        return namebean;
    }

    public void setName(String name) {
        this.namebean = name;

    }

    public String getSetcardbean() {
        return setcardbean;
    }

    public void setSetcardbean(String setcardbean) {
        this.setcardbean = setcardbean;
    }

    public int getVersionbean() {
        return versionbean;
    }

    public void setVersionbean(int versionbean) {
        this.versionbean = versionbean;
    }

    public String getGameBean() {
        return gamebean;
    }

    public void setGamebean(String gamebean) {
        this.gamebean = gamebean;
    }


}
