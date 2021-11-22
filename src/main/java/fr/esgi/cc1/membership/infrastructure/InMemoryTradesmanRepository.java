package fr.esgi.cc1.membership.infrastructure;

import fr.esgi.cc1.core.NoSuchEntityException;
import fr.esgi.cc1.membership.domain.tradesman.TradesmanRepository;
import fr.esgi.cc1.membership.domain.tradesman.model.Tradesman;
import fr.esgi.cc1.membership.domain.tradesman.model.TradesmanId;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class InMemoryTradesmanRepository implements TradesmanRepository {

    private final AtomicInteger count = new AtomicInteger(0);

    private final Map<TradesmanId, Tradesman> tradesmans = new ConcurrentHashMap<>();

    @Override
    public TradesmanId nextIdentity() {
        return new TradesmanId(count.incrementAndGet());
    }

    @Override
    public Tradesman findById(TradesmanId id) {
        final Tradesman tradesman = this.tradesmans.get(id);
        if (tradesman == null) {
            throw NoSuchEntityException.withId(id);
        }
        return tradesman;
    }

    @Override
    public Tradesman findByEmail(String email){
        Tradesman tradesman = this.tradesmans
                .entrySet()
                .stream()
                .filter(
                        userIdUserEntry -> userIdUserEntry
                                .getValue()
                                .getEmail()
                                .equals(email))
                .findFirst()
                .get()
                .getValue();
        if (tradesman == null) {
            throw new NoSuchEntityException("Tradesman not found.");
        }
        return tradesman;
    }

    @Override
    public void add(Tradesman tradesman) {
        this.tradesmans.put(tradesman.getId(), tradesman);
    }
}
