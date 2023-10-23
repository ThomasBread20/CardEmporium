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

    public Boolean getNelCarrello() {
        return nelCarrello;
    }

    private int versione;
  private String nomeSet;

    public int getVersione() {
        return versione;
    }

    public String getNomeSet() {
        return nomeSet;
    }

    public void setLingua(String lingua) {
        this.lingua = lingua;
    }

    public String getCondizione() {
        return condizione;
    }

    public double getprezzo() {
        return prezzo;
    }

    public String  getUtenteVenditore() {
        return utenteVenditore;
    }

    public int getCartaSingolaID() {
        return cartaSingolaID;
    }

    public int getCartaID() {
        return cartaID;
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

    public boolean isVenduto() {
        return venduto;
    }

    private boolean venduto;

    public boolean isvenduto(){
        return venduto;
    }

    public CopiaCard(String Condizione1, double Prezzo, String Utentevenditore, int CartasingolaID, int CartaID, String Nomecarta, String NomeGioco, String Lingua, int versione, String setNome, boolean carrello,String extra, boolean venduto){
        this.condizione = Condizione1;
        this.prezzo = Prezzo;
        this.utenteVenditore = Utentevenditore;
        this.cartaSingolaID = CartasingolaID;
        this.cartaID = CartaID;
        this.nomeCarta = Nomecarta;
        this.nomeGioco = NomeGioco;
        this.lingua = Lingua;
        this.versione = versione;
        this.nomeSet = setNome;
        this.nelCarrello = carrello;

        this.extra = extra;

        this.venduto = venduto;
    }
    public CopiaCard(String Condizione1, double Prezzo, String Utentevenditore, int CartaID, String Nomecarta, String NomeGioco, String Lingua, int versione, String setNome){
        this.condizione = Condizione1;
        this.prezzo = Prezzo;
        this.utenteVenditore = Utentevenditore;

        this.cartaID = CartaID;
        this.nomeCarta = Nomecarta;
        this.nomeGioco = NomeGioco;
        this.lingua = Lingua;
        this.versione = versione;
        this.nomeSet = setNome;

    }// QUESTA PER ME CHE LA DEVO INSERIRE FRA QUELLE IN VENDITA



    public double getPrezzo() {
        return prezzo;
    }

    public String getLingua() {
        return lingua;
    }
}
