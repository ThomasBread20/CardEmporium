package it.uniroma2.ispw.cardemporium.dao;

import it.uniroma2.ispw.cardemporium.business.DBconnection;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.model.CopiaCard;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShoppingCartDAOSingleton {
    private static final ShoppingCartDAOSingleton instance = new ShoppingCartDAOSingleton();

    public static ShoppingCartDAOSingleton getInstance(){
        return instance;}
    boolean result;

    PreparedStatement statement = null;
    ResultSet resultSet = null;


    private Connection connCheck()
    {
        return DBconnection.getDBInstance().getConnection();

    }

    public void SetCard(int ID, int UserID) throws ExceptionDBerror {

        Connection conn = connCheck();

        String sql = "CALL `PutCardIntoShoppingCart`(?,?)";


        try {

            statement = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.setInt(1, ID);
            statement.setInt(2, UserID);
            resultSet = statement.executeQuery();
        }catch (SQLException e) {

            throw new ExceptionDBerror("");
        }


    }

    public int getID(String username) throws ExceptionDBerror, SQLException {

        Connection conn = connCheck();

        String sql = "CALL `getID`(?)";


        try {

            statement = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.setString(1, username);
            resultSet = statement.executeQuery();
        }catch (SQLException e) {

            throw new ExceptionDBerror("");
        }

        while(resultSet.next()){
            return resultSet.getInt("utenti_ID");
        }

        return resultSet.getInt("utenti_ID");

    }

    public void detCard(int ID) throws ExceptionDBerror {

        Connection conn = connCheck();

        String sql = "CALL `RemoveCardFromShoppingCart`(?)";


        try {

            statement = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.setInt(1, ID);
            resultSet = statement.executeQuery();
        }catch (SQLException e) {

            throw new ExceptionDBerror("");
        }


    }
    public ObservableList<CopiaCard> getCard(int ID) throws ExceptionCardNotExist, SQLException, ExceptionDBerror {

        ObservableList<CopiaCard> Cards = FXCollections.observableArrayList();

        FilteredList<CopiaCard> filteredData = new FilteredList<>(Cards, b -> true);


        Connection conn = connCheck();


        int cardName = ID;

        String sql = "CALL `SearchCard`(?)";


        try {

            statement = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.setInt(1,ID);
            resultSet = statement.executeQuery();
        }catch (SQLException e) {

            throw new ExceptionDBerror("");
        }


        if (!resultSet.next()) {
            throw new ExceptionCardNotExist("Card does not exists");
        }else {
            resultSet.beforeFirst();

            while(resultSet.next())
            {

                String condizione = resultSet.getString("Condizione");
                double prezzo = resultSet.getDouble("Prezzo");
                String  utenteVenditore = resultSet.getString("Venditore");
                int cartaSingolaID = resultSet.getInt("Carta_SingolaID");
                int cartaID = resultSet.getInt("Carta_ID");
                String nomeCarta = resultSet.getString("NomeCarta");
                String nomeGioco = resultSet.getString("setcarte_NomeGioco");
                int versione = resultSet.getInt("versione");
                String nomeSet = resultSet.getString("NomeSet");
                String lingua = resultSet.getString("Lingua");
                boolean carrello = resultSet.getBoolean("nel_carrello");

                Cards.add(new CopiaCard(condizione, prezzo, utenteVenditore, cartaSingolaID, cartaID, nomeCarta, nomeGioco,lingua, versione, nomeSet, carrello));


            }
            return Cards;
        }

    }
}
