package io.pivotal.literx.domain;

import reactor.util.function.Tuple3;

import java.util.Locale;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class User {

    public static final User SKYLER = new User("swhite", "Skyler", "White");
    public static final User JESSE = new User("jpinkman", "Jesse", "Pinkman");
    public static final User WALTER = new User("wwhite", "Walter", "White");
    public static final User SAUL = new User("sgoodman", "Saul", "Goodman");

    private final String username;
    private final String firstname;
    private final String lastname;

    public User(String username, String firstname, String lastname) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public User(final Tuple3<String, String, String> triple) {
        username = triple.getT1();
        firstname = triple.getT2();
        lastname = triple.getT3();
    }

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (!Objects.equals(username, user.username)) {
            return false;
        }
        if (!Objects.equals(firstname, user.firstname)) {
            return false;
        }
        return Objects.equals(lastname, user.lastname);

    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + firstname.hashCode();
        result = 31 * result + lastname.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    public User capitalizeNames() {
        requireNonNull(firstname);
        requireNonNull(lastname);
        requireNonNull(username);

        return new User(username.toUpperCase(Locale.ROOT),
                        firstname.toUpperCase(Locale.ROOT),
                        lastname.toUpperCase(Locale.ROOT));
    }
}
