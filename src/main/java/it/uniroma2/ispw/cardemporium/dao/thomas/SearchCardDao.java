package it.uniroma2.ispw.cardemporium.dao.thomas;



import it.uniroma2.ispw.cardemporium.dao.Connection1Singelton;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.model.CardEntity;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SearchCardDao {

    PreparedStatement statement = null;
    ResultSet resultSet = null;


    private Connection connCheck()  {
        Connection1Singelton conn = Connection1Singelton.getInstance();
        return conn.getConn();

    }

    //questo dao genera una lista di cardentity
    public List<CardEntity> getcardlist(String name) throws ExceptionCardNotExist, SQLException {

        List<CardEntity> listaCarte = new ArrayList<>() ;

        Connection conn = connCheck();

        String sql = """
                   select *
                   from carte
                 where NomeCarta = ? and nel_carrello = 0;""";

        statement = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        statement.setString(1, name);
        resultSet = statement.executeQuery();


        if(!resultSet.next()){
            throw new ExceptionCardNotExist("Card does not exists");

        }else {

            resultSet.beforeFirst();

            CardEntity card = null;
            while (resultSet.next()) {

                String condizione = resultSet.getString("Condizione");
                double prezzo = resultSet.getDouble("Prezzo");
                String utenteVenditore = resultSet.getString("Venditore");
                int cartaSingolaID = resultSet.getInt("Carta_SingolaID");
                int cartaID = resultSet.getInt("ValueID");
                String nomeCarta = resultSet.getString("NomeCarta");
                String nomeGioco = resultSet.getString("setcarte_NomeGioco");
                int versione = resultSet.getInt("versione");
                String nomeSet = resultSet.getString("NomeSet");
                String lingua = resultSet.getString("Lingua");
                boolean carrello = resultSet.getBoolean("nel_carrello");
                boolean firmato = resultSet.getBoolean("firmato");
                boolean foil = resultSet.getBoolean("foil");
                boolean alterato = resultSet.getBoolean("alterato");
                boolean playset = resultSet.getBoolean("playset");
                boolean firstedition = resultSet.getBoolean("first_edition");
                boolean reverseholo = resultSet.getBoolean("reverse_holo");
                boolean venduto = resultSet.getBoolean("venduto");
                int iDseller = resultSet.getInt("IDseller");


                String result = getstringBuilder(firmato, foil, alterato, playset, firstedition, reverseholo);

                card = new CardEntity(cartaSingolaID, cartaID, condizione, prezzo, nomeCarta);
                card.setSellerUser(utenteVenditore,iDseller);
                card.setExtrainfo(result, lingua, versione);
                card.venduto(venduto, carrello);
                card.setCarta(nomeGioco, nomeSet);
                listaCarte.add(card);

            }
            return listaCarte;
        }
    }

    public String getstringBuilder(Boolean firmato, Boolean foil, Boolean alterato, Boolean playset, Boolean firstedition, Boolean reverseholo ){

        StringBuilder stringBuilder = new StringBuilder();

        if (Boolean.TRUE.equals(firmato)) {
            stringBuilder.append("Fir");
            stringBuilder.append(", ");
        }
        if (Boolean.TRUE.equals(foil)) {
            stringBuilder.append("Foil");
            stringBuilder.append(", ");
        }
        if (Boolean.TRUE.equals(alterato)) {
            stringBuilder.append("Alt");
            stringBuilder.append(", ");
        }
        if (Boolean.TRUE.equals(playset)) {
            stringBuilder.append("Ps");
            stringBuilder.append(", ");
        }
        if (Boolean.TRUE.equals(firstedition)) {
            stringBuilder.append("Fe");
            stringBuilder.append(", ");
        }
        if (Boolean.TRUE.equals(reverseholo)) {
            stringBuilder.append("Rh");
            stringBuilder.append(", ");
        }

        return stringBuilder.toString();

    }


}
