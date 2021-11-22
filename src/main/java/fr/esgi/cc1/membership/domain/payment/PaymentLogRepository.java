package fr.esgi.cc1.membership.domain.payment;

import fr.esgi.cc1.core.NoSuchEntityException;
import fr.esgi.cc1.membership.domain.payment.model.Payment;
import fr.esgi.cc1.membership.domain.payment.model.PaymentId;
import fr.esgi.cc1.membership.domain.tradesman.model.TradesmanId;

public interface PaymentLogRepository {

    PaymentId nextIdentity();

    Payment findById(TradesmanId id)  throws NoSuchEntityException;

    void add(TradesmanId tradesmanId, Payment payment);
}
