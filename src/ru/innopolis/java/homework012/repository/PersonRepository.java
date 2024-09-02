package ru.innopolis.java.homework012.repository;

import ru.innopolis.java.homework012.model.Person;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public interface PersonRepository {

    Person getPersonFromString (String s);
    Map<String, Person> loadPersonDataFromFile(File file) throws IOException;
    void savePersonData(Person person) throws IOException;
}
