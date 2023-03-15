package it.uniroma2.ispw.cardemporium.business;

public class DBconstants {
    private DBconstants(){}
    public static final String DRIVER_CLASS_NAME="com.mysql.cj.jdbc.Driver";

    public static final String DBURL ="jdbc:mysql://localhost:3306/cardemporium?AutoReconnector=true&useSSL=false";
    public static final String PASSWD="Ispw66!!";
    public static final String USER="CardEmporium";


    public static final String SQL3 = """
                CREATE  PROCEDURE `Inserisci-Utente`(in Var_username varchar(45), in Var_Password varchar(45), in var_nome varchar(45), in Var_cognome varchar(45), in Var_data DATE)
                BEGIN
                DECLARE EXIT HANDLER FOR SQLEXCEPTION
                BEGIN
                ROLLBACK; -- rollback any changes made in the transaction
                RESIGNAL; -- raise again the sql exception to the caller
                END;
                SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;
                START TRANSACTION;
                Insert INTO utenti(Nome, Cognome, DataNascita ,Ruolo)   VALUES (var_nome, var_cognome, Var_data, "Utente");
                INSERT INTO credenziali  VALUES (var_username, var_Password, last_insert_id());
                commit;
                END""";
}
