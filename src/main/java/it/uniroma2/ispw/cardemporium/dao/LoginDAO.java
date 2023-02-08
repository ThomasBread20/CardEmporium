package it.uniroma2.ispw.cardemporium.dao;



import it.uniroma2.ispw.cardemporium.bean.LoginBean;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.users.Users;
import it.uniroma2.ispw.cardemporium.users.UtenteFactory;
import it.uniroma2.ispw.cardemporium.business.DBconnection;
import it.uniroma2.ispw.cardemporium.exception.ExceptionBannedUser;
import it.uniroma2.ispw.cardemporium.exception.ExceptionUserNotExist;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    boolean result;

    PreparedStatement statement = null;
    ResultSet resultSet = null;


    private Connection connCheck()
    {
        return DBconnection.getDBInstance().getConnection();

    }



    public Users getUser(LoginBean credential) throws ExceptionBannedUser, ExceptionUserNotExist, ExceptionDBerror {

        String username = credential.getUsernameBean();
        String password = credential.getPasswdBean();
        String sql = "SELECT * FROM credenziali WHERE Username = ? and PasswordUtente = ? ";
        Connection conn = connCheck();
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                throw new ExceptionUserNotExist("User does not exists");
            }

            int id = 0;
            id = resultSet.getInt("utenti_ID");


            String sql2 = "SELECT * FROM utenti JOIN credenziali WHERE ID = ?;";


            statement = conn.prepareStatement(sql2);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            resultSet.next();
            if (resultSet.getBoolean("IsBanned")) {
                throw new ExceptionBannedUser("The User is Banned");
            } else {
                return  UtenteFactory.getUser(password,
                        username,
                        resultSet.getString("Nome"),
                        resultSet.getString("Cognome"),
                        resultSet.getDate("DataNascita"),
                        resultSet.getBoolean("IsBanned"),
                        resultSet.getString("Ruolo")
                        );

            }
        } catch (SQLException e) {
            throw new ExceptionDBerror("");
        }

    }
}


