package it.uniroma2.ispw.cardemporium.dao.thomas;


import it.uniroma2.ispw.cardemporium.dao.Connection1Singelton;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.model.CarrelloEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShoppingCartDAO {



    PreparedStatement statement = null;
    ResultSet resultSet = null;


    private Connection connCheck()  {
        Connection1Singelton conn = Connection1Singelton.getInstance();
        return conn.getConn();

    }

    public void setCard(int id, int userID) throws ExceptionDBerror {

        Connection conn = connCheck();

        String sql = "CALL `PutCardIntoShoppingCart`(?,?)";


        try {

            statement = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.setInt(1, id);
            statement.setInt(2, userID);
            resultSet = statement.executeQuery();
        }catch (SQLException e) {

            throw new ExceptionDBerror("");
        }


    }

    public int getID(String username) throws ExceptionDBerror, SQLException {

        Connection conn = connCheck();


        String sql = "CALL getID(?)";




        try {

            statement = conn.prepareStatement(sql);

            statement.setString(1, username);
            resultSet = statement.executeQuery();


        }catch (SQLException e) {

            throw new ExceptionDBerror("");
        }

        resultSet.next();
        return resultSet.getInt("utenti_ID");


    }

    public void detCard(int id) throws ExceptionDBerror {

        Connection conn = connCheck();

        String sql = "CALL `RemoveCardFromShoppingCart`(?)";


        try {

            statement = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
        }catch (SQLException e) {

            throw new ExceptionDBerror("");
        }


    }
    public ObservableList<CarrelloEntity> getCard(int iD) throws  SQLException, ExceptionDBerror {

        ObservableList<CarrelloEntity> cardCarrellos = FXCollections.observableArrayList();



        Connection conn = connCheck();


        String sql = "CALL `SearchCardbyIDuser`(?)";


        try {

            statement = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.setInt(1, iD);
            resultSet = statement.executeQuery();
        }catch (SQLException e) {

            throw new ExceptionDBerror("");
        }




            while(resultSet.next())
            {

                int id = resultSet.getInt("Carta_SingolaID");
                double prezzo = resultSet.getDouble("copiacarta_Prezzo");
                String  utenteVenditore = resultSet.getString("NomeVenditore");
                int cartaSingolaID = resultSet.getInt("CartaC_SingolaID");
                String nomeCarta = resultSet.getString("NomeCarta");
                boolean firmato = resultSet.getBoolean("firmato");
                boolean foil = resultSet.getBoolean("foil");
                boolean alterato = resultSet.getBoolean("alterato");
                boolean playset = resultSet.getBoolean("playset");
                boolean firstedition = resultSet.getBoolean("first_edition");
                boolean reverseholo = resultSet.getBoolean("reverse_holo");



                StringBuilder stringBuilder = new StringBuilder();

                if (firmato){
                    stringBuilder.append("Fir");
                    stringBuilder.append(", ");
                }
                if (foil){
                    stringBuilder.append("Foil");
                    stringBuilder.append(", ");
                }
                if (alterato){
                    stringBuilder.append("Alt");
                    stringBuilder.append(", ");
                }
                if (playset){
                    stringBuilder.append("Ps");
                    stringBuilder.append(", ");
                }
                if (firstedition){
                    stringBuilder.append("Fe");
                    stringBuilder.append(", ");
                }
                if (reverseholo){
                    stringBuilder.append("Rh");
                    stringBuilder.append(", ");
                }

                String result = stringBuilder.toString();






                cardCarrellos.add(new CarrelloEntity(id, prezzo, utenteVenditore, cartaSingolaID, nomeCarta, result));


            }
            return cardCarrellos;
        }

    }

