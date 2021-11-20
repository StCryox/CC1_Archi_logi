package fr.esgi.cc1.membership.infrastructure;

import fr.esgi.cc1.core.NoSuchEntityException;
import fr.esgi.cc1.membership.domain.payment.model.Payment;
import fr.esgi.cc1.membership.domain.payment.model.PaymentId;
import fr.esgi.cc1.membership.domain.payment.PaymentLogRepository;
import fr.esgi.cc1.membership.domain.tradesman.model.TradesmanId;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class InMemoryPaymentLogRepository implements PaymentLogRepository {

    private final AtomicInteger count = new AtomicInteger(0);

    private final Map<TradesmanId, Payment> payments = new ConcurrentHashMap<>();

    @Override
    public PaymentId nextIdentity() {
        return new PaymentId(count.incrementAndGet());
    }

    @Override
    public Payment findById(TradesmanId id) {
        final Payment payment = this.payments.get(id);
        if (payment == null) {
            throw NoSuchEntityException.withId(id);
        }
        return payment;
    }

    @Override
    public void add(TradesmanId tradesmanId, Payment payment) {
        this.payments.put(tradesmanId, payment);
    }
}
