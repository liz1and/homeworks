package ru.innopolis.java.attestation01;

import ru.innopolis.java.attestation01.model.User;
import ru.innopolis.java.attestation01.repositories.UsersRepositoryFileImpl;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        UsersRepositoryFileImpl usersRepository = new UsersRepositoryFileImpl();
        usersRepository.deleteAll();
        User userIvan = new User("f5a8a3cb-4ac9-4b3b-8a65-c424e129b9d2", LocalDateTime.parse("2024-08-25T18:10:11"), "ivan_123", "123ivan", "123ivan",
                "Иван", "Петров", "Юрьевич", 35, true);
        User userAnton = new User("e6a8a3cb-4ac8-4b3b-8a65-c424e128b9d2", "onton_345", "124onton", "124onton", "Антон", "Павлов");
        usersRepository.createUser(userIvan);
        usersRepository.createUser(userAnton);
        usersRepository.deleteById("e6a8a3cb-4ac8-4b3b-8a65-c424e128b9d2");
        userAnton.setId("f5a8a3cb-4ac9-4b3b-8a65-c424e129b9d2");
        //userIvan.setLogin("my_login123");
        usersRepository.updateUser(userAnton);
    }
}