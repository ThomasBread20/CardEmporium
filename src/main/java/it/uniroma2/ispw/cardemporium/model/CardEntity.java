package it.uniroma2.ispw.cardemporium.model;

public class CardEntity {

    private int cartaID;
    private String nomeCarta;
    private int cartaSingolaID;
    private String nomeGioco;
    private String nomeSet;
    private double prezzo;
    private  String condizione;
    private String lingua;
    private int versione;
    private String  utenteVenditore;
    private int iDvenditore;
    private String  extra;
    private boolean venduto;
    private Boolean nelCarrello;





    public CardEntity(int cartasingolaid,int cartaID, String condizione, double prezzo, String nomeCarta) {
        this.cartaSingolaID= cartasingolaid;
        this.cartaID = cartaID;
        this.condizione = condizione;
        this.prezzo = prezzo;
        this.nomeCarta = nomeCarta;
    }
    public void setExtrainfo( String extra, String lingua, int versione)
    {
        this.extra = extra;
        this.lingua = lingua;
        this.versione = versione;
    }

    public void setSellerUser( String utentevenditore, int idvenditore)
    {
        this.utenteVenditore = utentevenditore;
        this.iDvenditore = idvenditore;
    }

    public void venduto(boolean venduto, boolean nelCarrello){
        this.venduto = venduto;
        this.nelCarrello = nelCarrello;
    }

    public void setCarta(String nomeGioco, String nomeSet){
        this.nomeGioco = nomeGioco;
        this.nomeSet = nomeSet;
    }

    public int getiDvenditore() {
        return iDvenditore;
    }

    public int getCartaID() {
        return cartaID;
    }

    public String getNomeCarta() {
        return nomeCarta;
    }

    public int getCartaSingolaID() {
        return cartaSingolaID;
    }

    public String getNomeGioco() {
        return nomeGioco;
    }

    public String getNomeSet() {
        return nomeSet;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public String getCondizione() {
        return condizione;
    }

    public String getLingua() {
        return lingua;
    }

    public int getVersione() {
        return versione;
    }

    public String getUtenteVenditore() {
        return utenteVenditore;
    }

    public String getExtra() {
        return extra;
    }

    public boolean isVenduto() {
        return venduto;
    }

    public Boolean getNelCarrello() {
        return nelCarrello;
    }
}
