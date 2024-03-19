package it.uniroma2.ispw.cardemporium.cli;

import it.uniroma2.ispw.cardemporium.bean.thomas.CardInformationBean;
import it.uniroma2.ispw.cardemporium.bean.thomas.CouponInformationBean;
import it.uniroma2.ispw.cardemporium.business.CliPrinter;
import it.uniroma2.ispw.cardemporium.business.DataSingleton;
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
        DataSingleton inf = DataSingleton.getInstance();
        ShoppingController carta = new ShoppingController();
        CouponInformationBean beanCoupon = new CouponInformationBean();
        CardInformationBean bean = new CardInformationBean();

        while(true){
            try{
                List<CardInformationBean> cards =  carta.getListofcardIntoShoppingCart(bean);
                printCard(cards);
                int choice=showMenu();

            switch (choice) {
                case 1:
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

                    break;

                case 2:

                        double totalPrize = 0;
                        CliPrinter.printMessage("Select a shipping method: \n");
                        CliPrinter.printMessage("1)posta1\n");
                        CliPrinter.printMessage("2)posta4\n");
                        String name2 = reader.readLine();
                        if(name2.equals("1"))
                        {
                            beanCoupon.setShipping("posta1");
                            totalPrize = carta.returnShippingfromEntity("posta1");
                            System.out.println(totalPrize);
                        } else if (name2.equals("2")) {
                            beanCoupon.setShipping("posta4");
                            totalPrize += carta.returnShippingfromEntity("posta4");
                        }else{
                            CliPrinter.printMessage("Invalid Choice \n");
                            break;
                        }

                    CliPrinter.printMessage("Select a Coupon: \n");
                        List<String>  coupon = carta.returnCouponorShipping(0);
                        int value1 = 0;
                        for(int i = 0; i < coupon.size(); i++) {
                            value1 = i + 1;
                            CliPrinter.printMessage(value1 + ")" + coupon.get(i) + "\n");
                        }


                        String name3 = reader.readLine();

                        beanCoupon.setType(coupon.get(Integer.parseInt(name3) -1 ));
                        totalPrize = carta.returnCouponfromEntity(coupon.get(Integer.parseInt(name3) -1 ));


                        showMenu1(beanCoupon, totalPrize);

                        String result = reader.readLine();

                        if(result.equals("yes"))
                        {
                            bean.setLista(cards);
                            carta.shopping(bean, beanCoupon);
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
    public int showMenu(){
        CliPrinter.printMessage("what do you want to do?\n");
        CliPrinter.printMessage("1) remove a card");
        CliPrinter.printMessage("2) shop all the cards");
        CliPrinter.printMessage("3) return to home page");
        CliPrinter.printMessage("4) quit\n");


        return verifyChioce(1,4);
    }

    public void showMenu1(CouponInformationBean beanCoupon, double totalprize){

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

