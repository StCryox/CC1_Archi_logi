package fr.esgi.cc1.membership.domain.tradesman.model;


import fr.esgi.cc1.user.Address;
import fr.esgi.cc1.user.Birthdate;

public final class Tradesman {

    private final TradesmanId id;
    private final String lastname;
    private final String firstname;
    private final String email;
    private final Birthdate birthDate;
    private final Address address;
    private final CompanyRegistrationNumber companyRegistrationNumber;

    public Tradesman(TradesmanId id, String lastname, String firstname, String email, Birthdate birthDate, Address address, CompanyRegistrationNumber companyRegistrationNumber) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email= email;
        this.birthDate = birthDate;
        this.address = address;
        this.companyRegistrationNumber = companyRegistrationNumber;
    }

    public String getEmail() {
        return email;
    }

    public TradesmanId getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Tradesman{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", birthdate='" + birthDate + '\'' +
                ", address='" + address + '\'' +
                ", companyRegistrationNumber='" + companyRegistrationNumber + '\'' +
                '}';
    }
}
