package it.uniroma2.ispw.cardemporium.dao;



import it.uniroma2.ispw.cardemporium.business.DBconnection;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.model.CopiaCard;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.sql.*;

public class SearchCardDaoSingleton {

    private static final SearchCardDaoSingleton instance = new SearchCardDaoSingleton();

    public static SearchCardDaoSingleton getInstance(){
        return instance;}
    boolean result;

    PreparedStatement statement = null;
    ResultSet resultSet = null;


    private Connection connCheck()
    {
        return DBconnection.getDBInstance().getConnection();

    }
    public ObservableList<CopiaCard> getCard(String Name) throws ExceptionCardNotExist, SQLException, ExceptionDBerror {

        ObservableList<CopiaCard> Cards = FXCollections.observableArrayList();


        Connection conn = connCheck();


        String cardName = Name;

        String sql = "CALL `SearchCard`(?)";


        try {

            statement = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.setString(1, Name);
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
                String nomeGioco = resultSet.getString("carta_setcarte_NomeGioco");
                int versione = resultSet.getInt("carta_versione");
                String nomeSet = resultSet.getString("NomeSet");
                String lingua = resultSet.getString("Lingua");
                boolean carrello = resultSet.getBoolean("nel carrello");

                Cards.add(new CopiaCard(condizione, prezzo, utenteVenditore, cartaSingolaID, cartaID, nomeCarta, nomeGioco,lingua, versione, nomeSet, carrello));


            }
            return Cards;
        }

    }
}
