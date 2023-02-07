package it.uniroma2.ispw.cardemporium.business;

import java.sql.*;
import java.text.SimpleDateFormat;

public class DBFunc {

    static PreparedStatement statement = null;
    ResultSet resultSet = null;


    private static Connection connCheck()
    {
        Connection conn = DBconnection.getDBInstance().getConnection();
        return conn;
    }

    public static void Register() throws SQLException {

        Connection conn = connCheck();


        String sql2 = "DROP PROCEDURE IF EXISTS cardemporium.`Inserisci-Utente`";

        statement = conn.prepareStatement(sql2);
        statement.execute();

        System.out.printf("Funzione Register");

        String sql3 =
                "CREATE  PROCEDURE `Inserisci-Utente`(in Var_username varchar(45), in Var_Password varchar(45), in var_nome varchar(45), in Var_cognome varchar(45), in Var_data DATE)\n" +
                "BEGIN\n" +
                "\tDECLARE EXIT HANDLER FOR SQLEXCEPTION\n" +
                "\tBEGIN\n" +
                "\t\tROLLBACK; -- rollback any changes made in the transaction\n" +
                "\t\tRESIGNAL; -- raise again the sql exception to the caller\n" +
                "\tEND;\n" +
                "    SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;\n" +
                "\tSTART TRANSACTION;\n" +
                "\t\tInsert INTO utenti(Nome, Cognome, DataNascita ,Ruolo)   VALUES (var_nome, var_cognome, Var_data, \"Utente\");\n" +
                "\t\tINSERT INTO credenziali  VALUES (var_username, var_Password, last_insert_id());\n" +
                "\tcommit;\n" +
                "END";

            statement = conn.prepareStatement(sql3);
            statement.execute();

    }
    public static String getStringData(int Id,String element) throws SQLException {
        String value ;
        Connection conn = connCheck();
        String sql = "SELECT Nome,Cognome FROM utenti WHERE ID=?";
        statement = conn.prepareStatement(sql);
        statement.setInt(1, Id);
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
    public static Date ConvertDate(String date)throws Exception {

        Date date1 = (Date) new SimpleDateFormat("yyyy/MM/dd").parse(date);
        return date1;
    }
    public static Date getDateData(int Id) throws SQLException {

        Connection conn = connCheck();

        String sql="SELECT DataNascita FROM utenti WHERE ID=?";


        statement= conn.prepareStatement(sql);
        statement.setInt(1,Id);

        ResultSet rs=statement.executeQuery();
        rs.next();
        Date date = rs.getDate("DataNascita");
        return date;


    }

}
