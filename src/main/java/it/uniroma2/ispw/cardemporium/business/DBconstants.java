package it.uniroma2.ispw.cardemporium.business;

public class DBconstants {
    private DBconstants(){}
    public static final String DRIVER_CLASS_NAME="com.mysql.cj.jdbc.Driver";




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
public static final String SQL4="""
                CREATE  PROCEDURE `Search-Card-to-Sell`(in Var_nome varchar(45), in Var_version int)
                BEGIN
                DECLARE EXIT HANDLER FOR SQLEXCEPTION
                BEGIN
                ROLLBACK; -- rollback any changes made in the transaction
                RESIGNAL; -- raise again the sql exception to the caller
                END;
                SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
                START TRANSACTION;
                SELECT NomeCarta FROM carta WHERE NomeCarta=%Var_nome% and Versione=Var_version;
                commit;
                END""";
public static final String SQL5="""
                CREATE  PROCEDURE `Expose`(in Var_nome varchar(45), in Var_version int,in var_prezzo float,in var_cond varchar(45),in var_lan varchar(45),in var_user varchar(45),in var_cardid int)
                BEGIN
                DECLARE EXIT HANDLER FOR SQLEXCEPTION
                BEGIN
                ROLLBACK; -- rollback any changes made in the transaction
                RESIGNAL; -- raise again the sql exception to the caller
                END;
                SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;
                START TRANSACTION;
                INSERT INTO copiacarta(Condizione,Prezzo,UtenteVenditore,carta_ID,carta_NomeCarta,carta_Versione,Lingua)
                VALUES (var_cond,var_prezzo,var_user,var_cardid,Var_nome,Var_version,var_lan);
                commit;
                END""";
}
