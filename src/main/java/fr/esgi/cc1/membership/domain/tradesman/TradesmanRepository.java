package fr.esgi.cc1.membership.domain.tradesman;

import fr.esgi.cc1.core.NoSuchEntityException;
import fr.esgi.cc1.membership.domain.tradesman.model.Tradesman;
import fr.esgi.cc1.membership.domain.tradesman.model.TradesmanId;

public interface TradesmanRepository {

    TradesmanId nextIdentity();

    Tradesman findById(TradesmanId id)  throws NoSuchEntityException;

    void add(Tradesman tradesman);
}
