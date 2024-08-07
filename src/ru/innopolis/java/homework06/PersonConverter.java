package ru.innopolis.java.homework06;

public class PersonConverter {

    public static Person [] convertFromString(String persons) {

        int personsCount = persons.length() - persons.replace(";", "").length() + 1;
        Person [] personArray = new Person[personsCount];

        for (int i = 0; i < personsCount; i++) {
            personArray[i] = new Person(getName(persons), getMoney(persons));
            persons = persons.substring(persons.indexOf(";") + 1);
        }
        return personArray;
    }

    public static String getName(String s) {
        s = s.trim();
        if (!s.contains(" =")) {
            return s;
        }
        return s.substring(0, s.indexOf(" ="));
    }

    public static int getMoney(String s) {
        if (s.contains(";")) {
            return Integer.parseInt(s.substring(s.indexOf("= ") + 2, s.indexOf(";")));
        } else {
            return Integer.parseInt(s.substring(s.indexOf("= ") + 2));
        }
    }

    public static int getPersonIndexByName (Person [] personsArray, String name) {
        for (int i = 0; i < personsArray.length; i++) {
            if (personsArray[i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
}
