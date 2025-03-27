package problems.file_sharing.model;

import java.util.*;

public class File {
    private UUID id;
    private String fileName;
    private byte[] content;
    private User owner;
    private Set<User> recipients = new HashSet<>();

    public File(String fileName, byte[] content, User owner) {
        this.id = UUID.randomUUID();
        this.fileName = fileName;
        this.content = content;
        this.owner = owner;
    }

    public void addRecipient(User user) { recipients.add(user); }
    public Set<User> getRecipients() { return Collections.unmodifiableSet(recipients); }

    public UUID getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public User getOwner() {
        return owner;
    }
}
