package fr.esgi.cc1.membership.domain;

import fr.esgi.cc1.membership.domain.payment.model.Payment;
import fr.esgi.cc1.membership.domain.payment.service.CreatePayment;
import fr.esgi.cc1.membership.domain.payment.service.PaymentProcessService;
import fr.esgi.cc1.membership.domain.tradesman.model.TradesmanId;
import fr.esgi.cc1.membership.domain.tradesman.service.CreateTradesman;
import fr.esgi.cc1.membership.domain.tradesman.service.TradesmanApplicationService;

public final class MembershipService {
    private final TradesmanApplicationService tradesmanApplicationService;
    private final PaymentProcessService paymentProcessService;

    public MembershipService(TradesmanApplicationService tradesmanApplicationService, PaymentProcessService paymentProcessService) {
        this.tradesmanApplicationService = tradesmanApplicationService;
        this.paymentProcessService = paymentProcessService;
    }


    public void Subscribe(CreateTradesman createTradesman, CreatePayment createPayment){
        final TradesmanId tradesmanId = tradesmanApplicationService.handle(createTradesman);
        final Payment payment = paymentProcessService.handle(tradesmanId, createPayment);
        if(payment != null){
            System.out.println("Membre ajouter !");
        }
    }
}
