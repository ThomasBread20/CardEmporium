package it.uniroma2.ispw.cardemporium.dao;



import it.uniroma2.ispw.cardemporium.business.DBconnection;
import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.ExceptionUserAlreadyExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionUserNotExist;
import it.uniroma2.ispw.cardemporium.model.CopiaCard;


import java.sql.*;
import java.util.ArrayList;

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
    public ArrayList<CopiaCard> getCard(String Name) throws ExceptionCardNotExist, SQLException, ExceptionDBerror {

        ArrayList<CopiaCard> Cards = new ArrayList();


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
                int utenteVenditore = resultSet.getInt("UtenteVenditore");
                int cartaSingolaID = resultSet.getInt("Carta_SingolaID");
                int cartaID = resultSet.getInt("Carta_ID");
                String nomeCarta = resultSet.getString("carta_NomeCarta");
                String nomeGioco = resultSet.getString("carta_setcarte_NomeGioco");
                CopiaCard card = new CopiaCard(condizione, prezzo, utenteVenditore, cartaSingolaID, cartaID, nomeCarta, nomeGioco);
                Cards.add(card);
                System.out.printf("set gioco" + Cards.get(0).getNomeGioco());

            }
            return Cards;
        }

    }
}