package it.uniroma2.ispw.cardemporium.dao;

import it.uniroma2.ispw.cardemporium.bean.ExtraBeanG;
import it.uniroma2.ispw.cardemporium.bean.ExtraBeanY;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetExtraDAO {
    private static final SearchCardDao instance = new SearchCardDao();


    boolean result;

    PreparedStatement statement = null;
    ResultSet resultSet = null;


    private Connection connCheck() throws ExceptionDBerror {
        Connection1Singelton conn = Connection1Singelton.getInstance();
        return conn.getConn();

    }




    public ExtraBeanG getExtra(int id) throws ExceptionDBerror {


        Connection conn = connCheck();


        int cardName = id;

        String sql = "CALL `getGame`(?)";

        try {

            statement = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            String nomeGioco = resultSet.getString("Gioco");

            String sql1 = "CALL `getEXTRA`(?)";


            statement = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            ExtraBeanG bean = new ExtraBeanG();

            bean.setAll(
                    resultSet.getBoolean("alterato"),
                    resultSet.getBoolean("firmato"),
                    resultSet.getBoolean("foil"),
                    resultSet.getBoolean("firt_edition"),
                    resultSet.getBoolean("reverse_holo"),
                    resultSet.getBoolean("playset")
            );

            return bean;

        }catch (SQLException e) {

            throw new ExceptionDBerror("");
        }



    }
}
