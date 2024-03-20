package it.uniroma2.ispw.cardemporium.model.simone;

public class CardEntitySImo {


        private String nomeCarta;
        private int cartaSingolaID;
        private String nomeGioco;
        private String nomeSet;
        private double prezzo;
        private  String condizione;
        private String lingua;
        private int versione;
        private String  utenteVenditore;
        private String  extra;




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



        public CardEntitySImo(String condizione, double prezzo, String nomeCarta, String extra, String lingua, int versione, String nomeSet) {
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





        private int q;
        public CardEntitySImo(String condizione1, double prezzo, String utentevenditore, String lingua, Card card, int quantity){
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
