package fr.esgi.cc1.user;

import java.time.LocalDate;
import java.time.Period;

public class Birthdate {
    private final LocalDate birthDate;
    private final int age;

    private Birthdate(LocalDate birthDate) {
        this.birthDate = birthDate;
        this.age = this.calculateAge(LocalDate.now());
    }

    public static Birthdate of(LocalDate birthDate){
        return new Birthdate(birthDate);
    }

    public int calculateAge(LocalDate currentDate) {
        if ((this.birthDate != null) && (currentDate != null)) {
            return Period.between(this.birthDate, currentDate).getYears();
        }
        throw new IllegalArgumentException("BirthDate can not be empty.");
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getAge() {
        return age;
    }
}
