package fr.esgi.cc1.user;

import java.util.Objects;

public class Address {
    private final String country;
    private final String city;
    private final String zipcode;
    private final String state;
    private final int number;
    private final String road;

    private Address(String country, String city, String zipcode, String state, int number, String road) {
        this.country = country;
        this.city = city;
        this.zipcode = zipcode;
        this.state = state;
        this.number = number;
        this.road = road;
    }

    public static Address of(String country, String city, String zipcode, String state, int number, String road) {
        Address address = new Address(
                Objects.requireNonNull(country),
                Objects.requireNonNull(city),
                Objects.requireNonNull(zipcode),
                Objects.requireNonNull(state),
                Objects.requireNonNull(number),
                Objects.requireNonNull(road)
                );
        if (AddressValidator.getInstance().test(address)) {
            return address;
        }
        throw new IllegalArgumentException("Illegal arguments");
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getState() {
        return state;
    }

    public int getNumber() {
        return number;
    }

    public String getRoad() {
        return road;
    }
}
