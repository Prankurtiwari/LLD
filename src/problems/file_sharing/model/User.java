package problems.file_sharing.model;

import java.util.*;

public class User {
    private UUID id;
    private String username;
    private Set<User> followers = new HashSet<>();
    private Set<User> following = new HashSet<>();
    private List<File> files = new ArrayList<>();

    public User(String username) {
        this.id = UUID.randomUUID();
        this.username = username;
    }

    // Getters and setters
    public void addFollower(User user) { followers.add(user); }
    public void addFollowing(User user) { following.add(user); }
    public void addFile(File file) { files.add(file); }
    public Set<User> getFollowers() { return Collections.unmodifiableSet(followers); }
    public Set<User> getFollowing() { return Collections.unmodifiableSet(following); }
    public List<File> getFiles() { return Collections.unmodifiableList(files); }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}
