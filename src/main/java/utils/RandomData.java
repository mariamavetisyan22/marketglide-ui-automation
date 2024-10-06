package utils;

import com.github.javafaker.Faker;

public abstract class RandomData {

    private final static Faker faker = new Faker();

    public static String getRandomName() { return faker.name().fullName(); }
}
