package it.uniroma2.ispw.cardemporium.dao;

import it.uniroma2.ispw.cardemporium.business.DBconnection;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionUserAlreadyExist;
import it.uniroma2.ispw.cardemporium.model.Card;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchAllCardDAO {
    boolean result;

    PreparedStatement statement = null;
    ResultSet resultSet = null;

    private Connection connCheck() {
        return DBconnection.getDBInstance().getConnection();

    }

    public Card getAllCard(String Name, int ver, String gioco, String set) throws ExceptionUserAlreadyExist, SQLException, ExceptionCardNotExist {

        Connection conn = connCheck();


        String sql2 = "CALL `SearchAllCards`(?,?,?,?)";


        try {

            statement = conn.prepareCall(sql2);
            statement.setString(1, Name);
            statement.setInt(2, ver);
            statement.setString(3, gioco);
            statement.setString(4, set);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {

            throw new ExceptionUserAlreadyExist("");
        }

        if (!resultSet.next()) {
            throw new ExceptionCardNotExist("Card does not exists");
        } else {
            resultSet.beforeFirst();

            Integer CardID = resultSet.getInt(1);
            String CardName = resultSet.getString(2);
            int Version = resultSet.getInt(3);

            String nomeGioco = resultSet.getString(4);
            String nomeSet = resultSet.getString(5);
            Card card = new Card(CardID, CardName, Version, nomeGioco, nomeSet);


            return card;


        }
    }
}

