package fr.esgi.cc1.membership.domain.payment.model;

public class PaymentId {
    private final int value;

    public PaymentId(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "PaymentId{" +
                "value=" + value +
                '}';
    }
}
