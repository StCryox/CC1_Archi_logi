package fr.esgi.cc1.membership.domain.payment.model;

public class Payment {
    private final PaymentId id;
    private final String method;
    private final Price price;

    private Payment(PaymentId id, String method, Price price) {
        this.id = id;
        this.method = method;
        this.price = price;
    }

    public static Payment of(PaymentId id, String method, Price price){
        Payment payment = new Payment(id, method, price);
            if(paymentMethod(method)){
                return payment;
            }
        throw new IllegalArgumentException("Payment method must be Paypal, Card or Bank.");
}

    private static boolean paymentMethod(String method){
        switch (method){
            case "Paypal":
            case "Card":
            case "Bank":
                return true;
        }
        return false;
    }

    public PaymentId getId() {
        return id;
    }

    public String getMethod() {
        return method;
    }

    public Price getPrice() {
        return price;
    }
}
