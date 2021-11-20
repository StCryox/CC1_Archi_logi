package fr.esgi.cc1.membership.domain.payment.model;

public class Price {
    private final long value;
    private final String currency;

    private Price(long value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public static Price of(long value, String currency){
        final Price price = new Price(value, currency);
        if(currencyValidator(currency)){
            return price;
        }
        throw new IllegalArgumentException("Currency must be either Euro or US Dollars.");
    }

    private static boolean currencyValidator(String currency){
        switch (currency){
            case "EUR":
            case "USD":
                return true;
        }
        return false;
    }
}
