package fr.esgi.cc1.membership.domain.tradesman.service;

import fr.esgi.cc1.membership.domain.tradesman.TradesmanRepository;
import fr.esgi.cc1.membership.domain.tradesman.model.Tradesman;
import fr.esgi.cc1.membership.domain.tradesman.model.TradesmanId;

public final class TradesmanApplicationService {

    private final TradesmanRepository tradesmanRepository;

    public TradesmanApplicationService(TradesmanRepository tradesmanRepository) {
        this.tradesmanRepository = tradesmanRepository;
    }

    public TradesmanId handle(CreateTradesman createTradesman) {
        final TradesmanId tradesmanId = tradesmanRepository.nextIdentity();
        final Tradesman exist = tradesmanRepository.
        Tradesman tradesman = new Tradesman(tradesmanId, createTradesman.lastname, createTradesman.firstname, createTradesman.email, createTradesman.birthDate, createTradesman.address, createTradesman.companyRegistrationNumber);
        tradesmanRepository.add(tradesman);
        return tradesmanId;
    }
}
