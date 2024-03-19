package it.uniroma2.ispw.cardemporium.bean.thomas;


import it.uniroma2.ispw.cardemporium.model.CardEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class CardInformationBean {

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




    private List<CardInformationBean> lista;

    public List<CardInformationBean> getLista() {
        return lista;
    }

    public void setLista(List<CardInformationBean> lista) {
        this.lista = lista;
    }

    public void setCartaID(int cartaID) {
        this.cartaID = cartaID;
    }

    public CardInformationBean() {

    }

    public String getNomeCarta() {
        return nomeCarta;
    }

    public int getCartaSingolaID() {
        return cartaSingolaID;
    }

    public int getiDvenditore() {
        return iDvenditore;
    }

    public String getUtenteVenditore() {
        return utenteVenditore;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public int getIduser() {
        return iduser;
    }

    public void CardInformationBeaninfo(String nameCard, int idCard, int sellerId, String sellerName, double prize) {
        this.nomeCarta = nameCard;
        this.cartaSingolaID = idCard;
        this.iDvenditore = sellerId;
        this.utenteVenditore = sellerName;
        this.prezzo = prize;
    }

    public void CardInformationBeaninfo2(int cartaID, String nomeGioco, String nomeSet, String condizione, String lingua, int versione, String extra, boolean venduto, Boolean nelCarrello) {
        this.cartaID = cartaID;
        this.nomeGioco = nomeGioco;
        this.nomeSet = nomeSet;
        this.condizione = condizione;
        this.lingua = lingua;
        this.versione = versione;
        this.extra = extra;
        this.venduto = venduto;
        this.nelCarrello = nelCarrello;
    }





    public void setNomeCarta(String nomeCarta) {
        this.nomeCarta = nomeCarta;
    }

    public void setCartaSingolaID(int cartaSingolaID) {
        this.cartaSingolaID = cartaSingolaID;
    }

    public void setiDvenditore(int iDvenditore) {
        this.iDvenditore = iDvenditore;
    }

    public void setUtenteVenditore(String utenteVenditore) {
        this.utenteVenditore = utenteVenditore;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getCartaID() {
        return cartaID;
    }

    public String getNomeGioco() {
        return nomeGioco;
    }

    public String getNomeSet() {
        return nomeSet;
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

    public String getExtra() {
        return extra;
    }

    public boolean isVenduto() {
        return venduto;
    }

    public Boolean getNelCarrello() {
        return nelCarrello;
    }

    public void setNomeGioco(String nomeGioco) {
        this.nomeGioco = nomeGioco;
    }

    public void setNomeSet(String nomeSet) {
        this.nomeSet = nomeSet;
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

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public void setVenduto(boolean venduto) {
        this.venduto = venduto;
    }

    public void setNelCarrello(Boolean nelCarrello) {
        this.nelCarrello = nelCarrello;
    }
}
