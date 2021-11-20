package fr.esgi.cc1;

import fr.esgi.cc1.membership.domain.payment.model.Price;
import fr.esgi.cc1.membership.domain.payment.service.CreatePayment;
import fr.esgi.cc1.membership.domain.payment.PaymentLogRepository;
import fr.esgi.cc1.membership.domain.payment.service.PaymentProcessService;
import fr.esgi.cc1.membership.domain.tradesman.model.CompanyRegistrationNumber;
import fr.esgi.cc1.membership.domain.tradesman.TradesmanRepository;
import fr.esgi.cc1.membership.domain.tradesman.service.CreateTradesman;
import fr.esgi.cc1.membership.domain.tradesman.service.TradesmanApplicationService;
import fr.esgi.cc1.membership.domain.tradesman.service.TradesmanMembershipService;
import fr.esgi.cc1.membership.infrastructure.InMemoryPaymentLogRepository;
import fr.esgi.cc1.membership.infrastructure.InMemoryTradesmanRepository;
import fr.esgi.cc1.user.Address;
import fr.esgi.cc1.user.Birthdate;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        TradesmanRepository tradesmanRepository = new InMemoryTradesmanRepository();
        TradesmanApplicationService tradesmanApplicationService = new TradesmanApplicationService(tradesmanRepository);

        PaymentLogRepository paymentLogRepository = new InMemoryPaymentLogRepository();
        PaymentProcessService paymentProcessService = new PaymentProcessService(paymentLogRepository);

        TradesmanMembershipService tradesmanMembershipService = new TradesmanMembershipService(tradesmanApplicationService, paymentProcessService);


        Address address = Address.of(
                "FR",
                "Romainville",
                "93230",
                "Ile de France",
                8,
                 "Allee George Melies");


        Birthdate birthdate = Birthdate.of(
                LocalDate.of(2000, 10, 10)
        );

        CompanyRegistrationNumber companyRegistrationNumber = CompanyRegistrationNumber.of("12345678901234");



        CreateTradesman createTradesman = new CreateTradesman(
                "Nguyen",
                "Ifzas",
                "inguyen2@myges.fr",
                birthdate,
                address,
                companyRegistrationNumber
        );

        Price price = Price.of(
                25_000,
                "EUR"
        );

        CreatePayment createPayment = new CreatePayment("Paypal", price);

        tradesmanMembershipService.Subscribe(createTradesman, createPayment);
    }
}
