package it.uniroma2.ispw.cardemporium.model;



public class CopiaCardCarrello {




  private  String condizione;
  private double prezzo;
  private String  utenteVenditore;
  private int cartaSingolaID;



    private int cartaID;

    private String extra;

    public String getExtra() {
        return extra;
    }

    private String nomeCarta;

  private String nomeGioco;

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




    public CopiaCardCarrello(int cartaid, double Prezzo, String Utentevenditore, int CartasingolaID, String Nomecarta,String extra){
        this.prezzo = Prezzo;
        this.utenteVenditore = Utentevenditore;
        this.cartaSingolaID = CartasingolaID;
        this.nomeCarta = Nomecarta;
        this.cartaID = cartaid;
        this.extra = extra;

    }

    public double getPrezzo() {
        return prezzo;
    }

    public String getLingua() {
        return lingua;
    }
}
