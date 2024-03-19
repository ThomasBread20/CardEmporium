package it.uniroma2.ispw.cardemporium.controller.thomas;

import it.uniroma2.ispw.cardemporium.bean.thomas.CardInformationBean;
import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.dao.thomas.SearchCardDao;
import it.uniroma2.ispw.cardemporium.dao.thomas.ShoppingCartDAO;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.model.CardEntity;
import it.uniroma2.ispw.cardemporium.model.CarrelloEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardController {

     public CardController() {
         //constructor
     }
    public  List<CardInformationBean> searchCard(CardInformationBean bean) throws SQLException, ExceptionCardNotExist {

         List<CardEntity> listaCarte = null;
         List<CardInformationBean> bean1 = new ArrayList<>();
         SearchCardDao cards = new SearchCardDao();
         listaCarte= cards.getcardlist(bean.getNomeCarta());
         for(int value = 0; value < listaCarte.size(); value++){
             CardInformationBean beancopy = new CardInformationBean();
             beancopy.setNomeCarta(bean.getNomeCarta());
             beancopy.setCartaID(listaCarte.get(value).getCartaID());
             beancopy.setCartaSingolaID(listaCarte.get(value).getCartaSingolaID());
             beancopy.setNomeGioco(listaCarte.get(value).getNomeGioco());
             beancopy.setNomeSet(listaCarte.get(value).getNomeSet());
             beancopy.setPrezzo(listaCarte.get(value).getPrezzo());
             beancopy.setCondizione(listaCarte.get(value).getCondizione());
             beancopy.setLingua(listaCarte.get(value).getLingua());
             beancopy.setVersione(listaCarte.get(value).getVersione());
             beancopy.setUtenteVenditore(listaCarte.get(value).getUtenteVenditore());
             beancopy.setiDvenditore(listaCarte.get(value).getiDvenditore());
             beancopy.setExtra(listaCarte.get(value).getExtra());
             bean1.add(beancopy);
         }


         return bean1;


    }
    //inserisce una carta nel carrello
    public  void addCard(CardInformationBean bean) throws ExceptionDBerror, ExceptionCardNotExist {

         try{
             bean.setIduser(DataSingleton.getInstance().getID());
             ShoppingCartDAO addCard = new ShoppingCartDAO();
             cardinfo info = new cardinfo();
             info.setiDvenditore(bean.getiDvenditore());
             info.setUtenteVenditore(bean.getUtenteVenditore());
             info.setCartaSingolaID(bean.getCartaSingolaID());
             info.setPrezzo(bean.getPrezzo());
             info.setNomeCarta( bean.getNomeCarta());
             info.setIduser(bean.getIduser());
             addCard.putCardintoShoppingCart(info);
             addCard.updateCard(info);
             CardEntity card = new CardEntity(bean.getCartaSingolaID(), bean.getCartaID(),bean.getCondizione(), bean.getPrezzo(),bean.getNomeCarta(),bean.getExtra(),bean.getLingua(),bean.getVersione(),bean.getUtenteVenditore(),bean.getiDvenditore());
             CarrelloEntity.getInstance().getCardIntoCart().add(card);
             CarrelloEntity.getInstance().addPrize(bean.getPrezzo());

         } catch (ExceptionDBerror e) {
             throw new ExceptionCardNotExist("error");
         }
    }
}

