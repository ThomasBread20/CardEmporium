package it.uniroma2.ispw.cardemporium.model;

public enum Shipping {
    POSTA_1,
    POSTA_4;


    public static Shipping fromString(String shipping) throws IllegalArgumentException {
        switch (shipping) {
            case "posta1":
                return Shipping.POSTA_1;
            case "posta4":
                return Shipping.POSTA_4;
            default:
                throw new IllegalArgumentException("invalid shipping string");
        }

    }
}
