package it.uniroma2.ispw.cardemporium.dao.thomas;


import it.uniroma2.ispw.cardemporium.dao.Connection1Singelton;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BuyCardDAODB implements BuyCardDao{



    PreparedStatement statement = null;
    ResultSet resultSet = null;


    private Connection connCheck()  {
        Connection1Singelton conn = Connection1Singelton.getInstance();
        return conn.getConn();

    }

    public void buyCard(int id, int user) throws ExceptionDBerror {
        Connection conn = connCheck();

        String sql = "CALL `shopping`(?,?)";

        try {

            statement = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.setInt(1, id);
            statement.setInt(2, user);

            resultSet = statement.executeQuery();
        }catch (SQLException e) {

            throw new ExceptionDBerror("");
        }


    }
}
