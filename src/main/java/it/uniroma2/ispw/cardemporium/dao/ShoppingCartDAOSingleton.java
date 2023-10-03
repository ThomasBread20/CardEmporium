package it.uniroma2.ispw.cardemporium.dao;

import it.uniroma2.ispw.cardemporium.business.DBconnection;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.model.CopiaCard;
import it.uniroma2.ispw.cardemporium.model.CopiaCardCarrello;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShoppingCartDAOSingleton {

    boolean result;

    PreparedStatement statement = null;
    ResultSet resultSet = null;


    private Connection connCheck() throws ExceptionDBerror {
        Connection1Singelton conn = Connection1Singelton.getInstance();
        return conn.getConn();

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
    public ObservableList<CopiaCardCarrello> getCard(int ID) throws ExceptionCardNotExist, SQLException, ExceptionDBerror {

        ObservableList<CopiaCardCarrello> Cards = FXCollections.observableArrayList();



        Connection conn = connCheck();


        int cardName = ID;

        String sql = "CALL `SearchCardbyIDuser`(?)";


        try {

            statement = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.setInt(1,cardName);
            resultSet = statement.executeQuery();
        }catch (SQLException e) {

            throw new ExceptionDBerror("");
        }




            while(resultSet.next())
            {

                int Id = resultSet.getInt("Carta_SingolaID");
                double prezzo = resultSet.getDouble("copiacarta_Prezzo");
                String  utenteVenditore = resultSet.getString("NomeVenditore");
                int cartaSingolaID = resultSet.getInt("Carta_SingolaID");
                String nomeCarta = resultSet.getString("NomeCarta");


                Cards.add(new CopiaCardCarrello(Id, prezzo, utenteVenditore, cartaSingolaID, nomeCarta));


            }
            return Cards;
        }

    }

