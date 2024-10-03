package ru.innopolis.java.homework012.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Person {
    private final String firstName;
    private final String lastName;
    private final String middleName;
    private final LocalDate birthDate;
    private final long phoneNumber;
    private final char gender;
    private int age;

    public Person(String lastName, String firstName, String middleName, LocalDate birthDate, long phoneNumber, char gender) {
        if (Objects.nonNull(lastName) && !lastName.isEmpty()) {
            this.lastName = lastName;
        }
        else {
            throw new IllegalArgumentException("Некорректная фамилия");
        }
        if (Objects.nonNull(firstName) && !firstName.isEmpty()) {
            this.firstName = firstName;
        }
        else {
            throw new IllegalArgumentException("Некорректное имя");
        }
        if (Objects.nonNull(middleName) && !middleName.isEmpty()) {
            this.middleName = middleName;
        }
        else {
            throw new IllegalArgumentException("Некорректное отчетство");
        }
        if (Objects.nonNull(birthDate)) {
            this.birthDate = birthDate;
        }
        else {
            throw new IllegalArgumentException("Некорректная дата рождения");
        }
        if (phoneNumber > 0 || Objects.nonNull(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        }
        else {
            throw new IllegalArgumentException("Некорректный номер телефона");
        }
        if (gender == 'm' || gender == 'f') {
            this.gender = gender;
        }
        else {
            throw new IllegalArgumentException("Некорректный пол");
        }

    }

    public void setAge(int age) {
        if (Objects.isNull(age) || age < 0) {
            throw new IllegalArgumentException("Некорректный возраст");
        }
        else {
            this.age = age;
        }
    }

    public int getAge() {
        return age;
    }

    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }

    @Override
    public String toString() {
        return    "<" + lastName + ">"
                + "<"  + firstName + ">"
                + "<"  + middleName + ">"
                + "<"  + birthDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + ">"
                + "<"  + phoneNumber + ">"
                + "<"  + gender + ">";
    }
}
