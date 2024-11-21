package user;

import user.User;
import org.apache.commons.lang3.RandomStringUtils;

public class GeneratorUser {
    public static User getUser() {
        return new User(getName(), getEmail(), getValidPassword());
    }

    public static String getName() {
        return RandomStringUtils.randomAlphabetic(10);
    }

    public static String getEmail() {
        return String.format("%s@%s.ru", RandomStringUtils.randomAlphabetic(5),
                RandomStringUtils.randomAlphabetic(4));
    }

    public static String getValidPassword() {
        return RandomStringUtils.randomAlphanumeric(8);
    }

    public static String getInvalidPassword() {
        return RandomStringUtils.randomAlphanumeric(5);
    }
}
