package fr.esgi.cc1.user;

import fr.esgi.cc1.core.ValueLengthException;

import java.util.function.Predicate;

final class AddressValidator implements Predicate<Address> {

    private static final AddressValidator INSTANCE = new AddressValidator();

    public static AddressValidator getInstance() {
        return INSTANCE;
    }

    private boolean checkZipcodePreconditions(String zipcode, String country) {
        switch (country) {
            case "FR":
                if(zipcode.length() == 5){
                    return true;
                }
                throw new ValueLengthException("FR zipcode must be 5 number long.");
            case "CA":
                if(zipcode.length() == 6){
                    return true;
                }
                throw new ValueLengthException("CA zipcode must be 6 number long.");
        }
        return false;
    }

    @Override
    public boolean test(Address address) {
        return checkZipcodePreconditions(address.getZipcode(), address.getCountry());
    }
}