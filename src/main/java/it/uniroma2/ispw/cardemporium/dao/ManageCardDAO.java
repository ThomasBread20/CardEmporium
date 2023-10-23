package it.uniroma2.ispw.cardemporium.dao;

import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.model.CopiaCard;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManageCardDAO {
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    private Connection connCheck() throws ExceptionDBerror {
        Connection1Singelton conn = Connection1Singelton.getInstance();
        return conn.getConn();


    }
   // DataSingleton info = DataSingleton.getInstance();
    public ObservableList<CopiaCard> getCards(int id) throws SQLException, ExceptionCardNotExist, ExceptionDBerror {
        ObservableList<CopiaCard> Cards = FXCollections.observableArrayList();
        String sq = "CALL `showCards`(?)";
        System.out.println(2);
        Connection conn = connCheck();
        try {

            statement = conn.prepareCall(sq);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while(resultSet.next()){

                String nome = resultSet.getString(1);
                int v = resultSet.getInt(2);
                String nset = resultSet.getString(3);
                String cond = resultSet.getString(4);
                int q = resultSet.getInt(5);
                String lang = resultSet.getString(6);
                Double price = resultSet.getDouble(7);
                boolean firmato = resultSet.getBoolean(8);
                boolean foil = resultSet.getBoolean(9);
                boolean alterato = resultSet.getBoolean(10);
                boolean playset = resultSet.getBoolean(11);
                boolean first_edition = resultSet.getBoolean(12);
                boolean reverse_holo = resultSet.getBoolean(13);


                StringBuilder stringBuilder = new StringBuilder();

                if (firmato) {
                    stringBuilder.append("Fir");
                    stringBuilder.append(", ");
                }
                if (foil) {
                    stringBuilder.append("Foil");
                    stringBuilder.append(", ");
                }
                if (alterato) {
                    stringBuilder.append("Alt");
                    stringBuilder.append(", ");
                }
                if (playset) {
                    stringBuilder.append("Ps");
                    stringBuilder.append(", ");
                }
                if (first_edition) {
                    stringBuilder.append("Fe");
                    stringBuilder.append(", ");
                }
                if (reverse_holo) {
                    stringBuilder.append("Rh");
                    stringBuilder.append(", ");
                }

                String result = stringBuilder.toString();

                Cards.add(new CopiaCard(cond, price, nome, result, lang, v, nset, q));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


            return Cards;
        }

}
