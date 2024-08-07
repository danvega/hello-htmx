package dev.danvega.hellohtmx._04;

import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private static final Logger log = LoggerFactory.getLogger(UserRepository.class);
    private final List<User> users = new ArrayList<>();
    private final Faker faker;

    public UserRepository(Faker faker) {
        this.faker = faker;
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        this.users.add(user);
        return user;
    }

    public User createFakeUser() {
        return new User(faker.name().fullName(), faker.job().title(), faker.internet().emailAddress(), "User");
    }

    @PostConstruct
    private void init() {
        List<User> fakers = List.of(createFakeUser(), createFakeUser(), createFakeUser());
        users.addAll(fakers);
    }

}
