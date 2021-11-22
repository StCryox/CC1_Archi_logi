package fr.esgi.cc1.membership.domain.payment.service;

import fr.esgi.cc1.membership.domain.payment.model.Price;

public final class CreatePayment {

    public String method;
    public final Price price;

    public CreatePayment(String method, Price price) {
        this.method = method;
        this.price = price;
    }
}
