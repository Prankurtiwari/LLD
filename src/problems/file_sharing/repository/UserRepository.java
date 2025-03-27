package problems.file_sharing.repository;

import problems.file_sharing.model.User;

import java.util.*;

public class UserRepository {
    private static volatile UserRepository instance;
    private final Map<UUID, User> users = new HashMap<>();

    private UserRepository() {}

    public static UserRepository getInstance() {
        if (instance == null) {
            synchronized (UserRepository.class) {
                if (instance == null) {
                    instance = new UserRepository();
                }
            }
        }
        return instance;
    }

    public void saveUser(User user) {
        users.put(user.getId(), user);
    }

    public User getUser(UUID id) {
        return users.get(id);
    }
}
