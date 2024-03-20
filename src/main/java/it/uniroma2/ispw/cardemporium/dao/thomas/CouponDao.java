package it.uniroma2.ispw.cardemporium.dao.thomas;

import it.uniroma2.ispw.cardemporium.dao.Connection1Singelton;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CouponDao {

    PreparedStatement statement = null;
    ResultSet resultSet = null;


    private Connection connCheck()  {
        Connection1Singelton conn = Connection1Singelton.getInstance();
        return conn.getConn();

    }
    public List<String> getCoupons(int iduser) throws ExceptionDBerror, SQLException {

        Connection conn = connCheck();

        List<String> coupon = new ArrayList<>();


        String sql2 = "SELECT Name from Coupon join utenti_has_Coupon1 on Coupon_idCoupon = idCoupon WHERE utenti_ID = ? and Usable = 0";
        try {
            statement = conn.prepareCall(sql2, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.setInt(1, iduser);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {

            throw new ExceptionDBerror("");
        }

        while(resultSet.next())
        {
            String name = resultSet.getString("Name");

            coupon.add(name);

        }

        return coupon;

    }
}
