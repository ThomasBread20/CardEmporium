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




    public CopiaCardCarrello(int cartaid, double prezzo, String utentevenditore, int cartasingolaID, String nomecarta,String extra){
        this.prezzo = prezzo;
        this.utenteVenditore = utentevenditore;
        this.cartaSingolaID = cartasingolaID;
        this.nomeCarta = nomecarta;
        this.cartaID = cartaid;
        this.extra = extra;

    }

    public double getPrice() {
        return prezzo;
    }

    public String getLingua() {
        return lingua;
    }
}
