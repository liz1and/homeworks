package ru.innopolis.java.homework012.repository;

import ru.innopolis.java.homework012.model.Person;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class PersonRepositoryImpl implements PersonRepository {

    public static LocalDate parseDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.parse(dateStr, formatter);
    }

    @Override
    public Person getPersonFromString (String s) {
        String[] data = s.split(" ");
        if (data.length != 7) {
            throw new IllegalArgumentException("Некорректный ввод данных!");
        }
        String lastName = data[0];
        String firstName = data[1];
        String middleName = data[2];
        String birthDateStr = data[3];
        long phoneNumber = Long.parseLong(data[4]);
        char gender = data[5].charAt(0);
        int age = Integer.parseInt(data[6]);

        LocalDate birthDate = PersonRepositoryImpl.parseDate(birthDateStr);
        return new Person(lastName, firstName, middleName, birthDate, phoneNumber, gender, age);
    }

    @Override
    public Map<String, Person> loadPersonDataFromFile(File file) throws IOException {
        Map<String, Person> personMap = new HashMap<>();
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    Person person = getPersonFromString(line);
                    personMap.put(person.getLastName() + person.getFirstName() + person.getMiddleName(), person);
                }
            }
        }
        return personMap;
    }

    @Override
    public void savePersonData(Person person) throws IOException {
        String filename = person.getLastName() + ".txt";
        File file = new File("src/ru/innopolis/java/homework012/data/",filename);

        Map<String, Person> personMap = loadPersonDataFromFile(file);
        if (!personMap.containsKey(person.getLastName() + person.getFirstName())) {
            personMap.put(person.getLastName() + person.getFirstName() + person.getMiddleName(), person);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Person p : personMap.values()) {
                writer.write(p.toString());
                writer.newLine();
            }
        }
    }

}