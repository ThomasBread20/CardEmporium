package it.uniroma2.ispw.cardemporium.model;

public class CopiaCard {


  private  String condizione;
  private double prezzo;
  private int utenteVenditore;
  private int cartaSingolaID;
  private int cartaID;

  private String nomeCarta;

  private String nomeGioco;

    public String getCondizione() {
        return condizione;
    }

    public double getprezzo() {
        return prezzo;
    }

    public int getUtenteVenditore() {
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



    public CopiaCard(String Condizione1, double Prezzo, int Utentevenditore, int CartasingolaID, int CartaID, String Nomecarta, String NomeGioco){
        this.condizione = Condizione1;
        this.prezzo = Prezzo;
        this.utenteVenditore = Utentevenditore;
        this.cartaSingolaID = CartasingolaID;
        this.cartaID = CartaID;
        this.nomeCarta = Nomecarta;
        this.nomeGioco = NomeGioco;
    };
}
