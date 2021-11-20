package fr.esgi.cc1.membership.domain.tradesman.service;

import fr.esgi.cc1.membership.domain.tradesman.model.CompanyRegistrationNumber;
import fr.esgi.cc1.user.Address;
import fr.esgi.cc1.user.Birthdate;

public final class CreateTradesman {

    public String lastname;
    public String firstname;
    public String email;
    public Birthdate birthDate;
    public Address address;
    public CompanyRegistrationNumber companyRegistrationNumber;

    public CreateTradesman(String lastname, String firstname, String email, Birthdate birthDate, Address address, CompanyRegistrationNumber companyRegistrationNumber) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.birthDate = birthDate;
        this.address = address;
        this.companyRegistrationNumber = companyRegistrationNumber;
    }
}
