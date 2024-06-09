package it.uniroma2.ispw.cardemporium.cli;

import it.uniroma2.ispw.cardemporium.bean.thomas.CardInformationBean;
import it.uniroma2.ispw.cardemporium.bean.thomas.CouponInformationBean;
import it.uniroma2.ispw.cardemporium.model.Coupon;
import it.uniroma2.ispw.cardemporium.model.Shipping;
import it.uniroma2.ispw.cardemporium.utility.CliPrinter;
import it.uniroma2.ispw.cardemporium.controller.thomas.ShoppingController;

import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.InvalidChioceException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

public class Shoppingcart extends CliManager {

    public void start() throws InvalidChioceException, IOException, ExceptionCardNotExist, SQLException, ExceptionDBerror {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ShoppingController carta = new ShoppingController();
        CouponInformationBean beanCoupon = new CouponInformationBean();
        CardInformationBean bean = new CardInformationBean();

        while(true){
            try{
                List<CardInformationBean> cards =  carta.getListofcardIntoShoppingCart();
                printCard(cards);
                int choice=showMenu();

            switch (choice) {
                case 1:
                    case1(reader, cards);
                    break;

                case 2:

                        double totalPrize = 0;
                        CliPrinter.printMessage("Select a shipping method: \n");
                        CliPrinter.printMessage("1)posta1\n");
                        CliPrinter.printMessage("2)posta4\n");
                        String name2 = reader.readLine();

                        totalPrize += menu2( name2);

                    CliPrinter.printMessage("Select a Coupon: \n");
                        List<String>  coupon = carta.returnCouponOrShipping(ShoppingController.CouponOrShipping.COUPON);
                        int value1 = 0;
                        for(int i = 0; i < coupon.size(); i++) {
                            value1 = i + 1;
                            CliPrinter.printMessage(value1 + ")" + coupon.get(i) + "\n");
                        }


                        String name3 = reader.readLine();
                        int couponChoice = Integer.parseInt(name3) -1;
                        String couponName = coupon.get(couponChoice);
                        beanCoupon.setType(couponName);
                        totalPrize += carta.returnCouponfromEntity(Coupon.fromString(couponName));


                        showMenu1( totalPrize);

                        String result = reader.readLine();

                        if(result.equals("yes"))
                        {
                            bean.setLista(cards);
                            ShoppingController.buy(bean, beanCoupon);
                            break;
                        }else if(result.equals("no"))
                        {
                            break;
                        }else
                        {
                            CliPrinter.printMessage("invalid choice \n");
                            break;
                        }

                case 3:
                    new HomePage().start();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    throw new InvalidChioceException("invalid choice");

            }
            }catch(ExceptionDBerror e ){
                e.getMessage();
            }
        }

    }

    public double menu2(String name2){
        ShoppingController carta = new ShoppingController();
        CouponInformationBean beanCoupon = new CouponInformationBean();
        double totalPrize = 0;
        if(name2.equals("1"))
        {
            beanCoupon.setShipping("posta1");
            totalPrize += carta.returnShippingfromEntity(Shipping.POSTA_1);
        } else if (name2.equals("2")) {
            beanCoupon.setShipping("posta4");
            totalPrize += carta.returnShippingfromEntity(Shipping.POSTA_4);
        }
        return totalPrize;
    }

    public void case1(BufferedReader reader,  List<CardInformationBean> cards ) throws IOException, ExceptionDBerror {
        ShoppingController carta = new ShoppingController();
        CardInformationBean bean = new CardInformationBean();
        CliPrinter.printMessage("whitch card do you want to remove?\n");
        String name1 = reader.readLine();
        int value = Integer.parseInt(name1)-1;
        if(controllo(Integer.parseInt(name1), cards)){
            bean.setCartaSingolaID(cards.get(value).getCartaSingolaID());
            carta.removeCard(bean, value);
        }else{
            CliPrinter.printMessage("you do not have a card with this id in your shopping cart");
            CliPrinter.printMessage("choose another card\n");
        }
    }
    public int showMenu(){
        CliPrinter.printMessage("what do you want to do?\n");
        CliPrinter.printMessage("1) remove a card");
        CliPrinter.printMessage("2) shop all the cards");
        CliPrinter.printMessage("3) return to home page");
        CliPrinter.printMessage("4) quit\n");


        return verifyChioce(1,4);
    }

    public void showMenu1(double totalprize){

        CliPrinter.printMessage("that's the total prize: \n");
        CliPrinter.printMessage(totalprize + " \n");

        CliPrinter.printMessage("(yes/no)\n");



    }

    public void printCard( List<CardInformationBean> cards)  {
        int value = 1;
        CliPrinter.printMessage("ID ,Nome ,seller ,price  ,extra\n");
        for(CardInformationBean item : cards){
            CliPrinter.printMessage(value +  "-" + item.getNomeCarta() +  "-"+ item.getUtenteVenditore()+ "-"  + item.getPrezzo() +"-" + item.getExtra() );
            value++;
        }
        CliPrinter.printMessage("\n");
    }
    public boolean controllo(int name, List<CardInformationBean> cards)  {
        for(CardInformationBean item : cards){
            if(name == item.getCartaSingolaID()){
                return true;
            }
        }

        return false;
    }
}

