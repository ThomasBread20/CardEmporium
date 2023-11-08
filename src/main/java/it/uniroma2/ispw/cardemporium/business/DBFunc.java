package it.uniroma2.ispw.cardemporium.business;

import java.sql.*;

import static it.uniroma2.ispw.cardemporium.business.DBconstants.*;

public class DBFunc {

    static PreparedStatement statement = null;
    ResultSet resultSet = null;


    public static Connection connCheck()
    {
        return DBconnection.getDBInstance().getConnection();

    }

    public static void register() throws SQLException {

        Connection conn = connCheck();


        String sql2 = "DROP PROCEDURE IF EXISTS cardemporium.`Inserisci-Utente`";

        statement = conn.prepareStatement(sql2);
        statement.execute();


        String sql3 = SQL3;

            statement = conn.prepareStatement(sql3);
            statement.execute();

    }


}
