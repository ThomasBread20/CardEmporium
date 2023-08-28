package it.uniroma2.ispw.cardemporium.dao;



import it.uniroma2.ispw.cardemporium.business.DBFunc;
import it.uniroma2.ispw.cardemporium.business.DBconnection;
import it.uniroma2.ispw.cardemporium.exception.ExceptionUserAlreadyExist;
import it.uniroma2.ispw.cardemporium.model.CopiaCard;
import it.uniroma2.ispw.cardemporium.users.Users;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SearchCardDao {
    boolean result;

    PreparedStatement statement = null;
    ResultSet resultSet = null;


    private Connection connCheck()
    {
        return DBconnection.getDBInstance().getConnection();

    }
    public ArrayList<CopiaCard> getCard(String Name) throws ExceptionUserAlreadyExist, SQLException {

        ArrayList<CopiaCard> Cards = new ArrayList();


        Connection conn = connCheck();


        String cardName = Name;

        String sql = "CALL `SearchCard`(?)";


        try {

            statement = conn.prepareCall(sql);
            statement.setString(1, Name);
            resultSet = statement.executeQuery();
        }catch (SQLException e) {

            throw new ExceptionUserAlreadyExist("");
        }

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
        }
            return Cards;


    }
}
