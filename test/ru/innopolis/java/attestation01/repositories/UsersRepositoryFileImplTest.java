package ru.innopolis.java.attestation01.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.innopolis.java.attestation01.model.User;

import java.util.List;

class UsersRepositoryFileImplTest {

    private static final String TEST_FILE_NAME = "src/ru/innopolis/java/attestation01/test_users.txt";
    private UsersRepositoryFileImpl repository;

    @BeforeEach
    void setUp() {
        repository = new UsersRepositoryFileImpl(TEST_FILE_NAME);
    }

    @Test
    void testCreateUser() {
        repository.deleteAll();
        User user = new User("abc123", "user_123", "Password123_", "Password123_", "Аня", "Алексеева");
        repository.createUser(user);

        List<User> users = repository.findAll();
        Assertions.assertEquals(1, users.size());
        Assertions.assertEquals(user.getId(), users.get(0).getId());
    }

    @Test
    void testFindAll() {
        repository.deleteAll();
        User user1 = new User("abc123", "user_123", "Password123_", "Password123_", "Аня", "Алексеева");
        User user2 = new User("def456", "user_456", "Password456_", "Password456_", "Алексей", "Алексеев");
        repository.createUser(user1);
        repository.createUser(user2);

        List<User> users = repository.findAll();
        Assertions.assertEquals(2, users.size());
        Assertions.assertTrue(users.stream().anyMatch(u -> u.getId().equals("abc123")));
        Assertions.assertTrue(users.stream().anyMatch(u -> u.getId().equals("def456")));
    }

    @Test
    void testFindById() {
        User user1 = new User("abc123", "user_123", "Password123_", "Password123_", "Аня", "Алексеева");
        User user2 = new User("def456", "user_456", "Password456_", "Password456_", "Алексей", "Алексеев");
        repository.createUser(user1);
        repository.createUser(user2);

        User foundUser = repository.findById("abc123");
        Assertions.assertNotNull(foundUser);
        Assertions.assertEquals(user1.getId(), foundUser.getId());

        Assertions.assertThrows(NullPointerException.class, () -> repository.findById("non_existent_id"));
    }

    @Test
    void testUpdateUserWithInvalidLogin() {
        repository.deleteAll();
        User user = new User("abc123", "user_123", "Password123_", "Password123_", "Аня", "Алексеева");
        repository.createUser(user);

        User updatedUser = new User("abc123", " mylogin", "NewPassword123_", "NewPassword123_", "Алексей", "Алексеев");
        repository.updateUser(updatedUser);

        List<User> users = repository.findAll();
        Assertions.assertEquals(1, users.size());
        Assertions.assertEquals(updatedUser.getLogin(), users.get(0).getLogin());
        Assertions.assertEquals(updatedUser.getFirstName(), users.get(0).getFirstName());
        Assertions.assertEquals(updatedUser.getLastName(), users.get(0).getLastName());
        Assertions.assertEquals(updatedUser.getPassword(), users.get(0).getPassword());
        Assertions.assertEquals(updatedUser.getConfirmPassword(), users.get(0).getConfirmPassword());
    }


}