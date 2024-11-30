package ru.innopolis.java.homework012.test;

import ru.innopolis.java.homework012.model.Person;
import ru.innopolis.java.homework012.repository.PersonRepositoryImpl;

import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PersonRepositoryImpl personRepository = new PersonRepositoryImpl();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные через пробел (Фамилия Имя Отчество датарождения номертелефона пол возраст):");
        String s = scanner.nextLine();
        try {
            Person person = personRepository.getPersonFromString(s);
            personRepository.savePersonData(person);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (DateTimeParseException e) {
            System.out.println("Неверный формат даты рождения. Должен быть в формате dd.mm.yyyy.");
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом:");
        }
    }
}