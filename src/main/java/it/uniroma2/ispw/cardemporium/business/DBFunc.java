package it.uniroma2.ispw.cardemporium.business;

import java.sql.*;

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



        String sql3 = """
                CREATE  PROCEDURE `Inserisci-Utente`(in Var_username varchar(45), in Var_Password varchar(45), in var_nome varchar(45), in Var_cognome varchar(45), in Var_data DATE)
                BEGIN
                    DECLARE EXIT HANDLER FOR SQLEXCEPTION
                    BEGIN
                        ROLLBACK; -- rollback any changes made in the transaction
                        RESIGNAL; -- raise again the sql exception to the caller
                    END;
                    SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;
                    START TRANSACTION;
                        Insert INTO utenti(Nome, Cognome, DataNascita ,Ruolo)   VALUES (var_nome, var_cognome, Var_data, \"Utente\");
                        INSERT INTO credenziali  VALUES (var_username, var_Password, last_insert_id());
                    commit;
                END""";

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
