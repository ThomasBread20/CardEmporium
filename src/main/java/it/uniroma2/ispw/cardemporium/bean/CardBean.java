package it.uniroma2.ispw.cardemporium.bean;

import it.uniroma2.ispw.cardemporium.controller.ExposeController;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
import it.uniroma2.ispw.cardemporium.exception.ExceptionUserAlreadyExist;
import it.uniroma2.ispw.cardemporium.model.Card;
import it.uniroma2.ispw.cardemporium.ui.SwitchPage;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.sql.SQLException;

public class CardBean {
    private String name_bean;
    private String setcard_bean;


    public CardBean(String name_bean, int version_bean , String game_bean,String setcard_bean) {
        this.name_bean = name_bean;
        this.setcard_bean = setcard_bean;
        this.version_bean = version_bean;
        this.game_bean = game_bean;
    }

    private int version_bean;
    private String game_bean;

    public String getName() {
        return name_bean;
    }

    public void setName(String name) {
        this.name_bean = name;

    }

    public String getSetcard_bean() {
        return setcard_bean;
    }

    public void setSetcard_bean(String setcard_bean) {
        this.setcard_bean = setcard_bean;
    }

    public int getVersion_bean() {
        return version_bean;
    }

    public void setVersion_bean(int version_bean) {
        this.version_bean = version_bean;
    }

    public String getGame_bean() {
        return game_bean;
    }

    public void setGame_bean(String game_bean) {
        this.game_bean = game_bean;
    }
    public Card showCard(ActionEvent actionEvent) throws ExceptionCardNotExist, ExceptionDBerror, IOException , ExceptionSwitchpage{

        SwitchPage sw=SwitchPage.getInstance();
        try {
            Card card= ExposeController.SearchAllCard(getName(),getVersion_bean(),getGame_bean(),getSetcard_bean());
            sw.switchPage("venditore3",actionEvent);
            return card;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ExceptionSwitchpage | SQLException | ExceptionUserAlreadyExist e) {
            throw new RuntimeException(e);
        }

    }
}
