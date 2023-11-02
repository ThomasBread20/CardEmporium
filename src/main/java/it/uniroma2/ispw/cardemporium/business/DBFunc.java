package it.uniroma2.ispw.cardemporium.business;

import java.sql.*;
import java.util.List;

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
    public static List<String> SearchCardtoSell(String str,int v) throws SQLException {
        Connection conn = connCheck();
        List<String> Carte = null;
        String sql2 = "DROP PROCEDURE IF EXISTS cardemporium.`Search-Card-to_sell`";
        statement = conn.prepareStatement(sql2);
        statement.execute();

        String q=SQL4;
        statement = conn.prepareStatement(q);
        statement.setString(1,str);
        statement.setInt(2,v);
        ResultSet rs=statement.executeQuery();
        while(rs.next()){
            Carte.add(rs.getString(1));
        }
        return Carte;
    }


}
