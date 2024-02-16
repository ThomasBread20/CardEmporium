package it.uniroma2.ispw.cardemporium.dao;


import it.uniroma2.ispw.cardemporium.bean.UserBean;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
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

    private Connection connCheck()  {
        Connection1Singelton conn = Connection1Singelton.getInstance();
        return conn.getConn();


    }


    public ObservableList<CopiaCard> getCards(UserBean userBean) throws SQLException, ExceptionCardNotExist {
        ObservableList<CopiaCard> copiaCards = FXCollections.observableArrayList();
        String sq = "CALL `showCards`(?)";
        Connection conn = connCheck();
        Integer id=userBean.getId();
        try {

            statement = conn.prepareCall(sq);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();


        } catch (SQLException e) {
            e.getErrorCode();
        }

        while (resultSet.next()) {

            String nome = resultSet.getString(1);
            int v = resultSet.getInt(2);
            String nset = resultSet.getString(3);
            String cond = resultSet.getString(4);

            String lang = resultSet.getString(5);
            Double price = resultSet.getDouble(6);
            boolean firmato = resultSet.getBoolean(7);
            boolean foil = resultSet.getBoolean(8);
            boolean alterato = resultSet.getBoolean(9);
            boolean playset = resultSet.getBoolean(10);
            boolean firstedition = resultSet.getBoolean(11);
            boolean reverseholo = resultSet.getBoolean(12);


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
            if (firstedition) {
                stringBuilder.append("Fe");
                stringBuilder.append(", ");
            }
            if (reverseholo) {
                stringBuilder.append("Rh");
                stringBuilder.append(", ");
            }

            String result = stringBuilder.toString();

            copiaCards.add(new CopiaCard(cond, price, nome, result, lang, v, nset));


        }

        return copiaCards;
    }
}
