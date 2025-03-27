package problems.file_sharing.service;

import problems.file_sharing.controller.UserController;
import problems.file_sharing.model.User;

public class FollowManager {
    private static volatile FollowManager instance;
    private final UserController userController = UserController.getInstance();

    private FollowManager() {}

    public static FollowManager getInstance() {
        if (instance == null) {
            synchronized (FollowManager.class) {
                if (instance == null) {
                    instance = new FollowManager();
                }
            }
        }
        return instance;
    }

    public void follow(User follower, User followee) {
        userController.followUser(follower, followee);
    }
}
