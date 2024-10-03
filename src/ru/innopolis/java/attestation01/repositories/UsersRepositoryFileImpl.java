package ru.innopolis.java.attestation01.repositories;

import ru.innopolis.java.attestation01.model.User;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UsersRepositoryFileImpl implements UsersRepository {

    private String fileName = "src/ru/innopolis/java/attestation01/users.txt";

    public UsersRepositoryFileImpl() {}

    public UsersRepositoryFileImpl(String fileName) { this.fileName = fileName;}

    private static User getUser(String line) {
        User newUser = null;
        String[] parts = line.split("\\|");
        String id = parts[0];
        LocalDateTime date = LocalDateTime.parse(parts[1]);
        String login = parts[2];
        String password = parts[3];
        String confirmPassword = parts[4];
        String firstName = parts[5];
        String lastName = parts[6];
        String middleName = parts[7];
        int age = Integer.parseInt(parts[8]);
        boolean isWorker = Boolean.parseBoolean(parts[9]);
        if (!Objects.isNull(id) && !Objects.isNull(login) && !Objects.isNull(password) && !Objects.isNull(confirmPassword) && !Objects.isNull(firstName) && !Objects.isNull(lastName)) {
            newUser = new User(id, login, password, confirmPassword, firstName, lastName);
            if (!Objects.isNull(date)) {
                newUser.setDate(date);
            }
            if (!Objects.isNull(middleName)) {
                newUser.setMiddleName(middleName);
            }
            if (!Objects.isNull(age) && age > 0) {
                newUser.setAge(age);
            }
            if (!Objects.isNull(isWorker)) {
                newUser.setWorker(isWorker);
            }
        }
        return newUser;
    }

    @Override
    public void createUser(User user) {
        List<User> users = findAll();
        if (Objects.isNull(users) || users.size() == 0) {
            try (BufferedWriter wr = Files.newBufferedWriter(Path.of(this.fileName))) {
                wr.write(user.toString());
                wr.newLine();
            } catch (IOException e) {
                throw new NullPointerException("Не удалось записать в файл нового пользователя");
            }
        } else {
            try (BufferedWriter wr = Files.newBufferedWriter(Path.of(this.fileName))) {
                    for (User u : users) {
                        wr.write(u.toString());
                        wr.newLine();
                    }
                    wr.write(user.toString());
                    wr.newLine();
            } catch (IOException e) {
                throw new IllegalArgumentException("Не удалось записать в файл нового пользователя");
            }
        }
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Path.of(fileName))){
            String line = br.readLine();
            while (line != null) {
                User newUser = getUser(line);
                users.add(newUser);
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Файл пуст");
        } finally {
            return users;
        }
    }

    @Override
    public User findById(String id) {
        List<User> users = findAll();
        Optional<User> user = users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();
        if (user.isEmpty()) {
            throw new NullPointerException("Пользователя с заданным идентификатором не существует");
        }
        return user.orElse(null);
    }

    @Override
    public void updateUser(User user) {
        List<User> users = findAll();
        try {
            User userToChange = findById(user.getId());
            userToChange.setLogin(user.getLogin());
            userToChange.setFirstName(user.getFirstName());
            userToChange.setLastName(user.getLastName());
            userToChange.setPassword(user.getPassword());
            userToChange.setConfirmPassword(user.getConfirmPassword());
            userToChange.setWorker(user.isWorker());
            if (user.getMiddleName() != null) {
                userToChange.setMiddleName(user.getMiddleName());
            }
            if (user.getAge() > 0) {
                userToChange.setAge(user.getAge());
            }
            deleteAll();
            users.replaceAll(u -> u.getId().equals(user.getId()) ? userToChange : u);
            users.forEach((this::createUser));
        } catch (NullPointerException e) {
            createUser(user);
        }
    }

    @Override
    public void deleteById(String id) {
        User userToDelete = findById(id);
        if (userToDelete != null) {
            List<User> users = findAll();
            users.remove(userToDelete);
            deleteAll();
            users.forEach((this::createUser));
        }
    }

    @Override
    public void deleteAll() {
        try(BufferedWriter writer = Files.newBufferedWriter(Path.of(fileName))){
            writer.write("");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
