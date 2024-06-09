package it.uniroma2.ispw.cardemporium.controller.thomas;

import it.uniroma2.ispw.cardemporium.bean.thomas.CardInformationBean;
import it.uniroma2.ispw.cardemporium.bean.thomas.CouponInformationBean;
import it.uniroma2.ispw.cardemporium.model.Coupon;
import it.uniroma2.ispw.cardemporium.model.Shipping;
import it.uniroma2.ispw.cardemporium.utility.DataSingleton;
import it.uniroma2.ispw.cardemporium.dao.thomas.CouponDao;
import it.uniroma2.ispw.cardemporium.dao.thomas.ShoppingCartDAO;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.filesystemdb.ShopcardFS;
import it.uniroma2.ispw.cardemporium.model.CardEntity;
import it.uniroma2.ispw.cardemporium.model.ShoppingCartEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingController {


    public static final String NO_COUPON = "NoCoupon";
    public static final String COUPON_5 = "Coupon5";

    public ShoppingController() {
        //constructor
    }

    static final String FIRST_COUPON = "FirstCoupon";
    static final String POSTA_1 = "posta1";
    static final String POSTA_4 = "posta4";


    public void initShoppingCart() throws SQLException, ExceptionDBerror {
        int id;
        try{
            ShoppingCartDAO idname = new ShoppingCartDAO();
            id = DataSingleton.getInstance().getID();
            idname.getCardbyIdUser(id);
            CouponDao couponct = new CouponDao();
            ShoppingCartEntity.getInstance().setCouponList(couponct.getCoupons(id));
        }catch (ExceptionDBerror e){
            throw new ExceptionDBerror("ERRORE numero 3");
        }
    }

    public List<CardInformationBean> getListofcardIntoShoppingCart() throws ExceptionCardNotExist {
        List<CardEntity> listaCarte = ShoppingCartEntity.getInstance().getCardIntoCart();
        List<CardInformationBean> bean1 = new ArrayList<>();


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

    public static void buy(CardInformationBean bean, CouponInformationBean couponinfo) throws ExceptionDBerror {

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
                if( couponinfo.getType().equals(FIRST_COUPON)){

                    carrello.modifyCouponStatus(user);
                    ShoppingCartEntity.getInstance().removeFirstfromCouponList();

                }
                ShoppingCartEntity.getInstance().clearCarrello();
                ShoppingCartEntity.getInstance().resetPrize();
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
            List<CardEntity> listaCarte = ShoppingCartEntity.getInstance().getCardIntoCart();
            ShoppingCartEntity.getInstance().removePrize(listaCarte.get(indexCard).getPrezzo());
            listaCarte.remove(indexCard);

            List<CardInformationBean> bean1 = new ArrayList<>();
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


    public enum CouponOrShipping {
        COUPON,
        SHIPPING
    }

    public List<String> returnCouponOrShipping(CouponOrShipping couponOrShipping)  {
        List<String> coupon = new ArrayList<>();

        if (couponOrShipping == CouponOrShipping.SHIPPING) {
            coupon.add(POSTA_1);
            coupon.add(POSTA_4);
            return coupon;

        } else if (couponOrShipping == CouponOrShipping.COUPON) {

            return ShoppingCartEntity.getInstance().getCouponList();
        } else {
            return coupon;
        }

    }

    public double returnShippingfromEntity(Shipping shipping) {
        ShoppingCartEntity.getInstance().setPrizeShipping(shipping);
        return ShoppingCartEntity.getInstance().getTotalprize();
    }


    public double returnCouponfromEntity(Coupon coupon) {
        ShoppingCartEntity.getInstance().setPrizeCoupon(coupon);
        return ShoppingCartEntity.getInstance().getTotalprizecoupon();
    }


}

