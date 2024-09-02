package ru.innopolis.java.homework012.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Person {
    private final String firstName;
    private final String lastName;
    private final String middleName;
    private final LocalDate birthDate;
    private final long phoneNumber;
    private final char gender;
    private final int age;

    public Person(String lastName, String firstName, String middleName, LocalDate birthDate, long phoneNumber, char gender, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
    }

    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + middleName + " " + birthDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
                + " " + phoneNumber + " " + gender + " " + age;
    }
}
