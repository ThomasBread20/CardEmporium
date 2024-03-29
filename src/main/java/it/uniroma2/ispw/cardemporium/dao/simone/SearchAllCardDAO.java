package it.uniroma2.ispw.cardemporium.dao.simone;


import it.uniroma2.ispw.cardemporium.bean.simone.CardBean;
import it.uniroma2.ispw.cardemporium.dao.Connection1Singelton;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;

import it.uniroma2.ispw.cardemporium.model.simone.Card;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SearchAllCardDAO {

    PreparedStatement statement = null;
    ResultSet resultSet = null;

    private Connection connCheck()  {
        Connection1Singelton conn = Connection1Singelton.getInstance();
        return conn.getConn();

    }

    public ObservableList<Card> getAllCard(CardBean cardBean) throws  SQLException, ExceptionCardNotExist, ExceptionDBerror {

        Connection conn = connCheck();
        String name= cardBean.getName();
        Integer ver= cardBean.getVersionbean();
        String gioco= cardBean.getGameBean();
        String set=cardBean.getSetcardbean();

        ObservableList<Card> cards = FXCollections.observableArrayList();

        String sql2 = "CALL `SearchAllCards`(?,?,?,?)";


        try {

            statement = conn.prepareCall(sql2);
            statement.setString(1, name);
            statement.setInt(2, ver);
            statement.setString(3, gioco);
            statement.setString(4, set);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {

            throw new ExceptionDBerror("");
        }

        if (!resultSet.next()) {
            throw new ExceptionCardNotExist("Card does not exists");
        } else {


            Integer cardid = resultSet.getInt(1);

            String cardName = resultSet.getString(2);
            int version = resultSet.getInt(3);

            String nomeGioco = resultSet.getString(4);
            String nomeSet = resultSet.getString(5);
            cards.add(new Card(cardid, cardName, version, nomeGioco, nomeSet));


            return cards;


        }
    }
}

