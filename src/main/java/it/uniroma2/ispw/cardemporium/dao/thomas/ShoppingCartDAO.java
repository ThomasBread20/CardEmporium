package it.uniroma2.ispw.cardemporium.dao.thomas;


import it.uniroma2.ispw.cardemporium.controller.thomas.CardInfo;
import it.uniroma2.ispw.cardemporium.dao.Connection1Singelton;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.model.CardEntity;
import it.uniroma2.ispw.cardemporium.model.ShoppingCartEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDAO {



    PreparedStatement statement = null;
    ResultSet resultSet = null;


    private Connection connCheck()  {
        Connection1Singelton conn = Connection1Singelton.getInstance();
        return conn.getConn();

    }

    public void putCardintoShoppingCart(CardInfo bean) throws ExceptionDBerror {

        Connection conn = connCheck();

        int idCard = bean.getCartaSingolaID();


        String sql = "CALL putCardintoShoppingCart(?,?,?,?,?,?)";


        try {

            statement = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.setInt(1, bean.getiDvenditore());
            statement.setString(2, bean.getUtenteVenditore());
            statement.setInt(3, idCard);
            statement.setDouble(4, bean.getPrezzo());
            statement.setString(5, bean.getNomeCarta());
            statement.setInt(6, bean.getIduser());
            resultSet = statement.executeQuery();
        }catch (SQLException e) {

            throw new ExceptionDBerror("");
        }


    }

    public void updateCard(CardInfo bean) throws ExceptionDBerror {

        Connection conn = connCheck();

        int idCard = bean.getCartaSingolaID();


        String sql2 =   "CALL updateCardIntoShoppingCart(?)";
        try {
            statement = conn.prepareCall(sql2, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.setInt(1, idCard);
            resultSet = statement.executeQuery();
        }catch (SQLException e) {

            throw new ExceptionDBerror("");
        }
    }



    public void detCard(int id) throws ExceptionDBerror {

        Connection conn = connCheck();

        String sql = "CALL `RemoveCardFromShoppingCart`(?)";


        try {

            statement = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
        }catch (SQLException e) {

            throw new ExceptionDBerror("");
        }


    }
    public void getCardbyIdUser(int iD) throws  SQLException, ExceptionDBerror {



        List<CardEntity> cardCarrellos = new ArrayList<>() ;


        Connection conn = connCheck();


        String sql = """
                select Carta_SingolaID, copiacarta_Prezzo, NomeVenditore, IDvenditore, carta_ValueID, NomeCarta, Lingua, carta_Versione,Condizione, firmato, foil, alterato, playset, first_edition, reverse_holo
                  from carrello join copiacarta on carrello.CartaC_SingolaID = copiacarta.Carta_SingolaID
                   where IDutente = ?;""";


        try {

            statement = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.setInt(1, iD);
            resultSet = statement.executeQuery();
        }catch (SQLException e) {

            throw new ExceptionDBerror("");
        }




            while(resultSet.next())
            {
                String condizione = resultSet.getString("Condizione");
                int versione = resultSet.getInt("carta_Versione");
                int cartaSingolaID = resultSet.getInt("Carta_SingolaID");
                double prezzo = resultSet.getDouble("copiacarta_Prezzo");
                String  utenteVenditore = resultSet.getString("NomeVenditore");
                int cartaSingolaIDc = resultSet.getInt("carta_ValueID");
                String nomeCarta = resultSet.getString("NomeCarta");
                String lingua = resultSet.getString("Lingua");
                boolean firmato = resultSet.getBoolean("firmato");
                boolean foil = resultSet.getBoolean("foil");
                boolean alterato = resultSet.getBoolean("alterato");
                boolean playset = resultSet.getBoolean("playset");
                boolean firstedition = resultSet.getBoolean("first_edition");
                boolean reverseholo = resultSet.getBoolean("reverse_holo");
                int idseller = resultSet.getInt("IDvenditore");



                StringBuilder stringBuilder = new StringBuilder();

                if (firmato){
                    stringBuilder.append("Fir");
                    stringBuilder.append(", ");
                }
                if (foil){
                    stringBuilder.append("Foil");
                    stringBuilder.append(", ");
                }
                if (alterato){
                    stringBuilder.append("Alt");
                    stringBuilder.append(", ");
                }
                if (playset){
                    stringBuilder.append("Ps");
                    stringBuilder.append(", ");
                }
                if (firstedition){
                    stringBuilder.append("Fe");
                    stringBuilder.append(", ");
                }
                if (reverseholo){
                    stringBuilder.append("Rh");
                    stringBuilder.append(", ");
                }

                String result = stringBuilder.toString();






                CardEntity card = new CardEntity(cartaSingolaID, cartaSingolaIDc, condizione, prezzo, nomeCarta);
                card.setSellerUser(utenteVenditore,idseller);
                card.setExtrainfo(result, lingua, versione);
                cardCarrellos.add((card));

            }

            ShoppingCartEntity.getInstance().setCardIntoCart(cardCarrellos);
            ShoppingCartEntity.getInstance().setPrize();


        }

    public void buyCard(int id, int user) throws ExceptionDBerror {
        Connection conn = connCheck();

        String sql = "CALL `shopping`(?,?)";

        try {

            statement = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.setInt(1, id);
            statement.setInt(2, user);

            resultSet = statement.executeQuery();
        }catch (SQLException e) {

            throw new ExceptionDBerror("");
        }


    }

    public void modifyCouponStatus(int id) throws ExceptionDBerror {
        Connection conn = connCheck();

        String sql = "CALL updateCoupon(?)";

        try {

            statement = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.setInt(1, id);

            resultSet = statement.executeQuery();
        }catch (SQLException e) {

            throw new ExceptionDBerror("");
        }


    }

    }

