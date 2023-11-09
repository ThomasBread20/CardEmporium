package it.uniroma2.ispw.cardemporium.model;

public class CopiacardHelp {
    private boolean carrello;

    public boolean isCarrello() {
        return carrello;
    }

    public CopiacardHelp(boolean carrello, boolean venduto, int cartasing) {
        this.carrello = carrello;
        this.venduto = venduto;
        this.cartasing = cartasing;
    }

    public void setCarrello(boolean carrello) {
        this.carrello = carrello;
    }

    public boolean isVenduto() {
        return venduto;
    }

    public void setVenduto(boolean venduto) {
        this.venduto = venduto;
    }

    public int getCartasing() {
        return cartasing;
    }

    public void setCartasing(int cartasing) {
        this.cartasing = cartasing;
    }

    private boolean venduto;
    private int cartasing;

}
