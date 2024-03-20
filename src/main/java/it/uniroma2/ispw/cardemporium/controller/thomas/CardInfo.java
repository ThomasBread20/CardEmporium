package it.uniroma2.ispw.cardemporium.controller.thomas;

public class CardInfo {
    private int cartaID;

    private String nomeCarta;
    private int cartaSingolaID;

    private String nomeGioco;
    private String nomeSet;

    private double prezzo;

    private  String condizione;

    private String lingua;
    private int versione;
    private String utenteVenditore;

    private int iDvenditore;
    private String  extra;
    private boolean venduto;
    private Boolean nelCarrello;

    private int iduser;

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

    public int getiDvenditore() {
        return iDvenditore;
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

    public int getIduser() {
        return iduser;
    }

    public void setCartaID(int cartaID) {
        this.cartaID = cartaID;
    }

    public void setNomeCarta(String nomeCarta) {
        this.nomeCarta = nomeCarta;
    }

    public void setCartaSingolaID(int cartaSingolaID) {
        this.cartaSingolaID = cartaSingolaID;
    }

    public void setNomeGioco(String nomeGioco) {
        this.nomeGioco = nomeGioco;
    }

    public void setNomeSet(String nomeSet) {
        this.nomeSet = nomeSet;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public void setCondizione(String condizione) {
        this.condizione = condizione;
    }

    public void setLingua(String lingua) {
        this.lingua = lingua;
    }

    public void setVersione(int versione) {
        this.versione = versione;
    }

    public void setUtenteVenditore(String utenteVenditore) {
        this.utenteVenditore = utenteVenditore;
    }

    public void setiDvenditore(int iDvenditore) {
        this.iDvenditore = iDvenditore;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public void setVenduto(boolean venduto) {
        this.venduto = venduto;
    }

    public void setNelCarrello(Boolean nelCarrello) {
        this.nelCarrello = nelCarrello;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }
}
