package it.uniroma2.ispw.cardemporium.business;

import java.sql.*;

import static it.uniroma2.ispw.cardemporium.business.DBconstants.*;

public class DBFunc {

    static PreparedStatement statement = null;
    ResultSet resultSet = null;


    private static Connection connCheck()
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
    public static String getStringData(int id,String element) throws SQLException {
        String value ;
        Connection conn = connCheck();
        String sql = "SELECT Nome,Cognome FROM utenti WHERE ID=?";
        statement = conn.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        if(element.equals("Nome")) {
            rs.next();
            value = rs.getString("Nome");

            return value;
        }else if(element.equals("Cognome")){
            rs.next();
            value = rs.getString("Cognome");

            return value;
        }else return "error dato inserito è sbagliato";

    }

    public static Date getDateData(int id) throws SQLException {

        Connection conn = connCheck();

        String sql="SELECT DataNascita FROM utenti WHERE ID=?";


        statement= conn.prepareStatement(sql);
        statement.setInt(1,id);

        ResultSet rs=statement.executeQuery();
        rs.next();
        return rs.getDate("DataNascita");



    }

}
