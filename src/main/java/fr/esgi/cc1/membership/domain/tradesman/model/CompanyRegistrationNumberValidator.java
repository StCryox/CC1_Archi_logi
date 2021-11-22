package fr.esgi.cc1.membership.domain.tradesman.model;


import fr.esgi.cc1.core.ValueLengthException;

import java.util.function.Predicate;

final class CompanyRegistrationNumberValidator implements Predicate<CompanyRegistrationNumber> {

    private static final CompanyRegistrationNumberValidator INSTANCE = new CompanyRegistrationNumberValidator();

    public static CompanyRegistrationNumberValidator getInstance() {
        return INSTANCE;
    }

    private void verifyLength(CompanyRegistrationNumber companyRegistrationNumber){
        if(companyRegistrationNumber.companyRegistrationNumber.length() != 14)
        {
            throw new ValueLengthException("Company registration number must be 14 character long." + String.valueOf(companyRegistrationNumber).length());
        }
    }

    public static boolean isInteger(CompanyRegistrationNumber companyRegistrationNumber) {
        return companyRegistrationNumber.companyRegistrationNumber.matches("-?\\d+");
    }

    @Override
    public boolean test(CompanyRegistrationNumber companyRegistrationNumber) {
        verifyLength(companyRegistrationNumber);
        if(!isInteger(companyRegistrationNumber)){
            throw new IllegalArgumentException("Company registration number must be a 14 character integer !");
        }
        return true;
    }
}