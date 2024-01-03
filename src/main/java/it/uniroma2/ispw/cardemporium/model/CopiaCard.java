package it.uniroma2.ispw.cardemporium.model;

public class CopiaCard {


  private  String condizione;
  private double prezzo;
  private String  utenteVenditore;
  private int cartaSingolaID;
  private int cartaID;

  private String nomeCarta;

  private String nomeGioco;
  private String  extra;
  private String lingua;

  private Boolean nelCarrello;


    private int versione;
  private String nomeSet;
  private int q;

    public int getVersione() {
        return versione;
    }

    public String getNomeSet() {
        return nomeSet;
    }



    public String getCondizione() {
        return condizione;
    }



    public String  getUtenteVenditore() {
        return utenteVenditore;
    }

    public int getCartaSingolaID() {
        return cartaSingolaID;
    }



    public CopiaCard(String condizione, double prezzo, String nomeCarta, String extra, String lingua, int versione, String nomeSet) {
        this.condizione = condizione;
        this.prezzo = prezzo;
        this.nomeCarta = nomeCarta;
        this.extra = extra;
        this.lingua = lingua;
        this.versione = versione;
        this.nomeSet = nomeSet;

    }

    public String getNomeCarta() {
        return nomeCarta;
    }
    public String getNomeGioco() {
        return nomeGioco;
    }

    public String getExtra() {
        return extra;
    }



    private boolean venduto;


    public void cardInfo(String nomeGioco, String lingua, int versione, String setNome, boolean carrello,String extra, boolean venduto){
        this.nomeGioco = nomeGioco;
        this.lingua = lingua;
        this.versione = versione;
        this.nomeSet = setNome;
        this.nelCarrello = carrello;
        this.extra = extra;
        this.venduto = venduto;
    }


    public CopiaCard(String condizione1, double prezzo, String utentevenditore,  int cartasingolaID, int cartaID, String nomecarta ){
        this.condizione = condizione1;
        this.prezzo = prezzo;
        this.utenteVenditore = utentevenditore;
        this.cartaSingolaID = cartasingolaID;
        this.cartaID = cartaID;
        this.nomeCarta = nomecarta;

    }
    public CopiaCard(String condizione1, double prezzo, String utentevenditore,  String lingua,Card card, int quantity){
        this.condizione = condizione1;
        this.q=quantity;
        this.prezzo = prezzo;
        this.utenteVenditore = utentevenditore;
        this.card=card;

        this.lingua = lingua;


    }



    public double getPrezzo() {

        return prezzo;
    }

    public String getLingua() {
        return lingua;
    }





    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    Card card;
}
