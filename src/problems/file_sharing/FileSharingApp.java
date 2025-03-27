package problems.file_sharing;

import problems.file_sharing.model.File;
import problems.file_sharing.model.User;
import problems.file_sharing.repository.UserRepository;
import problems.file_sharing.service.FileManager;
import problems.file_sharing.service.FollowManager;
import problems.file_sharing.view.FileView;
import problems.file_sharing.view.UserView;

import java.util.List;

public class FileSharingApp {
    public static void main(String[] args) {
        // Initialize users
        User alice = new User("Alice");
        User bob = new User("Bob");
        User charlie = new User("Charlie");

        // Save users to repository
        UserRepository.getInstance().saveUser(alice);
        UserRepository.getInstance().saveUser(bob);
        UserRepository.getInstance().saveUser(charlie);

        // Follow relationships
        FollowManager.getInstance().follow(alice, bob);
        FollowManager.getInstance().follow(bob, alice);
        FollowManager.getInstance().follow(charlie, alice);

        // File sharing
        byte[] dummyContent = "Sample content".getBytes();
        FileManager.getInstance().shareFile(
                alice,
                List.of(bob, charlie),
                "document.txt",
                dummyContent
        );

        // Display information
        UserView userView = new UserView();
        userView.displayUserInfo(charlie);

        FileView fileView = new FileView();
        for (File file:charlie.getFiles()) {
            fileView.displayFileInfo(file);

        }
    }
}
