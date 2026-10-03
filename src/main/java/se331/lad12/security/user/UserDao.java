package se331.lad12.security.user;

public interface UserDao {
    User findByUsername(String username);

    User save(User user);
}