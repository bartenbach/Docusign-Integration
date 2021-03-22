package edu.unomaha.docusign.user;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "username", length = 16, nullable = false, unique = true)
    private String username;

    @Column(name = "password", length = 50, nullable = false, unique = false)
    private String password;

    @Column(name = "logged_in", length = 1, nullable = false, unique = false)
    private boolean loggedIn;

    public UserEntity() {
    }

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
        this.loggedIn = false;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity)) return false;
        UserEntity user = (UserEntity) o;
        return Objects.equals(username, user.username) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, loggedIn);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", loggedIn=" + loggedIn +
                '}';
    }
}
