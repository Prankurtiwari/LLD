package problems.file_sharing.view;

import problems.file_sharing.model.User;

public class UserView {
    public void displayUserInfo(User user) {
        System.out.println("User: " + user.getUsername());
        System.out.println("Followers: " + user.getFollowers().size());
        System.out.println("Following: " + user.getFollowing().size());
        System.out.println("Files: " + user.getFiles().size());
    }
}
