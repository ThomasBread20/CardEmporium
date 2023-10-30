package it.uniroma2.ispw.cardemporium.bean;

import it.uniroma2.ispw.cardemporium.controller.ExposeController;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
import it.uniroma2.ispw.cardemporium.exception.ExceptionUserAlreadyExist;
import it.uniroma2.ispw.cardemporium.model.Card;
import it.uniroma2.ispw.cardemporium.ui.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.sql.SQLException;

public class CardBean {
    private String name_bean;
    private String setcard_bean;


    public CardBean(String name_bean, int version_bean, String game_bean, String setcard_bean) {
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

    public ObservableList<Card> showCard(ActionEvent event) throws ExceptionCardNotExist, ExceptionDBerror, IOException, ExceptionSwitchpage {

        SwitchPage page = SwitchPage.getInstance();
        try {
            ObservableList<Card> obcard = ExposeController.SearchAllCard(getName(), getVersion_bean(), getGame_bean(), getSetcard_bean());
            if (getGame_bean() == "yugioh") {
                YugiohView yu = (YugiohView) page.switchPageseller(getGame_bean(), event);
                yu.populate_table(obcard);
            } else if (getGame_bean() == "poke") {
                pokemonView pv = (pokemonView) page.switchPageseller(getGame_bean(), event);
                pv.populate_table(obcard);
            } else if (getGame_bean() == "dg") {
                dgView dgv = (dgView) page.switchPageseller(getGame_bean(), event);
                dgv.populate_table(obcard);
            } else if (getGame_bean() == "magic") {
                magicView mv = (magicView) page.switchPageseller(getGame_bean(), event);
                mv.populate_table(obcard);



            }
            return obcard;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ExceptionUserAlreadyExist e) {
            throw new RuntimeException(e);
        }

    }
}
