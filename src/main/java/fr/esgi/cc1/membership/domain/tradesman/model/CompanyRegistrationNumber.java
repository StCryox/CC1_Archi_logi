package fr.esgi.cc1.membership.domain.tradesman.model;

public class CompanyRegistrationNumber {
    public String companyRegistrationNumber;

    private CompanyRegistrationNumber(String companyRegistrationNumber) {
        this.companyRegistrationNumber = companyRegistrationNumber;
    }

    public static CompanyRegistrationNumber of(String companyRegistrationNumber){
        CompanyRegistrationNumber companyRegistrationNumberValid = new CompanyRegistrationNumber(companyRegistrationNumber);

        CompanyRegistrationNumberValidator.getInstance().test(companyRegistrationNumberValid);

        return companyRegistrationNumberValid;
    }
}
