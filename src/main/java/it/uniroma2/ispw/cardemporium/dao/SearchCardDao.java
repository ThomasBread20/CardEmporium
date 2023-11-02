package it.uniroma2.ispw.cardemporium.dao;



import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.model.CopiaCard;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.sql.*;

public class SearchCardDao {






    PreparedStatement statement = null;
    ResultSet resultSet = null;


    private Connection connCheck() throws ExceptionDBerror {
        Connection1Singelton conn = Connection1Singelton.getInstance();
        return conn.getConn();

    }
    public ObservableList<CopiaCard> getCard(String Name) throws ExceptionCardNotExist, SQLException, ExceptionDBerror {

        ObservableList<CopiaCard> copiaCards = FXCollections.observableArrayList();




        Connection conn = connCheck();




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
                int cartaID = resultSet.getInt("ValueID");
                String nomeCarta = resultSet.getString("NomeCarta");
                String nomeGioco = resultSet.getString("setcarte_NomeGioco");
                int versione = resultSet.getInt("versione");
                String nomeSet = resultSet.getString("NomeSet");
                String lingua = resultSet.getString("Lingua");
                boolean carrello = resultSet.getBoolean("nel_carrello");
                boolean firmato = resultSet.getBoolean("firmato");
                boolean foil = resultSet.getBoolean("foil");
                boolean alterato = resultSet.getBoolean("alterato");
                boolean playset = resultSet.getBoolean("playset");
                boolean firstedition = resultSet.getBoolean("first_edition");
                boolean reverseholo = resultSet.getBoolean("reverse_holo");
                boolean venduto = resultSet.getBoolean("venduto");


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








                copiaCards.add(new CopiaCard(condizione, prezzo, utenteVenditore, cartaSingolaID, cartaID, nomeCarta, nomeGioco,lingua, versione, nomeSet, carrello,result, venduto ));


            }
            return copiaCards;
        }

    }
}
