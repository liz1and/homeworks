package ru.innopolis.java.attestation01.model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.regex.Pattern;

public class User {
    private String id; //уникальный ID пользователя, состоит из букв и цифр
    private LocalDateTime date; //дата добавления в систему
    private String login; //не может быть только из цифр, содержит буквы, цифры, знак подчеркивания, меньше 20 символов
    private String password; //не может быть только из букв, содержит буквы, цифры, знак подчеркивания, меньше 20 символов
    private String confirmPassword; //должен совпадать с password
    private String firstName; //имя (только буквы)
    private String lastName; //фамиля (только буквы)
    private String middleName; //отчество (только буквы, может отсутствовать)
    private int age; //возраст, может отсутствовать
    private boolean isWorker; //является ли сотрудником предприятия, по умолчанию false

    public User(String id,  String login, String password, String confirmPassword, String firstName, String lastName) {
        if (! Objects.isNull(id) && ! Objects.isNull(login) && ! Objects.isNull(password)
                && ! Objects.isNull(confirmPassword) && ! Objects.isNull(firstName) && ! Objects.isNull(lastName) ) {
            if (Pattern.matches("[a-zA-Z0-9-]+", id)){
                if (Pattern.matches("\\w+",login) && login.length() < 20){
                    if (Pattern.matches("\\w+",password) && password.length() < 20 && password.equals(confirmPassword)){
                        if (!(firstName.toUpperCase().equals(firstName)) && Pattern.matches("\\D+",firstName)){
                            if (!(lastName.toUpperCase().equals(lastName)) && Pattern.matches("\\D+",lastName)){
                                this.id = id;
                                this.date = LocalDateTime.now();
                                this.login = login;
                                this.password = password;
                                this.confirmPassword = confirmPassword;
                                this.firstName = firstName;
                                this.lastName = lastName;
                                this.isWorker = false;
                            } else {
                                throw new IllegalArgumentException("Некорректная фамилия");
                            }
                        }else {
                            throw new IllegalArgumentException("Некорректное имя");
                        }
                    } else {
                        throw new IllegalArgumentException("Некорректный пароль");
                    }
                }else {
                    throw new IllegalArgumentException("Некорректный логин");
                }
            }
            else {
                throw new IllegalArgumentException("Некорректный id");
            }
        }
        else{
            throw new NullPointerException("Не заполнены обязательные поля");
        }
    }
    public User(String id, LocalDateTime date, String login, String password, String confirmPassword, String firstName, String lastName, String middleName, int age, boolean isWorker) {
        if (! Objects.isNull(id) && ! Objects.isNull(date) && ! Objects.isNull(login) && ! Objects.isNull(password)
                && ! Objects.isNull(confirmPassword) && ! Objects.isNull(firstName) && ! Objects.isNull(lastName)
                && !Objects.isNull(middleName) && ! Objects.isNull(age) && ! Objects.isNull(isWorker)) {
            if (Pattern.matches("[a-zA-Z0-9-]+", id)){
                if (Pattern.matches("\\w+",login) && login.length() < 20){
                    if (Pattern.matches("\\w+",password) && password.length() < 20 && password.equals(confirmPassword)){
                        if (!(firstName.toUpperCase().equals(firstName)) && Pattern.matches("\\D+",firstName)){
                            if (!(lastName.toUpperCase().equals(lastName)) && Pattern.matches("\\D+",lastName)){
                                if (!(middleName.toUpperCase().equals(middleName)) && Pattern.matches("\\D+",middleName)){
                                    if (age > 0) {
                                        this.id = id;
                                        this.date = date;
                                        this.login = login;
                                        this.password = password;
                                        this.confirmPassword = confirmPassword;
                                        this.firstName = firstName;
                                        this.lastName = lastName;
                                        this.middleName = middleName;
                                        this.age = age;
                                        this.isWorker = isWorker;
                                    } else {
                                        throw new IllegalArgumentException("Некорректный возраст");
                                    }
                                } else {
                                    throw new IllegalArgumentException("Некорректное отчество");
                                }
                            } else {
                                throw new IllegalArgumentException("Некорректная фамилия");
                            }
                        }else {
                            throw new IllegalArgumentException("Некорректное имя");
                        }
                    } else {
                        throw new IllegalArgumentException("Некорректный пароль");
                    }
                }else {
                    throw new IllegalArgumentException("Некорректный логин");
                }
            }
            else {
                throw new IllegalArgumentException("Некорректный id");
            }
        }
        else{
            throw new NullPointerException("Не заполнены обязательные поля");
        }
    }

    public String getId() { return id; }
    public void setId(String id) {
        if (!Objects.isNull(id) && Pattern.matches("[a-zA-Z0-9-]+", id)) {
                this.id = id;
        }
        else {
            throw new IllegalArgumentException("Некорректный id");
        }
    }

    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) {
        if (Objects.isNull(date)) {
            this.date = LocalDateTime.now();
        }
        else {
            this.date = date;
        }
    }

    public String getLogin() { return login; }
    public void setLogin(String login) {
        if (!Objects.isNull(login) && Pattern.matches("\\w+",login) && login.length() < 20) {
            this.login = login;
        }
        else {
            throw new IllegalArgumentException("Некорректный логин");
        }
    }

    public String getPassword() { return password;}
    public void setPassword(String password) {
        if (!Objects.isNull(password) && Pattern.matches("\\w+",password) && password.length() < 20) {
            this.password = password;
        } else {
            throw new IllegalArgumentException("Некорректный пароль");
        }
    }

    public String getConfirmPassword() { return confirmPassword; }
    public void setConfirmPassword(String confirmPassword) {
        if (!Objects.isNull(confirmPassword) && confirmPassword.equals(password)) {
            this.confirmPassword = confirmPassword;
        } else {
            throw new IllegalArgumentException("Некорректное подтверждение пароля");
        }
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) {
        if (!Objects.isNull(firstName) && !(firstName.toUpperCase().equals(firstName)) && Pattern.matches("\\D+",firstName)) {
            this.firstName = firstName;
        } else {
            throw new IllegalArgumentException("Некорректное имя");
        }
    }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) {
        if (!Objects.isNull(lastName) && !(lastName.toUpperCase().equals(lastName)) && Pattern.matches("\\D+",lastName)) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException("Некорректная фамилия");
        }
    }

    public String getMiddleName() { return middleName; }
    public void setMiddleName(String middleName) {
        if (Objects.isNull(lastName)) {
            this.middleName = null;
        } else {
            if (!(middleName.toUpperCase().equals(middleName)) && Pattern.matches("\\D+", middleName)) {
                this.middleName = middleName;
            } else {
                throw new IllegalArgumentException("Некорректное отчество");
            }
        }
    }

    public int getAge() { return age; }
    public void setAge(int age) {
        if (Objects.isNull(age)) {
            this.age = 0;
        } else {
            if (age > 0) {
                this.age = age;
            } else {
                throw new IllegalArgumentException("Некорректный возраст");
            }
        }
    }

    public boolean isWorker() { return isWorker; }
    public void setWorker(boolean isWorker) { this.isWorker = isWorker; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return id + '|' +
                date + '|' +
                login + '|' +
                password + '|' +
                confirmPassword + '|' +
                firstName + '|' +
                lastName + '|' +
                middleName + '|' +
                age +  '|' +
                isWorker;
    }
}
