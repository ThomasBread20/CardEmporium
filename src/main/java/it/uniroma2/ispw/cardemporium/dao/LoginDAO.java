package it.uniroma2.ispw.cardemporium.dao;



import it.uniroma2.ispw.cardemporium.bean.LoginBean;
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
        Connection conn = DBconnection.getDBInstance().getConnection();
        return conn;
    }



    public Users getUser(LoginBean credential) throws ExceptionBannedUser, ExceptionUserNotExist {

        String username = credential.getUsernameBean();
        String Password = credential.getPasswdBean();
        String sql = "SELECT * FROM credenziali WHERE Username = ? and PasswordUtente = ? ";
        Connection conn = connCheck();
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, Password);
            resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                throw new ExceptionUserNotExist("User does not exists");
            }

            int ID = 0;
            ID = resultSet.getInt("utenti_ID");


            String sql2 = "SELECT * FROM utenti JOIN credenziali WHERE ID = ?;";
            String Role = null;

            statement = conn.prepareStatement(sql2);
            statement.setInt(1, ID);
            resultSet = statement.executeQuery();
            resultSet.next();
            if (resultSet.getBoolean("IsBanned")) {
                throw new ExceptionBannedUser("The User is Banned");
            } else {
                Users User = UtenteFactory.getUser(Password,
                        username,
                        resultSet.getString("Nome"),
                        resultSet.getString("Cognome"),
                        resultSet.getDate("DataNascita"),
                        resultSet.getBoolean("IsBanned"),
                        resultSet.getString("Ruolo")
                        );

                return User;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}


