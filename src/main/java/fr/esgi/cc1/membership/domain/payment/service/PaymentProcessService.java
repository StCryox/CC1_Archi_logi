package fr.esgi.cc1.membership.domain.payment.service;

import fr.esgi.cc1.membership.domain.payment.model.Payment;
import fr.esgi.cc1.membership.domain.payment.model.PaymentId;
import fr.esgi.cc1.membership.domain.payment.PaymentLogRepository;
import fr.esgi.cc1.membership.domain.tradesman.model.TradesmanId;

public class PaymentProcessService {
    private final PaymentLogRepository paymentLogRepository;

    public PaymentProcessService(PaymentLogRepository paymentLogRepository) {
        this.paymentLogRepository = paymentLogRepository;
    }

    public Payment handle(TradesmanId tradesmanId, CreatePayment createPayment) {
        final PaymentId paymentId = paymentLogRepository.nextIdentity();
        Payment payment = Payment.of(paymentId, createPayment.method, createPayment.price);
        if(pay(payment)){
            savePayment(tradesmanId, payment);
            return payment;
        }
        throw new IllegalStateException("Could not process the payment.");
    }

    private boolean pay(Payment payment) {
        switch (payment.getMethod()) {
            case "Paypal" -> {
                System.out.println("API Paypal enclencher !");
                return true;
            }
            case "Card" -> {
                System.out.println("API Carte bancaire enclencher !");
                return true;
            }
            case "Bank" -> {
                System.out.println("API Transfert Bancaire enclencher !");
                return true;
            }
        }
        throw new IllegalStateException("System timed out.");
    }

    private void savePayment(TradesmanId tradesmanId, Payment payment){
        paymentLogRepository.add(tradesmanId, payment);
        System.out.println("Payement accepter de Tradesman " + tradesmanId.getValue() + " !");
    }
}
