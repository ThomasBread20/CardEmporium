package it.uniroma2.ispw.cardemporium.utility;

import java.sql.*;

import static it.uniroma2.ispw.cardemporium.utility.DBconstants.*;

public class DBFunc {

    static PreparedStatement statement = null;
    private DBFunc() {
        throw new IllegalStateException("Utility class");
    }


    public static Connection connCheck()
    {
        return DBconnection.getDBInstance().getConnection();

    }

    public static void register() throws SQLException {

        Connection conn = connCheck();


        String sql2 = "DROP PROCEDURE IF EXISTS cardemporium.`Inserisci-Utente`";

        statement = conn.prepareStatement(sql2);
        statement.execute();


        statement = conn.prepareStatement(SQL3);
            statement.execute();

    }


}
