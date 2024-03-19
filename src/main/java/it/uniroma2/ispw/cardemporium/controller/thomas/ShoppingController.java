package it.uniroma2.ispw.cardemporium.controller.thomas;

import it.uniroma2.ispw.cardemporium.bean.thomas.CardInformationBean;
import it.uniroma2.ispw.cardemporium.bean.thomas.CouponInformationBean;
import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.dao.thomas.CouponDao;
import it.uniroma2.ispw.cardemporium.dao.thomas.SearchCardDao;
import it.uniroma2.ispw.cardemporium.dao.thomas.ShoppingCartDAO;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.InvalidChioceException;
import it.uniroma2.ispw.cardemporium.filesystemdb.ShopcardFS;
import it.uniroma2.ispw.cardemporium.model.CardEntity;
import it.uniroma2.ispw.cardemporium.model.CarrelloEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingController {




    public ShoppingController() {
        //constructor
    }

    static String firstCoupon = "FirstCoupon";


    public void searchCardByIDUser() throws SQLException, ExceptionDBerror {
        int id;
        try{
            ShoppingCartDAO idname = new ShoppingCartDAO();
            id = DataSingleton.getInstance().getID();
            idname.getCardbyIdUser(id);
            CouponDao couponct = new CouponDao();
            CarrelloEntity.getInstance().setCouponList(couponct.getCoupons(id));

        }catch (ExceptionDBerror e){
            throw new ExceptionDBerror("ERRORE numero 3");
        }
    }

    public List<CardInformationBean> getListofcardIntoShoppingCart() throws ExceptionCardNotExist {
        List<CardEntity> listaCarte = CarrelloEntity.getInstance().getCardIntoCart();
        List<CardInformationBean> bean1 = new ArrayList<CardInformationBean>();


        for(int value = 0; value < listaCarte.size(); value++){
            CardInformationBean beancopy = new CardInformationBean();
            beancopy.setNomeCarta(listaCarte.get(value).getNomeCarta());
            beancopy.setCartaID(listaCarte.get(value).getCartaID());
            beancopy.setNomeCarta(listaCarte.get(value).getNomeCarta());
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

    public static void shopping(CardInformationBean bean, CouponInformationBean couponinfo) throws ExceptionDBerror {

        int user = DataSingleton.getInstance().getID();
        List<CardInformationBean> cards = bean.getLista();
        try{
            if(!cards.isEmpty()){
                ShoppingCartDAO carrello = new ShoppingCartDAO();
                ShopcardFS carrelloFS = new ShopcardFS();
                for(int value = 0; value < cards.size(); value++){
                    carrello.buyCard(cards.get(value).getCartaSingolaID(), user);
                    carrelloFS.addcard(cards.get(value).getNomeCarta(),cards.get(value).getUtenteVenditore(),cards.get(value).getPrezzo(), user);
                }
                if( couponinfo.getType().equals(firstCoupon)){

                    carrello.modifyCouponStatus(user);
                    CarrelloEntity.getInstance().removeFirstfromCouponList();

                }
                CarrelloEntity.getInstance().clearCarrello();
                CarrelloEntity.getInstance().resetPrize();
            }


        }catch (ExceptionDBerror e){
            throw new ExceptionDBerror("ERRORE");
        }
    }



    public List<CardInformationBean> removeCard(CardInformationBean bean, int indexCard) throws ExceptionDBerror {

        try{
            int iD = bean.getCartaSingolaID();
            ShoppingCartDAO carrello = new ShoppingCartDAO();
            carrello.detCard(iD);
            List<CardEntity> listaCarte = CarrelloEntity.getInstance().getCardIntoCart();
            CarrelloEntity.getInstance().removePrize(listaCarte.get(indexCard).getPrezzo());
            listaCarte.remove(indexCard);

            List<CardInformationBean> bean1 = new ArrayList<CardInformationBean>();
            for(int value = 0; value < listaCarte.size(); value++){
                CardInformationBean beancopy = new CardInformationBean();
                beancopy.setNomeCarta(listaCarte.get(value).getNomeCarta());
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



        }catch (ExceptionDBerror e){
            throw new ExceptionDBerror("ERRORE rimozione Carta dal Carrello");
        }
    }


    public List<String> returnCouponorShipping(int i)  {
        List<String> coupon = new ArrayList<String>();

        if (i == 1) {
            coupon.add("posta1");
            coupon.add("posta4");
            return coupon;

        } else if (i == 0) {

            return CarrelloEntity.getInstance().getCouponList();
        } else {
            return coupon;
        }

    }

    public double returnShippingfromEntity(String i) {


    if( i != null)
    {
        switch (i){
            case "posta1" : CarrelloEntity.getInstance().setPrizeShipping("posta1");
                break;
            case "posta4" : CarrelloEntity.getInstance().setPrizeShipping("posta4");
                break;
            default : break;
        }
        return CarrelloEntity.getInstance().getTotalprize();
    }else{
        return CarrelloEntity.getInstance().getTotalprize();
    }

    }


    public double returnCouponfromEntity(String i) {


        switch (i){
            case "NoCoupon" : CarrelloEntity.getInstance().setPrizeCoupon("NoCoupon");
            break;
            case "FirstCoupon" : CarrelloEntity.getInstance().setPrizeCoupon(firstCoupon);
            break;
            case "Coupon5" : CarrelloEntity.getInstance().setPrizeCoupon("Coupon5");
            break;
            default : break;
        }
        return CarrelloEntity.getInstance().getTotalprizecoupon();
    }



}
